package com.prototest.jgolem.web;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;

/**
 */
public class WebDriverFactory {
    @Inject
    Injector injector;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public enum Browser {
        Firefox, Chrome, IE, Safari, Android, Iphone;

        public static Browser fromString(String name) {
            for (Browser browser : values()) {
                if (browser.name().compareToIgnoreCase(name) == 0) {
                    return browser;
                }
            }
            return null;
        }
    }

    public WebDriver build(Browser browser) {
        if (driver.get() == null) {
            switch (browser) {
                case Chrome:
                    driver.set(startChromeBrowser());
                    break;
                case IE:
                    driver.set(startIEBrowser());
                    break;
                case Safari:
                    driver.set(startSafariBrowser());
                    break;
                case Firefox:
                default:
                    driver.set(startFirefoxBrowser());
                    break;
            }
        }
        return driver.get();

    }

    private WebDriver startSafariBrowser() {
        SafariOptions options = new SafariOptions();
        return new SafariDriver(options);
    }

    private WebDriver startIEBrowser() {
        setIEDriverPath();
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        return new InternetExplorerDriver(ieCapabilities);
    }

    private void setChromeDriverPath() {
        String currentModulePath = null;
        try {
            currentModulePath = new java.io.File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String chromePath = currentModulePath += "/chromedriver";

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            chromePath = chromePath + ".exe";
        }
        System.setProperty("webdriver.chrome.driver", chromePath);
    }

    private void setIEDriverPath() {
        String currentModulePath = null;
        try {
            currentModulePath = new java.io.File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String iePath = currentModulePath += "\\IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", iePath);
    }

    private WebDriver startChromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        //setChromeDriverPath();

        return new ChromeDriver();
    }

    private WebDriver startFirefoxBrowser() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        return new FirefoxDriver();
    }

    public WebDriver get() {
        return driver.get();
    }

    public void deleteDriver() {
        driver.remove();
    }
}
