package com.marco.cqrs.model;

import com.marco.cqrs.command.IssueCmd;
import com.marco.cqrs.command.IssuedEvt;
import com.marco.cqrs.command.RedeemCmd;
import com.marco.cqrs.command.RedeemedEvt;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.invoke.MethodHandles.lookup;
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class GiftCard {

    private final static Logger logger = LoggerFactory.getLogger(lookup().lookupClass());

    @AggregateIdentifier
    private String id;

    private long currentValue;

    public GiftCard() {
        logger.info("Empty constructor invoked");
    }

    @CommandHandler
    public GiftCard(IssueCmd cmd) {
        logger.info("handling {}", cmd);

        if (cmd.getAmount() <= 0L ) {
            throw new IllegalArgumentException("Amount is minus than 0 creation of Gift Card is impossible");
        }

        apply(new IssuedEvt(cmd.getId(), cmd.getAmount()));
    }

    @CommandHandler
    public void handleRedeem(RedeemCmd cmd) {
        logger.info("handling {}", cmd);

        if (cmd.getAmount() <= 0L) {
            throw new IllegalArgumentException("Amount is minus than 0 redeem process is impossible");
        }

        if (cmd.getAmount() > currentValue) {
            throw new IllegalArgumentException("Amount is minus than current value redeem process is impossible");
        }

        apply(new RedeemedEvt(cmd.getId(), cmd.getAmount()));
    }

    @EventSourcingHandler
    public void onIssuedEvent(IssuedEvt evt) {
        logger.info("apply {}", evt);

        id = evt.getId();
        currentValue = evt.getAmount();

        logger.info("Gift Card {}, new value is: {}", id, currentValue);
    }

    @EventSourcingHandler
    public void onRedeemEvent(RedeemedEvt evt) {
        logger.info("apply {}", evt);

        currentValue -= evt.getAmount();

        logger.info("Gift Card {}, new remaining value is: {}", id, currentValue);
    }
}
