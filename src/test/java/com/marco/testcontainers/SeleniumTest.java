package com.marco.testcontainers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class SeleniumTest {
    private static final Logger log = LoggerFactory.getLogger(Testcontainers.class);

    @Container
    private BrowserWebDriverContainer chrome =
            new BrowserWebDriverContainer()
                    .withCapabilities(new ChromeOptions());


    @Test
    void is_chrome_browser() {
        Assertions.assertEquals(chrome.getWebDriver().getCapabilities().getBrowserName(), "chrome");

        log.info("#### {}", chrome.getWebDriver().getCapabilities().getBrowserName());
    }

    @Test
    void visit_kitchen_sink_cypress() {
        chrome.getWebDriver()
                .get("https://example.cypress.io/");

        Assertions.assertEquals("Cypress.io: Kitchen Sink", chrome.getWebDriver().getTitle());

        log.info("### Title: {}", chrome.getWebDriver().getTitle());
    }
}
