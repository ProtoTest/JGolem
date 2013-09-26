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
public class Makr_Menu_Screen extends appiumScreenBase {
    appElement LoginButton = new appElement("LoginButton", By.name("Log in"));
    appElement Logout = new appElement("LogoutButton", By.name("Logout"));
    appElement AccountSettings = new appElement("AccountSettings", By.name("Account"));
    appElement AlignPrinter = new appElement("AlignPrinterButton", By.name("Align Printer"));
    appElement ViewTutorial = new appElement("ViewTutorial", By.name("View Tutorial"));
    appElement HelpClues = new appElement("HelpClues", By.name("Help Clues on/off"));
    appElement FAQpage = new appElement("FAQPage", By.name("FAQ page >"));
    appElement ContactSupport = new appElement("ContactSupport", By.name("Contact Support"));
    appElement PrivacyPolicy = new appElement("PrivacyPolicy", By.name("Privacy Policy"));

    List<appElement> MenuElements;

    public Makr_Menu_Screen(){
        InitList();
        VerifyContent(MenuElements);
    }

    private void InitList() {
        MenuElements = new ArrayList<appElement>();
        MenuElements.add(LoginButton);
        MenuElements.add(Logout);
        MenuElements.add(AccountSettings);
        MenuElements.add(AlignPrinter);
        MenuElements.add(ViewTutorial);
        MenuElements.add(HelpClues);
        MenuElements.add(FAQpage);
        MenuElements.add(ContactSupport);
        MenuElements.add(PrivacyPolicy);
    }

}
