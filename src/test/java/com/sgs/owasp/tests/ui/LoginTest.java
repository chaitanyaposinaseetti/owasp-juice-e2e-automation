package com.sgs.owasp.tests.ui;

import com.sgs.owasp.base.BaseTest;
import com.sgs.owasp.pages.LoginPage;
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

        // Temporary wait to see the result
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}