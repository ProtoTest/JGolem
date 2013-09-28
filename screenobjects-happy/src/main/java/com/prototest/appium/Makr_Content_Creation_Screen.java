package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/27/13
 * Time: 8:35 PM
 * This screen is used to create some content
 */
public class Makr_Content_Creation_Screen extends appiumScreenBase {
    //This is actually on the screen before this screen -- this is the button to get to the content screen
    appElement SelectTemplate = new appElement("SelectTemplate", By.xpath("//window[1]/button[9]"));

    appElement UserMenu = new appElement("UserMenu", By.xpath("//window[1]/button[1]"));
    appElement CloseButton = new appElement("CloseButton", By.name("CLOSE"));
    appElement SaveButton = new appElement("SaveButton", By.name("SAVE"));
    appElement MakeButton = new appElement("MakeButton", By.name("make!"));

    appElement UndoButton = new appElement("UndoButton", By.xpath("//window[1]/button[5]"));
    appElement RedoButton = new appElement("RedoButton", By.xpath("//window[1]/button[6]"));

    appElement CreationTitle = new appElement("CreationTitle", By.xpath("//window[1]/text[2]"));
    appElement FrontButton = new appElement("FrontButton", By.name("FRONT"));
    appElement BackButton = new appElement("BackButton", By.name("BACK"));

    appElement addText = new appElement("AddText", By.xpath("//window[1]/button[9]"));
    appElement addArt = new appElement("addArt", By.xpath("//window[1]/button[9]"));

    List<appElement> ScreenElements;

    public Makr_Content_Creation_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(UserMenu);
        ScreenElements.add(CloseButton);
        ScreenElements.add(SaveButton);
        ScreenElements.add(MakeButton);
        ScreenElements.add(UndoButton);
        ScreenElements.add(RedoButton);
        ScreenElements.add(CreationTitle);
        ScreenElements.add(addArt);
        ScreenElements.add(addText);
    }

    public Makr_Menu_User_Screen tapUsermenu(){
        UserMenu.tap();
        return new Makr_Menu_User_Screen();
    }



}
