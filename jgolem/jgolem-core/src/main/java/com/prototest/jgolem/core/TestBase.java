package com.prototest.jgolem.core;

import com.google.inject.Inject;
import com.prototest.jgolem.web.WebDriverBrowser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class TestBase {

    @AfterTest
    public void tearDown() throws Exception {
        //Log.info("Running tearDown() after test");
        internalTestTeardown();
    }

    @BeforeTest
    public void setUp() throws Exception {
        //Log.info("Running setUp before test");
        internalTestSetup();
    }

    @BeforeSuite
    public void suiteSetup() throws Exception {
        internalSuiteSetup();
    }

    @AfterSuite
    public void suiteTeardown() throws Exception {
        internalSuiteTeardown();
    }

    @BeforeTest
    public void testGroupSetup() throws Exception {
        internalTestGroupSetup();
    }

    @AfterTest
    public void testGroupTeardown() throws Exception {
        internalTestGroupTeardown();
    }

    protected void internalTestGroupTeardown() {

    }

    protected void internalTestGroupSetup() {

    }

    protected void internalSuiteTeardown() {

    }

    protected void internalSuiteSetup() {

    }

    protected void internalTestSetup() {

    }

    protected void internalTestTeardown() {

    }


}
