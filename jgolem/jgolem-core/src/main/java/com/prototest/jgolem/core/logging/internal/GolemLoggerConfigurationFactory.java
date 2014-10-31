package com.prototest.jgolem.core.logging.internal;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.*;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.JsonLayout;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;


@Plugin(category = "ConfigurationFactory", name = "Log4j2ConfigurationFactory")
@Order(0)
public class GolemLoggerConfigurationFactory extends ConfigurationFactory {
    @Override
    protected String[] getSupportedTypes() {
        return null;
    }

    @Override
    public Configuration getConfiguration(String name, URI configLocation) {
        return new GolemLog4jConfiguration();
    }

    @Override
    public Configuration getConfiguration(ConfigurationSource source) {
        return new GolemLog4jConfiguration();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static class GolemLog4jConfiguration extends AbstractConfiguration {

        /**
         * The name of the default configuration.
         */
        public static final String DEFAULT_NAME = "Default";
        /**
         * The System Property used to specify the logging level.
         */
        public static final String DEFAULT_LEVEL = "org.apache.logging.log4j.level";
        /**
         * The default Pattern used for the default Layout.
         */
        public static final String DEFAULT_PATTERN = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n";

        public static final File OUTPUT_DIR;

        static {
            // Setup timestamped report directory.
            SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd__HH_mm");
            File parentDir = new File("report");
            OUTPUT_DIR = new File(parentDir, format.format(new Date()));
            if (!parentDir.exists()) {
                parentDir.mkdir();
            } else if (parentDir.isFile()) {
                parentDir.delete();
                parentDir.mkdir();
            }
            if (OUTPUT_DIR.exists()) {
                OUTPUT_DIR.delete();
            }
            OUTPUT_DIR.mkdir();
        }

        public GolemLog4jConfiguration() {
            super(ConfigurationSource.NULL_SOURCE);


            setName(DEFAULT_NAME);
            final Layout<? extends Serializable> layout = PatternLayout.newBuilder()
                    .withPattern(DEFAULT_PATTERN)
                    .withConfiguration(this)
                    .build();
            final Appender consoleAppender =
                    ConsoleAppender.createAppender(layout, null, "SYSTEM_OUT", "Console", "false", "true");
            consoleAppender.start();
            addAppender(consoleAppender);


            JsonLayout jsonLayout = (JsonLayout) JsonLayout.createLayout(true, true, true, false, null);
            FileAppender jsonFileAppender = FileAppender.createAppender(new File(OUTPUT_DIR, "log.json").getAbsolutePath(), "true", "true", "TestNG", "true", "false", "true", null, jsonLayout, null, "false", "false", this);
            jsonFileAppender.start();
            addAppender(jsonFileAppender);
            final LoggerConfig root = getRootLogger();
            root.addAppender(jsonFileAppender, null, null);
            root.addAppender(consoleAppender, null, null);
            root.setLevel(Level.INFO);
        }

        @Override
        protected void doConfigure() {

        }
    }
}
