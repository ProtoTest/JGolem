package com.prototest.jgolem.web;

import com.prototest.jgolem.core.AbstractElementValidationImpl;
import com.prototest.jgolem.core.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ElementValidation extends AbstractElementValidationImpl {

    private Logger logger = LogManager.getLogger(getClass());

    public ElementValidation(Element element, int timeout) {
        super(element,timeout);
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
}
