package com.prototest.appiumcore;

import org.openqa.selenium.By;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 9/11/13
 * Time: 11:27 AM
 * Base Screen object for appiumTests
 */
public class appiumScreenBase {
    protected  appElement AppMainWindow = new appElement("AppMainWindow", By.xpath("//window[1]"));

    protected void VerifyContent(List<appElement> elements){
        if(elements.size() > 0){
            for(int i = 0; i < elements.size(); i++){
                if(elements.get(i).verifyPresent()){
                    System.out.println(elements.get(i).getName() + " is present");
                }
                else{
                    System.out.println(elements.get(i).getName() + " is NOT present");
                }

            }
        }
    }
}
