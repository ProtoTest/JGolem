package com.prototest.jgolem;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class    TestBase {
    private static WebDriver driver;


    @AfterTest
    public void tearDown() throws Exception {
        System.out.println("Running tearDown");
        quitBrowser();
    }

    @BeforeTest
    public void setUp() throws Exception {
        System.out.println("Running setUp");
        launchBrowser();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void launchBrowser() {
        driver = new WebDriverBrowser().launchBrowser(WebDriverBrowser.Browser.Chrome);
    }

    public void quitBrowser() {
        driver.quit();
    }
}
