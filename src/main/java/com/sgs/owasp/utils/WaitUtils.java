package com.sgs.owasp.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for explicit waits in Selenium tests
 * Provides reusable wait methods for common scenarios
 *
 * @author Krishna (SGS Testing World)
 */
public class WaitUtils {

    private WebDriverWait wait;

    /**
     * Constructor to initialize WaitUtils with WebDriver and timeout
     * @param driver - WebDriver instance
     * @param timeoutInSeconds - Maximum wait time in seconds
     */
    public WaitUtils(WebDriver driver, int timeoutInSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    /**
     * Wait for element to be visible on the page
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
     * Useful for verifying page navigation
     * @param urlFragment - Text expected in URL
     */
    public void waitForUrlContains(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }

    /**
     * Wait for element to be present in DOM
     * Element may not be visible but should exist in page source
     * @param locator - Element locator
     * @return WebElement when present
     */

    public WebElement waitForElementPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}