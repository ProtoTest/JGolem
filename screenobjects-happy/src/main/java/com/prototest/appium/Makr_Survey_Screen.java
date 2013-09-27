package com.prototest.appium;

import com.prototest.appiumcore.appElement;
import org.openqa.selenium.By;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 9/26/13
 * Time: 1:29 PM
 * This the screen that occasionally pops up when users start the application
 */
public class Makr_Survey_Screen {

    appElement SurveyCancel = new appElement("SurveyCancel", By.name("Cancel"));
    appElement OkButton = new appElement("OkButton", By.name("Ok!"));
    appElement oppsButton = new appElement("OppsButton", By.name("Oops. I'll come back when I am online."));
    appElement sendResponse = new appElement("SendResponse", By.name("Send Response"));

    public boolean detectSurvey(){
        boolean survey;
        appElement SurveyWindow = new appElement("SurveyWindow", By.xpath("//window[1]/navigationBar[1]"));
        if(SurveyWindow.getName() == "Survey"){
            survey = true;
        }else{
            survey = false;
        }
        return survey;
    }

    public void CompleteSurvey(){
        OkButton.tap();
        sendResponse.tap();
    }

}
