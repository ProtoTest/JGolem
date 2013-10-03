package com.prototest.appium;

import org.testng.annotations.Test;
import com.prototest.appiumcore.*;

/**
 * Created with IntelliJ IDEA.
 * User: ChrisHancock
 * Date: 10/2/13
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Regression extends appiumTestBase {
    @Test
    public void Reg(){
        String orderText = "Orders placed by 6PM will arrive on MONTH, DAY";

        //Test for MONTH/DAY text error
        Makr_Home_Screen.StartMaker().OpenUserMenu().Login().emailLogin("chancock@prototest.com","happy1")
                .ClickProjects().SelectProject(2).TapOrderPrints2().verifyOrderText(orderText);

    }


}
