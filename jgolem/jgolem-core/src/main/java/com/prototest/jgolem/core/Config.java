package com.prototest.jgolem.core;

import org.apache.commons.configuration.*;

import java.io.File;

public abstract class Config {

    private int threadCount;

    private void initializeDefaultProperties() {
        threadCount = config.getInt("threadCount");
    }

    private final static String DEFAULT_CONFIG_LOCATION = "config.properties";
    private final static String CONFIG_LOCATION_PROPERTY = "golem.config";
    private final Configuration config;

    public Config() {
        PropertiesConfiguration coreDefaults;
        PropertiesConfiguration subModuleDefaults;
        PropertiesConfiguration userConfiguration = null;

        SystemConfiguration systemConfiguration = new SystemConfiguration();

        try {
            // Load the core module default properties.
            coreDefaults = new PropertiesConfiguration("core_defaults.properties");
            subModuleDefaults = new PropertiesConfiguration(getDefaultConfigurationLocation());
            // If the system properties contain the CONFIG_LOCATION_PROPERTY key, use its value as the user config location.
            String userConfigLocation = systemConfiguration.containsKey(CONFIG_LOCATION_PROPERTY) ?
                    systemConfiguration.getString(CONFIG_LOCATION_PROPERTY) : DEFAULT_CONFIG_LOCATION;
            // Check if the user config file is a JAR resource or a filesystem location.
            if (new File(userConfigLocation).exists() || getClass().getResource(userConfigLocation) != null) {
                userConfiguration = new PropertiesConfiguration(userConfigLocation);
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't load configuration: " + e.getMessage(), e);
        }


        CompositeConfiguration configBuilder = new CompositeConfiguration();
        configBuilder.addConfiguration(coreDefaults);
        configBuilder.addConfiguration(subModuleDefaults);
        if (userConfiguration != null) configBuilder.addConfiguration(userConfiguration);
        configBuilder.addConfiguration(systemConfiguration);
        this.config = configBuilder;

        initializeDefaultProperties();
    }



    protected abstract String getDefaultConfigurationLocation();

    public int getThreadCount() {
        return threadCount;
    }
}
