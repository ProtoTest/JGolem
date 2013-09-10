package com.prototest.Happy_Tests;

import com.prototest.Happy_ScreenObjects.Makr_Home_Screen;
import com.prototest.appium.appiumTestBase;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 1:59 PM
 * Test Objects
 */
public class Makr_HomeScreen_Test extends appiumTestBase {
    @Test
    public void foo(){
        Makr_Home_Screen.StartMaker().VerifyContent().SwipeView().ClickButton();
    }
}
