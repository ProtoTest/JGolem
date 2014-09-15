package com.prototest.jgolem.core;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import org.slf4j.LoggerFactory;
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
        configureLogback();
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

    private void configureLogback() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
        FileAppender fileAppender = new FileAppender<ILoggingEvent>();
        fileAppender.setFile("log.log");
        PatternLayoutEncoder pl = new PatternLayoutEncoder();
        pl.setContext(loggerContext);
        pl.setPattern("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
        pl.start();
        //fileAppender.setPa(pl);
        fileAppender.setContext(loggerContext);
        fileAppender.start();
        rootLogger.addAppender(fileAppender);
    }

}
