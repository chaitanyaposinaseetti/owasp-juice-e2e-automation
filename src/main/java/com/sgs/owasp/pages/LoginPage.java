package com.sgs.owasp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By dismissButton = By.cssSelector("button[aria-label='Close Welcome Banner']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void dismissWelcomeBanner() {
        try {
            WebElement dismissBtn = wait.until(ExpectedConditions.elementToBeClickable(dismissButton));
            dismissBtn.click();
            Thread.sleep(500);
        } catch (Exception e) {
            // Banner not present
        }
    }

    public LoginPage enterEmail(String email) {
        dismissWelcomeBanner();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        return this;
    }

    public void clickLogin() {
        try {
            // Scroll to button first
            WebElement loginBtn = driver.findElement(loginButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginBtn);
            Thread.sleep(300);

            // Wait and click
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login(String email, String password) {
        dismissWelcomeBanner();
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}