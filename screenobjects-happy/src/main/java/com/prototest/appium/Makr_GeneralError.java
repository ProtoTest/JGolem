package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/15/13
 * Time: 12:47 PM
 * This screen is displayed when there's an error with something.
 */
public class Makr_GeneralError extends appiumScreenBase {
    appElement ErrorText = new appElement("ErrorText", By.xpath("//window[3]/image[1]/text[1]"));
    appElement OkButton = new appElement("OkButton", By.xpath("//window[3]/image[1]/button[1]"));

    public void AknowledgeError(){
        OkButton.tap();
    }
}
