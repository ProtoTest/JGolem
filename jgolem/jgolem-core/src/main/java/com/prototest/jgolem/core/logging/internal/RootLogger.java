package com.prototest.jgolem.core.logging.internal;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import java.util.Arrays;
import java.util.List;

@Plugin(name = "root", category = "Core", printObject = true)
public class RootLogger extends LoggerConfig {

    public RootLogger(String name, List<AppenderRef> appenders, Filter filter, Level level, boolean additive, Property[] properties, Configuration config, boolean includeLocation) {
        super(name, appenders, filter, level, additive, properties, config, includeLocation);
    }

    @PluginFactory
    public static LoggerConfig createLogger(@PluginAttribute(value = "additivity", defaultBoolean = true) boolean additivity,
                                            @PluginAttribute(value = "level", defaultString = "INFO") Level level,
                                            @PluginElement("AppenderRef") AppenderRef[] refs,
                                            @PluginElement("Filters") Filter filter) {
        List<AppenderRef> appenderRefs = Arrays.asList(refs);
        return new com.prototest.jgolem.core.logging.internal.RootLogger(LogManager.ROOT_LOGGER_NAME, appenderRefs, filter, level, additivity, null, (Configuration)null, true);
    }
}