package com.prototest.jgolem.web;

public enum WebBrowser {
    Firefox, Chrome, IE, Safari, Android, Iphone;

    public static WebBrowser fromString(String text) {
        if (text != null) {
            for (WebBrowser b : WebBrowser.values()) {
                if (text.trim().equalsIgnoreCase(b.toString())) {
                    return b;
                }
            }
        }
        return null;
    }
}
