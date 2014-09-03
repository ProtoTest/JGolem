package com.prototest.jgolem.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverBrowser {
    public enum Browser {Firefox, Chrome, IE, Safari, Android, Iphone}

    ;
    private WebDriver driver;
    private static Logger Log = LogManager.getLogger(WebDriverBrowser.class.getName());

    public WebDriver launchBrowser(Browser browser) {
        switch (browser) {
            case Chrome:
                driver = startChromeBrowser();
                break;
            case IE:
                driver = startIEBrowser();
                break;
            case Safari:
                driver = startSafariBrowser();
                break;
            case Firefox:
            default:
                driver = startFirefoxBrowser();
                break;
        }

        Log.debug("launchBrowser(): Using browser = " + browser.toString());
        driver.manage().deleteAllCookies();
        EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
        return WebDriverEvents.RegisterEvents(eDriver);
    }


    public DesiredCapabilities GetCapabilitiesForBrowser(Browser browser) {
        switch (browser) {
            case IE:
                return DesiredCapabilities.internetExplorer();
            case Chrome:
                return DesiredCapabilities.chrome();
            case Safari:
                return DesiredCapabilities.safari();
            case Android:
                return DesiredCapabilities.android();
            case Firefox:
            default:
                return DesiredCapabilities.firefox();
        }
    }

    public WebDriver LaunchRemoteBrowser(Browser browser, String host) {
        DesiredCapabilities desiredCapabilities = GetCapabilitiesForBrowser(browser);
        try {
            URL remoteAddress = new URL("http://" + host + ":4444/wd/hub");
            //return new EventedWebDriver(new RemoteWebDriver(remoteAddress, desiredCapabilities)).driver;
        } catch (MalformedURLException e) {
            Log.error(e.getMessage());
        }
        return null;
    }

    public WebDriver LaunchAppDriver(String appPath, String package_str, String activity) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("app", appPath);
        capabilities.setCapability("app-package", package_str);
        capabilities.setCapability("app-activity", activity);

        /*EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
        return eDriver.getWrappedDriver();*/
        return null;
    }

    private WebDriver startSafariBrowser() {
        SafariOptions options = new SafariOptions();
        return new SafariDriver(options);
    }

    private WebDriver startIEBrowser() {
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        return new InternetExplorerDriver(ieCapabilities);
    }

    private void setChromeDriverPath() {
        String currentModulePath = System.getProperty("user.dir");
        int index = currentModulePath.lastIndexOf("/");
        String thisModuleName = currentModulePath.substring(index);
        String chromePath = currentModulePath.replace(thisModuleName, "/jgolem-core/chromedriver");

        System.setProperty("webdriver.chrome.driver", chromePath);
    }

    private WebDriver startChromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        setChromeDriverPath();

        return new ChromeDriver();
    }

    private WebDriver startFirefoxBrowser() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        return new FirefoxDriver();
    }

}
