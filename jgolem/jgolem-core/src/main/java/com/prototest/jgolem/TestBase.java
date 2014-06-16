package com.prototest.jgolem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;

@Guice(modules = {})
public class TestBase {
    private static WebDriver driver;
    private static Logger Log = LogManager.getLogger(TestBase.class.getName());

    @AfterTest
    public void tearDown() throws Exception {
        Log.info("Running tearDown() after test");
        quitBrowser();
    }

    @BeforeTest
    public void setUp() throws Exception {
        Log.info("Running setUp before test");
        launchBrowser();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void launchBrowser() {
        driver = new WebDriverBrowser().launchBrowser(WebDriverBrowser.Browser.Firefox);
    }

    public void quitBrowser() {
        driver.quit();
    }
}
