package com.prototest.jgolem.web;

import com.google.inject.AbstractModule;


/**
 */
public class WebTestsModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(WebDriverFactory.class);
        requestStaticInjection(Element.class, BasePage.class);
    }
}
