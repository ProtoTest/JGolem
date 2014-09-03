package com.prototest.jgolem.web;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.openqa.selenium.WebDriver;

public class BasePage {
    @Inject
    static Injector injector;
    @Inject
    private WebDriverFactory driver;

    public BasePage() {
        injector.injectMembers(this);
    }

    protected WebDriver getDriver() {
        return driver.get();
    }
}
