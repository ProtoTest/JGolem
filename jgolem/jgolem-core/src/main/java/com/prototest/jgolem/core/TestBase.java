package com.prototest.jgolem.core;

import com.prototest.jgolem.core.logging.internal.GolemLogEventFactory;
import com.prototest.jgolem.core.logging.internal.GolemLoggerConfigurationFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;

public abstract class TestBase {


    private static ThreadLocal<String> testName = new ThreadLocal<>();

    private final String[] reportResources = new String[] {"controllers.js", "style.css", "log.html", "angular.js"};

    private static final File reportDir;
    static {
        System.setProperty("Log4jLogEventFactory", GolemLogEventFactory.class.getName());
        GolemLoggerConfigurationFactory loggerConfigFactory = new GolemLoggerConfigurationFactory();
        ConfigurationFactory.setConfigurationFactory(loggerConfigFactory);

        reportDir = GolemLoggerConfigurationFactory.GolemLog4jConfiguration.OUTPUT_DIR;
    }
    private void configureLogging() {


        for (String resource : reportResources) {
            InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(resource);

            File target = new File(reportDir, resource);
            try {
                Files.copy(resourceStream, target.toPath());
            } catch (IOException e) {
                throw new RuntimeException(String.format("Couldn't write report file: %s", target), e);
            }
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        //Log.info("Running tearDown() after test");
        internalTestTeardown();
    }

    @BeforeMethod
    public void setUp(Method context) throws Exception {
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
