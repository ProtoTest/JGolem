package com.prototest.jgolem.core.config;

import org.apache.commons.configuration.*;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Config {


    private enum DefaultConverters {
        integer(Integer::parseInt, "Integer", "int");
        private final com.prototest.jgolem.core.PropertyConverter converter;
        private final List<String> typeNames;

        DefaultConverters(com.prototest.jgolem.core.PropertyConverter converter, String... typeNames) {
            this.typeNames = Arrays.asList(typeNames);
            this.converter = converter;
        }

        public static DefaultConverters fromType(Class type) {
            for (DefaultConverters converter : values()) {
                if (converter.typeNames.contains(type.getSimpleName())) {
                    return converter;
                }
            }
            return null;
        }

        public com.prototest.jgolem.core.PropertyConverter getConverter() {
            return converter;
        }
    }


    private final static String DEFAULT_CONFIG_LOCATION = "config.properties";
    private final static String CONFIG_LOCATION_PROPERTY = "golem.config";

    private final Configuration config;

    protected Configuration getConfig() {
        return config;
    }

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

        configureProperties();
    }

    private void configureProperties() {
        List<Class> classChain = new ArrayList<>();
        classChain.add(getClass());
        while (classChain.get(classChain.size() - 1).getSuperclass() != null) {
            classChain.add(classChain.get(classChain.size() - 1).getSuperclass());
        }
        for (Class clazz : classChain) {
            List<Field> propertyFields = getAnnotatedProperties(clazz);

            for (Field propertyField : propertyFields) {
                if (propertyField.getAnnotation(ConfigProperty.class).propertySetter().length > 0) {
                    try {
                        com.prototest.jgolem.core.PropertyConverter converter = propertyField.getAnnotation(ConfigProperty.class).propertySetter()[0].newInstance();
                        setPropertyFromConfig(propertyField, converter);
                    } catch (Exception e) {
                        throw new RuntimeException("Can't set config property " + propertyField.getName(), e);
                    }
                } else {
                    setPropertyFromConfig(propertyField);
                }
            }
        }
    }

    private void setPropertyFromConfig(Field propertyField, com.prototest.jgolem.core.PropertyConverter converter) {
        String propertyName = propertyField.getName();
        String configuredValue = config.getString(propertyName);
        if (configuredValue != null) {
            try {
                propertyField.set(this, converter.convert(configuredValue));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Couldn't set field annotated with ConfigProperty", e);
            }
        }
    }

    private void setPropertyFromConfig(Field propertyField) {
        setPropertyFromConfig(propertyField, DefaultConverters.fromType(propertyField.getType()).getConverter());
    }

    private List<Field> getAnnotatedProperties(Class clazz) {
        List<Field> annotatedFields = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ConfigProperty.class)) {
                annotatedFields.add(field);
            }
        }
        return annotatedFields;
    }

    protected abstract String getDefaultConfigurationLocation();

}
