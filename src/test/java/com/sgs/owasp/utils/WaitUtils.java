package com.sgs.owasp.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for explicit waits in Selenium tests
 */
public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor to initialize WaitUtils
     * @param driver - WebDriver instance
     * @param timeoutInSeconds - Maximum wait time
     */
    public WaitUtils(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    /**
     * Wait for element to be visible
     * @param locator - Element locator
     * @return WebElement when visible
     */
    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for element to be clickable
     * @param locator - Element locator
     * @return WebElement when clickable
     */
    public WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait for URL to contain specific text
     * @param urlFragment - Text to wait for in URL
     */
    public void waitForUrlContains(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));  // ✅ No quotes!
    }
}