package com.prototest.jgolem.core;

import com.prototest.jgolem.web.Element;

import java.util.function.Function;

public class Verification {
    protected Element element;
    protected boolean isTrue;
    protected boolean condition;
    protected String message;
    protected String conditional;
    protected int timeout;

    private Function<Boolean, Boolean> validation = (result -> result);

    protected Verification() {

    }

    public Verification(Element element, int timeout) {
        this.element = element;
        this.conditional = " not";
        this.timeout = timeout;
    }

    protected void ValidateCondition() {
        if (!validation.apply(condition)) {
            System.out.println("Verification Failed : " + this.message);
        }

    }

    protected boolean WaitForElement() {
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

    public Verification ContainsText(String text) {
        if (WaitForElement()) {
            this.condition = this.element.getText().contains(text);
            this.message = String.format("Element (%s) does%s contain text %s", element.getBy().toString(), conditional, text);
        }

        ValidateCondition();
        return this;
    }

    public Verification IsVisible() {
        if (WaitForElement()) {
            this.condition = this.element.isDisplayed();
            this.message = String.format("Element (%s) is%s visible ", element.getBy().toString(), conditional);
        }
        ValidateCondition();
        return this;
    }

    public Verification IsPresent() {
        if (WaitForElement()) {
            this.condition = this.element.isPresent();
            this.message = String.format("Element (%s) is%s present", element.getBy().toString(), conditional);
        }
        ValidateCondition();
        return this;
    }

    public Verification Not() {
        this.conditional = "";
        // Invert the result
        this.validation = (result -> !result);
        return this;
    }
}
