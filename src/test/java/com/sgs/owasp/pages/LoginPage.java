
package com.sgs.owasp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators - Email, Password, LoginBtn
    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//div[contains(@id,'login-form')]");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Enters the email address in the email field
     *
     * @return LoginPage object for method chaining
     */
    public LoginPage enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    /**
     * Enters the password in the password field
     *
     * @return LoginPage object for method chaining
     */
    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    // click login button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    /**
     * Performs complete login action with email and password
     *
     * @param email    - User's email address
     * @param password - User's password
     */
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
