package com.marco.testcontainers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
class IntreTest {

    @Container
    private static BrowserWebDriverContainer chrome =
            new BrowserWebDriverContainer()
                    .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("/tmp/target/"))
                    .withCapabilities(
                            (new ChromeOptions()
                                .addArguments("--no-sandbox")
                                .addArguments("--disable-dev-shm-usage"))
                    );

    private static WebDriver driver;

    private WebElement navMenu;

    @BeforeAll
    static void setUp() {
        driver = chrome.getWebDriver();
        driver.get("https://www.intre.it/");
    }

    @Test
    void CheckNavMenu() {
        navMenu = driver.findElement(By.id("menu-menu-2"));
        assertNotNull(navMenu);
    }

    @Test
    void ClickBlogLink() {
        navMenu = driver.findElement(By.id("menu-menu-2"));
        navMenu.findElement(By.linkText("Blog")).click();

        assertEquals("https://www.intre.it/blog/", driver.getCurrentUrl());
    }

    @Test
    void ApplyForJobPosition() {
        navMenu = driver.findElement(By.id("menu-menu-2"));
        navMenu.findElement(By.linkText("Jobs")).click();

        driver.findElement(By.name("your-name")).sendKeys("Pinco");
        driver.findElement(By.name("your-email")).sendKeys("Pinco@pallino.it");
        driver.findElement(By.name("your-tel")).sendKeys("1234556565");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}