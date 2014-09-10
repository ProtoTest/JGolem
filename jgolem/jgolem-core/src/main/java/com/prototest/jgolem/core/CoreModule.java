package com.prototest.jgolem.core;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;

public abstract class CoreModule extends AbstractModule {
    @Override
    protected void configure() {

        doConfiguration();
        requestStaticInjection(AutoInjection.class);

    }

    protected abstract void doConfiguration();
}
