package com.marco.cqrs.configuration;

import io.axoniq.axondb.client.AxonDBConfiguration;
import io.axoniq.axondb.client.axon.AxonDBEventStore;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EventStoreConfig {

    @Bean
    public AxonDBConfiguration axonDBConfiguration() {
        return new AxonDBConfiguration();
    }

    @Bean
    public Serializer eventSerializer() {
        return new JacksonSerializer();
    }

    @Bean()
    @Primary
    public EventStore eventBus(AxonDBConfiguration axonDBConfiguration, Serializer eventSerializer) {
        return new AxonDBEventStore(axonDBConfiguration, eventSerializer);
    }
}
