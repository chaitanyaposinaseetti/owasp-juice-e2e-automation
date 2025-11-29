package com.sgs.owasp.base;

import com.sgs.owasp.config.ConfigReader;
import com.sgs.owasp.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Get driver from DriverManager and assign to class variable
        driver = DriverManager.getDriver();

        // Navigate to application URL
        driver.get(ConfigReader.getAppUrl());
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver
        DriverManager.quitDriver();
    }
}