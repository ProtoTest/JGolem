package com.prototest.appium;

import com.prototest.appiumcore.*;

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
    public void Derp(){

        Makr_Home_Screen.StartMaker().ClickProjects().SelectProject(3);

    }

    @Test
    public void UserMenu(){
        //For some reason this test doesn't work when users are not logged in, but the above test does work
        Makr_Home_Screen.StartMaker().OpenUserMenu().Login().emailLogin("surban@prototest.com", "happier").ClickProjects();
    }
}
