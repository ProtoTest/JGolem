package com.prototest.appiumcore;

import org.openqa.selenium.By;


import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 9/11/13
 * Time: 11:27 AM
 * Base Screen object for appiumTests
 */
public class appiumScreenBase {
    protected  appElement AppMainWindow = new appElement("AppMainWindow", By.xpath("//window[1]"));


    appElement SurveyHeader = new appElement("SurveyHeader", By.xpath("//window[1]/navigationBar[1]/text[1]")); //This should be present on both surveys

    //Survey One Elements
    appElement SurveyCancel = new appElement("SurveyCancel", By.name("//window[1]/navigationBar[1]/button[1]"));
    appElement OkButton = new appElement("OkButton", By.name("Ok!"));
    appElement oppsButton = new appElement("OppsButton", By.name("Oops. I'll come back when I am online."));
    appElement sendResponse = new appElement("SendResponse", By.name("Send Response"));

    public appiumScreenBase(){
        Random r = new Random();
        int num = r.nextInt(101); //generate a random number between 1 and 100
        if(SurveyHeader.verifyPresent()){
            //need to detect survey type -- if cancel button is present then it's survey one
            if(SurveyCancel.verifyPresent()){
                //Do survey one stuff
                if(num <= 33){
                    Complete_SurveyOne();
                }
                if((num >= 34) && (num <= 66)){
                    Opps_SurveyOne();
                }
                else{
                    Cancel_SurveyOne();
                }

            }
            else{
                //do survey two stuff --
            }

        }

    }



    /*This function has the list of elements passed into it to verify they are present on any given screen */
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

    private void Complete_SurveyOne(){

        OkButton.tap();
        sendResponse.tap();
    }

    private void Opps_SurveyOne(){
        oppsButton.tap();
        sendResponse.tap();
    }

    private void Cancel_SurveyOne(){
        SurveyCancel.tap();
    }
}
