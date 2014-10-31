package com.prototest.jgolem.core.config;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CoreConfig extends Config {

    @ConfigProperty
    public int threadCount;

    @Override
    protected String getDefaultConfigurationLocation() {
        return "core_defaults.properties";
    }


}
