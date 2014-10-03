package com.prototest.jgolem.web;

import com.prototest.jgolem.core.Validation;
import com.prototest.jgolem.core.Verifications;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

public class ElementValidation implements Validation {
    protected Element element;
    protected boolean isTrue;
    protected boolean condition;
    protected String message;
    protected String conditional;
    protected int timeout;

    private Logger logger = LogManager.getLogger(getClass());
    private Function<Boolean, Boolean> validation = (result -> result);

    public ElementValidation(Element element, int timeout) {
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

    public ElementValidation containsValue(String text) {
        if (waitForElement()) {
            this.condition = this.element.getValue().contains(text);
            this.message = String.format("Element (%s) does%s contain value %s", element.getBy().toString(), conditional, text);
        }

        validateCondition();
        return this;
    }

    @Override
    public Validation containsText(String text) {
        if (waitForElement()) {
            this.condition = this.element.getText().contains(text);
            this.message = String.format("Element (%s) does%s contain text %s", element.getBy().toString(), conditional, text);
        }

        validateCondition();
        return this;
    }

    @Override
    public Validation isVisible() {
        if (waitForElement()) {
            this.condition = this.element.isDisplayed();
            this.message = String.format("Element (%s) is%s visible ", element.getBy().toString(), conditional);
        }
        validateCondition();
        return this;
    }

    @Override
    public Validation isPresent() {
        if (waitForElement()) {
            this.condition = this.element.isPresent();
            this.message = String.format("Element (%s) is%s present", element.getBy().toString(), conditional);
        }
        validateCondition();
        return this;
    }

    @Override
    public Validation not() {
        this.conditional = "";
        // Invert the result
        this.validation = (result -> !result);
        return this;
    }
}
