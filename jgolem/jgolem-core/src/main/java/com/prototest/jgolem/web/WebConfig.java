package com.prototest.jgolem.web;

import com.google.inject.Singleton;
import com.prototest.jgolem.core.Config;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;

@Singleton
public class WebConfig extends Config {

    @Override
    protected String getDefaultConfigurationLocation() {
        return "web_defaults.properties";
    }
}
