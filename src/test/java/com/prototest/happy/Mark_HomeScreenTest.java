package com.prototest.happy;

import com.prototest.appium.appiumTestBase;
import org.testng.annotations.Test;
import com.prototest.jgolem.framework.Config;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mark_HomeScreenTest extends appiumTestBase {
    @Test
    public void foo(){
        Makr_HomeScreen.StartMaker().ClickButton();
    }
}
