package com.marco.cqrs.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan({"org.axonframework.eventhandling.tokenstore.jpa", "com.marco.cqrs.model"})
public class JpaConfig {

}
