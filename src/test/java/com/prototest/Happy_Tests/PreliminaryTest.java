package com.prototest.Happy_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;


/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 9:02 AM
 * Testing to see if I can remotely connect to macbook from windows box and find Happy_Tests buttons
 * using the pre-existing Jgolem package
 */
public class PreliminaryTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception{
        //File app = new File("/Users/sethurban/Library/Developer/Xcode/DerivedData/Makr-befpvxvsgmahpqdksdsvaliefidx/Build/Products/Debug-iphonesimulator/Makr.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability(CapabilityType.VERSION, "6.1");
        capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
        //capabilities.setCapability("app", app.getAbsolutePath());

        driver = new RemoteWebDriver(new URL("http://192.168.1.101:4723/wd/hub"), capabilities);
    }

    @Test
    public void HappyTest() throws Exception {
        /*Element BusinessButton = new Element("BusinessButton", By.name("BUSINESS"));
        BusinessButton.click();*/
        WebElement BusinessButton = driver.findElement(By.name("BUSINESS"));
        BusinessButton.click();
    }

    @AfterClass
    public void TearDown() throws Exception{
        driver.quit();
    }


}
