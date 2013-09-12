package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 9/12/13
 * Time: 11:50 AM
 * This screen is displayed from the Beta Feedback screen when the user chooses to view the message center.
 */
public class Makr_MessageCenter_Screen extends appiumScreenBase {
    appElement UserButton = new appElement("MC_UserButton", By.xpath("//window[1]/navigationBar[1]/button[1]"));
    appElement MessageCenterText = new appElement("MessageCenterText", By.name("Message Center"));
    appElement DoneButton = new appElement("DoneButton", By.name("Done"));
    appElement MessageCellOne = new appElement("MessageFirstCell", By.xpath("//window[1]/tableview[1]/cell[1]")); //This text should match the text entered from the beta feedback screen
    appElement AttachmentPlusButton = new appElement("AttachmentPlusButton", By.xpath("//window[1]/button[18]"));
    appElement EnterMessage = new appElement("EnterMessageTextview", By.xpath("//window[1]/textview[1]"));
    appElement SendButton = new appElement("SendButton", By.name("Send")); //Won't be available until text is entered into the EnterMessage object

    List<appElement> ScreenElements;

    public Makr_MessageCenter_Screen(){
        InitScreen();
        VerifyContent(ScreenElements);
    }

    private void InitScreen() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(UserButton);
        ScreenElements.add(MessageCenterText);
        ScreenElements.add(DoneButton);
        ScreenElements.add(MessageCellOne);
        ScreenElements.add(AttachmentPlusButton);
        ScreenElements.add(EnterMessage);
        ScreenElements.add(SendButton);
    }
}
