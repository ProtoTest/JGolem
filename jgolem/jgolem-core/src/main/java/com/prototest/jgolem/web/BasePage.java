package com.prototest.jgolem.web;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.prototest.jgolem.core.AutoInjection;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebAutoInjection {

    protected WebDriver getDriver() {
        return driver.get();
    }
}
