package com.prototest.jgolem.core.config;

public class CoreConfig extends Config {

    @ConfigProperty
    public int threadCount;

    @Override
    protected String getDefaultConfigurationLocation() {
        return "core_defaults.properties";
    }
}
