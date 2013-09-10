package com.prototest.Happy_ScreenObjects;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 1:36 PM
 * Maker Home screen
 */

import com.prototest.appium.appiumTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Makr_Home_Screen extends Makr_MenuBar_HeaderScreen {

    //MenuBar Buttons
    WebElement BusinessButton = appiumTestBase.getDriver().findElement(By.name("BUSINESS"));

    public static Makr_Home_Screen StartMaker(){
        appiumTestBase.getDriver();
        return new Makr_Home_Screen();
    }

    public Makr_Home_Screen VerifyContent(){
        VerifyHeader();
        return new Makr_Home_Screen();
    }

    public Makr_Home_Screen ClickButton(){
        BusinessButton.click();
        MenuButton.tap();
        return new Makr_Home_Screen();
    }
}
