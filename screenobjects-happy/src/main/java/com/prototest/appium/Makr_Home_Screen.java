package com.prototest.appium;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 1:36 PM
 * Maker Home screen
 */

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;


public class Makr_Home_Screen extends Makr_MenuBar_HeaderScreen {

    //Header Buttons
    appElement BusinessButton = new appElement("Business", By.name("BUSINESS"));
    appElement CelebrationsButton = new appElement("Celebrations", By.name("CELEBRATIONS"));
    appElement HomeButton = new appElement("Home", By.name("HOME"));
    appElement WeddingButton = new appElement("Wedding", By.name("WEDDING"));
    appElement BabyButton = new appElement("Baby", By.name("BABY"));
    appElement HolidayButton = new appElement("Holiday", By.name("HOLIDAY"));
    appElement ScrollView = new appElement("ScrollView", By.xpath("//window[1]/UIACollectionView[1]/scrollview[1]"));

    public static Makr_Home_Screen StartMaker(){
        appiumTestBase.getDriver();
        return new Makr_Home_Screen();
    }

    public  Makr_Home_Screen VerifyContent(){
        VerifyHeader();
        return new Makr_Home_Screen();
    }

    public Makr_Home_Screen ClickButton(){

        MenuButton.tap();
        return new Makr_Home_Screen();
    }

    public Makr_Home_Screen SwipeView() {




        AppMainWindow.ScrollUp();
        AppMainWindow.ScrollDown();

        return new Makr_Home_Screen();
    }
}
