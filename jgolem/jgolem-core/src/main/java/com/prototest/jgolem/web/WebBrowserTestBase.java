package com.prototest.jgolem.web;

import com.google.inject.Inject;
import com.prototest.jgolem.core.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Guice;

@Guice(modules = WebTestsModule.class)
public class WebBrowserTestBase extends TestBase {
    @Inject
    private WebDriverFactory driver;

    @Override
    protected void internalTestSetup() {
        // TODO: replace with configuration
        driver.build(WebDriverFactory.Browser.Chrome);
    }

    @Override
    protected void internalTestTeardown() {
        driver.get().quit();
        driver.deleteDriver();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

}
