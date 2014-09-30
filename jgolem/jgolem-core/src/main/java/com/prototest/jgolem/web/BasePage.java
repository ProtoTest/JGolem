package com.prototest.jgolem.web;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class BasePage extends WebAutoInjection {

    protected Logger logger = LogManager.getLogger();

    protected WebDriver getDriver() {
        return driver.get();
    }
}
