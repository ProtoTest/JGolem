package com.prototest.appium;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 1:02 PM
 * TestBase Class for appium Tests
 */

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.net.URL;


public class appiumTestBase {
    private static  WebDriver driver;
    //private static appiumConfig config = null;

    @BeforeTest
    public void setUp() throws Exception {
        System.out.println("Running Setup");
        launchBrowser();
    }

    private void launchBrowser() throws Exception{
        //File app = new File("/Users/sethurban/Library/Developer/Xcode/DerivedData/Makr-befpvxvsgmahpqdksdsvaliefidx/Build/Products/Debug-iphonesimulator/Makr.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability(CapabilityType.VERSION, "6.1");
        capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
        //capabilities.setCapability("app", app.getAbsolutePath());

        driver = new RemoteWebDriver(new URL("http://192.168.1.101:4723/wd/hub"), capabilities);
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
