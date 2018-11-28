package com.marco.cqrs.query;

import com.marco.cqrs.command.IssuedEvt;
import com.marco.cqrs.command.RedeemedEvt;
import com.marco.cqrs.model.CardSummary;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.invoke.MethodHandles;
import java.time.Instant;

import static org.axonframework.eventhandling.GenericEventMessage.asEventMessage;

@Component
public class CardSummaryProjection {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final EntityManager entityManager;

    private final EventBus queryUpdateEventBus;

    public CardSummaryProjection(EntityManager entityManager,
                                 @Qualifier("queryUpdates") EventBus queryUpdateEventBus) {
        this.entityManager = entityManager;
        this.queryUpdateEventBus = queryUpdateEventBus;
    }

    @EventHandler
    public void on(IssuedEvt evt, @Timestamp Instant instant) {
        log.info("Projecting  Event {}", evt);

        entityManager.persist(new CardSummary(evt.getId(), evt.getAmount(), instant, evt.getAmount()));
        queryUpdateEventBus.publish(asEventMessage(new CardSummariesUpdatedEvt(evt.getId())));
    }

    @EventHandler
    public void on(RedeemedEvt evt) {
        log.info("Projecting event {}", evt);

        final CardSummary summary = entityManager.find(CardSummary.class, evt.getId());
        summary.setRemainingValue(summary.getRemainingValue() - evt.getAmount());
        queryUpdateEventBus.publish(asEventMessage(new CardSummariesUpdatedEvt(evt.getId())));
    }

    @QueryHandler
    public FindCardSummariesResponse handle(FindCardSummariesQuery query) {
        log.info("Handling query {}", query);

        final Query jpaQuery = entityManager.createQuery("SELECT c FROM CardSummary c ORDER BY c.id", CardSummary.class);
        jpaQuery.setFirstResult(query.getOffset());
        jpaQuery.setMaxResults(query.getLimit());

        final FindCardSummariesResponse response = new FindCardSummariesResponse(jpaQuery.getResultList());
        log.info("returning {}", response);

        return response;
    }

    @QueryHandler
    public CountCardSummariesResponse handle(CountCardSummariesQuery query) {
        log.info("handling query {}", query);
        final Query jpaQuery = entityManager.createQuery("SELECT COUNT(c) FROM CardSummary c", Long.class);

        final CountCardSummariesResponse response = new CountCardSummariesResponse(((Long) jpaQuery.getSingleResult()));
        log.info("returning {}", response);

        return response;
    }

}
