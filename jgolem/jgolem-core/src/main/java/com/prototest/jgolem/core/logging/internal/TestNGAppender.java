package com.prototest.jgolem.core.logging.internal;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.filter.RegexFilter;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.testng.Reporter;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class TestNGAppender extends AbstractAppender {
    public TestNGAppender(String name, Layout layout) {
        super(name, null, layout);
    }

    @Override
    public void append(LogEvent logEvent) {
        Reporter.log((String) (getLayout()).toSerializable(logEvent));
    }
}