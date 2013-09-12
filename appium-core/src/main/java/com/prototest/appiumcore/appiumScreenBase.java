package com.prototest.appiumcore;

import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 9/11/13
 * Time: 11:27 AM
 * Base Screen object for appiumTests
 */
public class appiumScreenBase {
    protected  appElement AppMainWindow = new appElement("AppMainWindow", By.xpath("//window[1]"));
}
