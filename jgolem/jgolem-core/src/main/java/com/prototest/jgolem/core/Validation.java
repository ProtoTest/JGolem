package com.prototest.jgolem.core;

public interface Validation {
    public Validation not();
    public Validation containsText(String text);
    public Validation isVisible();
    public Validation isPresent();
}
