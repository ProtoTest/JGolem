package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/11/13
 * Time: 7:06 PM
 * This represents the object that get's called when the menu "M" button is pressed from the HeaderScreen
 */
public class Makr_Menu_User_Screen extends appiumScreenBase {
    public appElement LoginButton = new appElement("LoginButton", By.name("Log In"));
    public appElement LogoutButton = new appElement("LogoutButton", By.name("LogoutButton"));
    public appElement AccountSettings = new appElement("AccountSettings", By.name("Account"));
    //appElement AlignPrinter = new appElement("AlignPrinterButton", By.name("Align Printer")); --This seems to have been removed in 0.5.a.91
    //appElement ViewTutorial = new appElement("ViewTutorial", By.name("View Tutorial"));
    public appElement AppSettings = new appElement("AppSettings", By.name("App Settings"));
    public appElement InviteFriends = new appElement("InviteFriends", By.name("Invite Friends"));
    public appElement Help = new appElement("HelpClues", By.name("Help"));
    public appElement TermsandConditions = new appElement("Terms", By.name("Terms & Conditions"));
    //appElement FAQpage = new appElement("FAQPage", By.name("FAQ page >"));
    //appElement ContactSupport = new appElement("ContactSupport", By.name("Contact Support"));
    //appElement PrivacyPolicy = new appElement("PrivacyPolicy", By.name("Privacy Policy"));


    List<appElement> MenuElements;
    private boolean loggedIn;

    public Makr_Menu_User_Screen(){
        if(LoginButton.verifyPresent()){
            InitList_login();
            loggedIn = false;
        }else{
            InitList_logout();
            loggedIn = true;
        }
        VerifyContent(MenuElements);
        //addScreenHistory(new Makr_Menu_User_Screen());
    }

    private void InitList_login() {
        //need to do a check here to see if the login button, or the logout button is present
        MenuElements = new ArrayList<appElement>();
        MenuElements.add(LoginButton);
        MenuElements.add(AccountSettings);
        MenuElements.add(AppSettings);
        MenuElements.add(InviteFriends);
        MenuElements.add(Help);
        MenuElements.add(TermsandConditions);
    }

    private void InitList_logout(){
        MenuElements = new ArrayList<appElement>();
        MenuElements.add(LogoutButton);
        MenuElements.add(AccountSettings);
        MenuElements.add(AppSettings);
        MenuElements.add(InviteFriends);
        MenuElements.add(Help);
        MenuElements.add(TermsandConditions);
    }

    public Makr_Login_Screen Login(){
        if(!loggedIn){
            LoginButton.tap();
        }
        return new Makr_Login_Screen();
    }


}
