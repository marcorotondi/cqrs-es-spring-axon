package com.marco.cqrs.configuration;

import com.marco.cqrs.query.CardSummaryProjection;
import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.saga.repository.SagaStore;
import org.axonframework.eventhandling.saga.repository.inmemory.InMemorySagaStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Autowired
    public void configure(EventProcessingConfiguration configuration) {
        configuration.registerTrackingEventProcessor(CardSummaryProjection.class.getPackage().getName());
    }

    @Bean
    @Qualifier("queryUpdates")
    public EventBus queryUpdateEventBus() {
        return new SimpleEventBus();
    }

    @Bean
    public SagaStore sagaStore() {
        return new InMemorySagaStore();
    }
}
