package com.prototest.jgolem.core;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.message.Message;

import java.util.List;


public class GolemLogEvent extends Log4jLogEvent {
    private final String testName;

    public GolemLogEvent(String loggerName, String testName, Marker marker, String fqcn, Level level, Message data, List<Property> properties, Throwable t) {
        super(loggerName, marker, fqcn, level, data, properties, t);
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }
}
