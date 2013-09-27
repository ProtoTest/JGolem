package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import javax.script.ScriptEngine;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/27/13
 * Time: 11:48 AM
 * This is the registration screen for the Makr application
 */
public class Makr_Login_Register_Screen extends appiumScreenBase {
    appElement FacebookRegister = new appElement("RegisterWFaceBook", By.name("lgnFacebookRegisterButton norm"));
    appElement FirstName = new appElement("Firstname", By.xpath("//window[1]/textfield[5]"));
    appElement LastName = new appElement("LastName", By.xpath("//window[1]/textfield[6]"));
    appElement EmailAddress = new appElement("EmailAddress", By.xpath("//window[1]/textfield[7]"));
    appElement Password = new appElement("Password", By.xpath("//window[1]/secure[5]"));
    appElement PasswordConfirm = new appElement("ConfirmPassword", By.xpath("//window[1]/secure[6]"));
    appElement PasswordHint = new appElement("PasswordHint", By.xpath("//window[1]/textfield[7]"));
    appElement LoginButton = new appElement("LoginButton", By.name("LOG IN"));
    appElement RegisterButton = new appElement("RegisterButton", By.name("REGISTER"));

    //Terms and conditions
    appElement AcceptTerms = new appElement("AcceptTerms", By.name("ACCEPT"));

    List<appElement> ScreenElements;

    public Makr_Login_Register_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(FacebookRegister);
        ScreenElements.add(FirstName);
        ScreenElements.add(LastName);
        ScreenElements.add(EmailAddress);
        ScreenElements.add(Password);
        ScreenElements.add(PasswordConfirm);
        ScreenElements.add(PasswordHint);
        ScreenElements.add(LoginButton);
        ScreenElements.add(RegisterButton);
    }

    public Makr_Login_Screen returnToLogin(){
        LoginButton.tap();
        return new Makr_Login_Screen();
    }

    public Makr_Home_Screen RegisterNewEmailUser(String fname, String lname, String email, String pass, String hint){
        FirstName.SendKeys(fname);
        LastName.SendKeys(lname);
        EmailAddress.SendKeys(email);
        Password.SendKeys(pass);
        PasswordConfirm.SendKeys(pass);
        PasswordHint.SendKeys(hint);
        RegisterButton.tap();
        AcceptTerms.tap();
        return new Makr_Home_Screen();
    }

}
