package com.prototest.jgolem.framework;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;

public final class Config {
    static Configuration config;

    static {
        try {
            config = new PropertiesConfiguration("Test.properties");
            System.out.println(config.getString("Browser1"));
        } catch (ConfigurationException e) {
            System.out.println("Caught Exception in login(): " + e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getConfigValue(String key, T default_value) {
        T ret_val = default_value;

        try {
            if(default_value.getClass().equals(Integer.class)) {
                Integer val = config.getInteger(key, (Integer)default_value);
                if(val != null) {
                    ret_val = (T)val;
                }
            }
            if(default_value.getClass().equals(String.class)) {
                String val = config.getString(key);
                if(val != null) {
                    ret_val = (T)val;
                }
            }
            if(default_value.getClass().equals(Boolean.class)) {
                Boolean val = config.getBoolean(key);
                if(val != null) {
                    ret_val = (T)val;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Failed to find " + key + " in configuration file");
        }

        return ret_val;
    }

    public static class Settings {

        public static class RuntimeSettings {
            public static ArrayList<WebDriverBrowser.Browser> browsers = new ArrayList<WebDriverBrowser.Browser>();
            public static Boolean launchBrowser;
            public static Integer     testTimeoutMin;
            public static Integer     elementTimeoutSec;
            public static Integer     pageTimeoutSec;
            public static String  environmentURL;
            public static Integer     degreeOfParallelism;
            public static Integer     commandDelayMs;
            public static Boolean runOnRemoteHost;
            public static String  hostIP;

            static {
                browsers = getBrowserList();
                testTimeoutMin = Config.getConfigValue("TestTimeoutMin", 5);
                launchBrowser = Config.getConfigValue("LaunchBrowser", false);
                hostIP = Config.getConfigValue("Test", "fuckin-A");

            }

            private static ArrayList<WebDriverBrowser.Browser> getBrowserList() {
                ArrayList<WebDriverBrowser.Browser> browsers = new ArrayList<WebDriverBrowser.Browser>();

                return browsers;
            }
        }

        public static class ReportSettings {

        }

        public static class HttpProxySettings {

        }

        public class LocalProxySettings {

        }

        public class AppiumSettings {

        }
    }
}




