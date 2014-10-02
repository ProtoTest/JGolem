package com.prototest.jgolem.core;

import com.prototest.jgolem.web.Element;  // TODO, make Element interface

import java.util.function.Function;

public abstract class AbstractElementValidationImpl implements Validation {
    protected Element element;
    protected boolean isTrue;
    protected boolean condition;
    protected String message;
    protected String conditional;
    protected int timeout;

    private Function<Boolean, Boolean> validation = (result -> result);

    public AbstractElementValidationImpl(Element element, int timeout) {
        this.element = element;
        this.conditional = " not";
        this.timeout = timeout;
    }

    protected void validateCondition() {
        boolean passed = true;

        if (!validation.apply(condition)) {
            passed = false;
        }

        Verifications.addVerification(this.message, passed);
    }

    protected boolean waitForElement() {
        for (int i = 0; i < this.timeout; i++) {
            if (element.isPresent())
                return true;
            else
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
        }
        this.condition = false;
        this.message = String.format("Element (%s) is%s present", element.getBy().toString(), conditional);
        return false;
    }

    @Override
    public abstract Validation containsText(String text);

    @Override
    public abstract Validation isVisible();

    @Override
    public abstract Validation isPresent();

    @Override
    public Validation not() {
        this.conditional = "";
        // Invert the result
        this.validation = (result -> !result);
        return this;
    }
}
