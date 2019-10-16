package com.marco.testcontainers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class TestContainerTest {

    @Container
    private PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer()
            .withDatabaseName("giftcard-test")
            .withUsername("giftcard")
            .withPassword("secret");

    @Test
    void test_container_up() {
        Assertions.assertTrue(postgresqlContainer.isRunning());
        Assertions.assertTrue(postgresqlContainer.getJdbcUrl().contains("giftcard-test"));
    }

}
