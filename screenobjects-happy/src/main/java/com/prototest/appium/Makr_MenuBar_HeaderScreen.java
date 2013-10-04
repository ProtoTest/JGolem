package com.prototest.appium;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 5:45 PM
 * This class should be present on almost all screens
 */
import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class Makr_MenuBar_HeaderScreen extends appiumScreenBase {

    appElement MenuButton = new appElement("Menu", By.name("wmbHomeButton normal"));
    appElement WelcomeText = new appElement("WelcomeText", By.xpath("//window[1]/text[1]")); //hopefully there's a way to get this value
    appElement HomeButton = new appElement("HomeButton", By.name("wmbHome2Button normal"));
    appElement ProjectsButton = new appElement("Project Archive", By.xpath("//window[1]/button[3]"));
    appElement BlogButton = new appElement("Blog", By.name("wmbBlogButton normal"));
    appElement ShoppingCartButton = new appElement("ShoppingCart_Button", By.name("wmbCartButton normal"));
    appElement BetaFeedBack = new appElement("BetaFeedBack", By.name("wmbBetafeedbackButton normal"));
    appElement PlusButton = new appElement("PlusButton", By.name("wmbPlusButton normal"));

    List<appElement> MenuBarElements;

    public Makr_MenuBar_HeaderScreen(){
        initList();
        VerifyContent(MenuBarElements);
    }

    private void initList(){
        MenuBarElements = new ArrayList<appElement>();
        MenuBarElements.add(MenuButton);
        MenuBarElements.add(WelcomeText);
        MenuBarElements.add(HomeButton);
        MenuBarElements.add(ProjectsButton);
        MenuBarElements.add(BlogButton);
        MenuBarElements.add(ShoppingCartButton);
        MenuBarElements.add(BetaFeedBack);
        MenuBarElements.add(PlusButton);
    }

    public Makr_Menu__NewProject_Screen OpenProjectMenu(){
        PlusButton.tap();
        return new Makr_Menu__NewProject_Screen();
    }





}
