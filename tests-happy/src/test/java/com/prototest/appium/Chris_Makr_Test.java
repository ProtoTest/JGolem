package com.prototest.appium;

import com.prototest.appiumcore.appiumTestBase;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: prototest
 * Date: 9/13/13
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Chris_Makr_Test extends appiumTestBase {
    @Test
    public void foo(){

        Makr_Home_Screen.StartMaker().ClickBlogs().SelectBlog(1);
    }
}
