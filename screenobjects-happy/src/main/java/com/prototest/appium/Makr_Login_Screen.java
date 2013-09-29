package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/15/13
 * Time: 12:33 PM
 * This is the login screen, displayed before the Main screen sometimes.
 */
public class Makr_Login_Screen extends appiumScreenBase {
    appElement usernameField = new appElement("UserNameField", By.xpath("//window[1]/textfield[4]"));
    appElement PasswordField = new appElement("PasswordField", By.xpath("//window[1]/secure[4]"));
    appElement LoginButton = new appElement("LoginButton", By.xpath("//window[1]/button[10]"));
    appElement RegisterButton = new appElement("RegisterButton", By.name("REGISTER"));
    appElement FaceBookLogin = new appElement("FaceBook_Login", By.name("lgnFacebookLoginButton normal"));
    appElement ForgotPassword = new appElement("ForgotPassword", By.name("FORGOT PASSWORD"));



    List<appElement> ScreenElements;
    public Makr_Login_Screen(){
        InitList();
        VerifyContent(ScreenElements);
        //addScreenHistory(new Makr_Login_Screen());
        AppMainWindow.tap();
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(usernameField);
        ScreenElements.add(PasswordField);
        ScreenElements.add(LoginButton);
        ScreenElements.add(RegisterButton);
        ScreenElements.add(FaceBookLogin);
        ScreenElements.add(ForgotPassword);

    }

    public Makr_Home_Screen emailLogin(String username, String password){
        //AppMainWindow.tap(); //this needs to be done to get the login screen elements to be visible
        usernameField.SendKeys(username);
        PasswordField.SendKeys(password);
        LoginButton.tap();
        return new Makr_Home_Screen();
    }




}
