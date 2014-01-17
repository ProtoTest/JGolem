package com.prototest.jgolem;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Config (Configuration settings) class. Used to load up jgolem and test specific configuration
 *  values from a file. Uses apache-commons library to facilitate property management.
 *
 *  Example usage: Config.Settings.RuntimeSettings.launchBrowser
 *
 * @author Matt Siwiec
 */
public final class Config {
    private static Configuration config;
    private static final String CONFIG_FILE_NAME = "Test.properties";
    private static Logger Log = LogManager.getLogger(Config.class.getName());

    // static constructor
    static {
        try {
            Log.info("Loading test configuration file: " + CONFIG_FILE_NAME);
            config = new PropertiesConfiguration(CONFIG_FILE_NAME);
        } catch (ConfigurationException e) {
            Log.error("Caught ConfigurationException in: " + e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     *  Returns the configuration file value for 'key' passed in. If the 'key' is not found, then 'default_value'
     *  is returned.
     *
     * @param key               Configuration file key string
     * @param default_value     Default value returned, cannot be null
     * @return <T>              Generic type value defined in configuration file,
     *                          or default value, if not found in config file.
     * @throws NullPointerException
     * @throws IllegalArgumentException
     *
     * <p>
     *     Note: You cannot use primitive data types (i.e. int, boolean, etc.) with generics. When defining
     *           variables to store this config data use the object instead of the primitive
     *           (i.e. Boolean instead of boolean).
     *      Suppressing warning for the cast to generic type T.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public static <T> T getConfigValue(String key, T default_value) throws NullPointerException, IllegalArgumentException {
        T ret_val = default_value;

        if(key == null) throw new NullPointerException("param 'key' can not be null!");
        if(default_value == null) throw new NullPointerException("param 'default_value' can not be null!");

        if(config != null) {
            if(default_value instanceof Integer) {
                ret_val = (T)config.getInteger(key, (Integer)default_value);
            } else if(default_value instanceof String) {
                ret_val = (T)config.getString(key);
            } else if(default_value instanceof Boolean) {
                ret_val = (T)config.getBoolean(key, (Boolean)default_value);
            } else if(default_value instanceof String[]) {
                ret_val = (T)config.getStringArray(key);
            }
            else {
                throw new IllegalArgumentException(default_value.getClass() + " is not supported by this function");
            }
        }

        return ret_val;
    }

    /**
     * Settings class: Wraps all of the test and jgolem configuration settings
     */
    public static class Settings {

        public static class RuntimeSettings {
            public static ArrayList<WebDriverBrowser.Browser> browsers = new ArrayList<WebDriverBrowser.Browser>();
            public static Boolean launchBrowser;
            public static Integer testTimeoutMin;
            public static Integer elementTimeoutSec;
            public static Integer pageTimeoutSec;
            public static String  environmentURL;
            public static Integer degreeOfParallelism;
            public static Integer commandDelayMs;
            public static Boolean runOnRemoteHost;
            public static String  hostIP;

            // static class constructor
            static {
                try {
                    browsers = getBrowserList();
                    launchBrowser = Config.getConfigValue("LaunchBrowser", true);
                    testTimeoutMin = Config.getConfigValue("TestTimeoutMin", 5);
                    elementTimeoutSec = Config.getConfigValue("ElementTimeoutSec", 20);
                    pageTimeoutSec = Config.getConfigValue("PageTimeoutSec", 30);
                    environmentURL = Config.getConfigValue("EnvironmentURL", "");
                    degreeOfParallelism = Config.getConfigValue("DegreeOfParallelism", 5);
                    commandDelayMs = Config.getConfigValue("CommandDelayMs", 0);
                    runOnRemoteHost = Config.getConfigValue("RunOnRemoteHost", false);
                    hostIP = Config.getConfigValue("HostIp", "localhost");
                } catch (NullPointerException e) {
                    Log.error(e.getMessage());
                } catch (IllegalArgumentException e) {
                    Log.error(e.getMessage());
                }
            }

            private static ArrayList<WebDriverBrowser.Browser> getBrowserList() {
                ArrayList<WebDriverBrowser.Browser> browsers = new ArrayList<WebDriverBrowser.Browser>();
                String[] browserConfigList = {};
                browserConfigList = Config.getConfigValue("Browsers", browserConfigList);
                if(browserConfigList != null) {
                    for(String browser_str: browserConfigList) {
                        // do not test on IE if the OS is not Windows
                        if(browser_str.equalsIgnoreCase("IE") && !System.getProperty("os.name").startsWith("Windows")) {
                            continue;
                        }

                        browsers.add(WebDriverBrowser.Browser.valueOf(browser_str));
                    }
                }

                return browsers;
            }
        }

        public static class ReportSettings {
            public static Boolean htmlOnError;
            public static Boolean screenShotOnError;
            public static Boolean videoRecordingOnError;
            public static Boolean commandLogging;
            public static Boolean actionLogging;
            public static Boolean spellChecking;

            static {
                try {
                    htmlOnError = Config.getConfigValue("HtmlOnError", true);
                    screenShotOnError = Config.getConfigValue("ScreenshotOnError", true);
                    videoRecordingOnError = Config.getConfigValue("VideoRecordingOnError", true);
                    commandLogging = Config.getConfigValue("CommandLogging", true);
                    actionLogging = Config.getConfigValue("ActionLogging", true);
                    spellChecking = Config.getConfigValue("SpellChecking", true);
                } catch (NullPointerException e) {
                    Log.error(e.getMessage());
                } catch (IllegalArgumentException e) {
                    Log.error(e.getMessage());
                }
            }
        }

        // TODO: Need to find a Fiddler Proxy java equivalent
        public static class HttpProxySettings {
            public static Boolean startProxy;
            public static Integer proxyPort;
            public static Integer sslProxyPort;

            // static class constructor
            static {
                try {
                    startProxy = Config.getConfigValue("StartWHATSMYNAMEProxy", true);
                    proxyPort = Config.getConfigValue("ProxyPort", 8876);
                    sslProxyPort = Config.getConfigValue("SSLProxyPort", 7777);
                } catch (NullPointerException e) {
                    Log.error(e.getMessage());
                } catch (IllegalArgumentException e) {
                    Log.error(e.getMessage());
                }
            }
        }

        public static class LocalProxySettings {
            public static Boolean localProxy;
            public static Integer localPort;
            public static String localHost;

            // static class constructor
            static {
                try {
                    localProxy = Config.getConfigValue("UseLocalProxy", false);
                    localPort = Config.getConfigValue("ProxyPort", 8888);
                    localHost = Config.getConfigValue("HostIP", "localhost");
                } catch (NullPointerException e) {
                    Log.error(e.getMessage());
                } catch (IllegalArgumentException e) {
                    Log.error(e.getMessage());
                }
            }
        }

        public static class AppiumSettings {
            public static Boolean launchApp;
            public static String appPath;
            public static String appPackage;
            public static String activity;
            public static String appOS;

            // static class constructor
            static {
                try {
                    launchApp = Config.getConfigValue("LauchApp", false);
                    appPath = Config.getConfigValue("AppPath", "");
                    appPackage = Config.getConfigValue("AppPackage", "");
                    activity = Config.getConfigValue("AppActivity", "");
                    appOS = Config.getConfigValue("AppOS", "Android");
                } catch (NullPointerException e) {
                    Log.error(e.getMessage());
                } catch (IllegalArgumentException e) {
                    Log.error(e.getMessage());
                }
            }
        }
    }
}




