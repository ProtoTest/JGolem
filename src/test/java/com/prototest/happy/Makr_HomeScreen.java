package com.prototest.happy;

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

public class Makr_HomeScreen {

    WebElement BusinessButton = appiumTestBase.getDriver().findElement(By.name("BUSINESS"));

    public static Makr_HomeScreen StartMaker(){
        appiumTestBase.getDriver();
        return new Makr_HomeScreen();
    }

    public Makr_HomeScreen ClickButton(){
        BusinessButton.click();
        return new Makr_HomeScreen();
    }
}
