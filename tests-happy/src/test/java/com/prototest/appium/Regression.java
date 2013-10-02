package com.prototest.appium;

import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ChrisHancock
 * Date: 10/2/13
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Regression {
    @Test
    public void Reg(){
        //Test for MONTH/DAY text error
        Makr_Home_Screen.StartMaker().OpenUserMenu().Login().emailLogin("chancock@prototest.com","happy1").ClickProjects().SelectProject(5);

    }


}
