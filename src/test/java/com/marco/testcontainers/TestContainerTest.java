package com.marco.testcontainers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class TestContainerTest {
    private static final Logger log = LoggerFactory.getLogger(Testcontainers.class);

    @Container
    private PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer()
            .withDatabaseName("giftcard-test")
            .withUsername("giftcard")
            .withPassword("secret");

    @Test
    void test_container_up() {
        Assertions.assertTrue(postgresqlContainer.isRunning());
        Assertions.assertTrue(postgresqlContainer.getJdbcUrl().contains("giftcard-test"));

        log.info("### JDBC URL {}", postgresqlContainer.getJdbcUrl());
    }

}
