package com.prototest.appiumcore;

import org.openqa.selenium.remote.*;
/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 1:11 PM
 * Config to set up browser capabilities.
 */
public class appiumConfig {
    private String browser;
    private String version;
    private String platform;
    private DesiredCapabilities capabilities = null;

    public appiumConfig(String Browser, String Version, String Platform){
        browser = Browser;
        version = Version;
        platform = Platform;

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability(CapabilityType.PLATFORM, platform);
    }

    public String getBrowser(){
        return browser;
    }

    public String getVersion(){
        return version;
    }
    public String getPlatform(){
        return platform;
    }
    public DesiredCapabilities getCapabilities(){
        return capabilities;
    }


}
