package com.prototest.jgolem.core;

import com.prototest.jgolem.core.logging.internal.GolemLogEventFactory;
import com.prototest.jgolem.core.logging.internal.GolemLoggerConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class TestBase {

    static {
        configureLogging();
    }

    private static ThreadLocal<String> testName = new ThreadLocal<>();

    private static void configureLogging() {
        System.setProperty("Log4jLogEventFactory", GolemLogEventFactory.class.getName());
        ConfigurationFactory.setConfigurationFactory(new GolemLoggerConfigurationFactory());


    }
    @AfterTest
    public void tearDown() throws Exception {
        //Log.info("Running tearDown() after test");
        internalTestTeardown();
    }

    @BeforeTest
    public void setUp(ITestContext context) throws Exception {
        //Log.info("Running setUp before test");
        setTestName(context.getName());
        internalTestSetup();
    }

    private void setTestName(String name) {
        testName.set(name);
    }

    private void clearTestName() {
        testName.remove();
    }

    public static String getCurrentTestName() {
        return testName.get();
    }

    @BeforeSuite
    public void suiteSetup() throws Exception {
        configureLogging();
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
