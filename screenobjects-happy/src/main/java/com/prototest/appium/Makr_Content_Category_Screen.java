package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/27/13
 * Time: 2:29 PM
 * This screen is used to load content creation categories such as Baby, or Business
 */
public class Makr_Content_Category_Screen extends appiumScreenBase {
    appElement ScreenTitle = new appElement("ScreenTitle", By.xpath("//window[1]/text[2]"));
    appElement BackButton = new appElement("BackButton", By.xpath("//window[1]/button[8]"));
    appElement SelectDesign = new appElement("SelectDesign", By.name("SELECT A DESIGN"));

    appElement DesignTemplate = new appElement("DesignTemplate", By.xpath("//window[1]/UIACollectionView[1]"));
    List<appElement> ScreenElements;

    public Makr_Content_Category_Screen(){
        InitList();
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(ScreenTitle);
        ScreenElements.add(BackButton);
        ScreenElements.add(SelectDesign);
    }


    private void ScrollIntoView()
    {
        AppMainWindow.Swipe("DOWN");
    }

}
