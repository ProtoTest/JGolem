package com.prototest.jgolem.web;

import com.google.inject.Inject;
import com.prototest.jgolem.core.AutoInjection;

public class WebAutoInjection extends AutoInjection {
    @Inject
    protected WebDriverFactory driver;
    @Inject
    protected WebConfig config;
}
