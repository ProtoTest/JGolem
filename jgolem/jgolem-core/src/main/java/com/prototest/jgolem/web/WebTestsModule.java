package com.prototest.jgolem.web;

import com.google.inject.AbstractModule;
import com.prototest.jgolem.core.config.Config;
import com.prototest.jgolem.core.CoreModule;


/**
 */
public class WebTestsModule extends CoreModule {


    @Override
    protected void doConfiguration() {
        bind(WebDriverFactory.class);
        bind(WebConfig.class).toInstance(new WebConfig());
    }
}
