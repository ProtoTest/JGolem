package com.prototest.jgolem.core;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.prototest.jgolem.web.WebDriverFactory;

public class AutoInjection {
    @Inject
    private static Injector injector;


    protected AutoInjection() {
        injector.injectMembers(this);
    }
}
