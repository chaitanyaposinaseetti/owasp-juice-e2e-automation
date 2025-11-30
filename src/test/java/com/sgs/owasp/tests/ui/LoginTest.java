package com.sgs.owasp.tests.ui;

import com.sgs.owasp.base.BaseTest;
import com.sgs.owasp.pages.LoginPage;
import com.sgs.owasp.utils.WaitUtils;
import org.testng.annotations.Test;

/**
 * Test class for Login functionality on OWASP Juice Shop
 * Extends BaseTest to inherit setup and teardown methods
 */
public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        // Navigate to login page
        driver.get("http://localhost:3001/#/login");

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login with valid credentials
        loginPage.login("admin@juice-sh.op", "admin123");

        // Use explicit wait instead of Thread.sleep
        WaitUtils waitUtils = new WaitUtils(driver, 10);
        waitUtils.waitForUrlContains("search");  // Wait for redirect after login
    }

    //@Test
    /* public void testInvalidLogin() {
        // Navigate to login page
        driver.get("http://localhost:3001/#/login");

        // Create LoginPage and WaitUtils
        LoginPage loginPage = new LoginPage(driver);
        WaitUtils waitUtils = new WaitUtils(driver, 10);

        // Perform login with invalid credentials
        loginPage.login("invalid@test.com", "wrongpassword");

        // Wait a moment to see error message (we'll add assertion later)
        waitUtils.waitForUrlContains("login");  // Should stay on login page
    }*/
}