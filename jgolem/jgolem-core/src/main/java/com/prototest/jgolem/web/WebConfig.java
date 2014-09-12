package com.prototest.jgolem.web;

import com.google.inject.Singleton;
import com.prototest.jgolem.core.config.Config;
import com.prototest.jgolem.core.config.ConfigProperty;
import com.prototest.jgolem.core.config.CoreConfig;
import com.prototest.jgolem.core.PropertyConverter;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;

@Singleton
public class WebConfig extends CoreConfig {

    @ConfigProperty(propertySetter = WebBrowserConverter.class)
    public WebBrowser defaultBrowser;

    @Override
    protected String getDefaultConfigurationLocation() {
        return "web_defaults.properties";
    }

    public static class WebBrowserConverter implements PropertyConverter {
        @Override
        public Object convert(String value) {
            return WebBrowser.fromString(value);
        }
    }

}
