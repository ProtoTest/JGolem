package com.prototest.jgolem.web;

import com.google.inject.Inject;
import com.prototest.jgolem.core.TestBase;
import com.prototest.jgolem.core.VerificationsListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;

@Listeners({VerificationsListener.class})
@Guice(modules = WebTestsModule.class)
public class WebBrowserTestBase extends TestBase {
    @Inject
    private WebDriverFactory driver;

    @Inject
    private WebConfig config;

    @Override
    protected void internalTestSetup() {
        driver.build(config.defaultBrowser);
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
