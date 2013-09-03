package com.prototest.jgolem.framework;

/**
 * Created with IntelliJ IDEA.
 * User: rizza
 * Date: 8/22/13
 * Time: 8:42 AM
 * To change this template use File | Settings | File Templates.
 */
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class TestBase {
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
        driver = new WebDriverBrowser().launchBrowser(WebDriverBrowser.Browser.Firefox);
    }

    public void quitBrowser() {
        driver.quit();
    }
}
