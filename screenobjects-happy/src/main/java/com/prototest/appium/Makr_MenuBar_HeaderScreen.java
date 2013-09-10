package com.prototest.appium;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 5:45 PM
 * This class should be present on almost all screens
 */
import com.prototest.appium.appElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class Makr_MenuBar_HeaderScreen {

    appElement MenuButton = new appElement("Menu", By.name("wmbHomeButton normal"));
    appElement WelcomeText = new appElement("WelcomeText", By.xpath("//window[1]/text[1]")); //hopefully there's a way to get this value
    appElement HomeButton = new appElement("HomeButton", By.name("wmbHome2Button normal"));
    appElement ProjectsButton = new appElement("Project Archive", By.name("wmbMyProjectButton normal"));
    appElement BlogButton = new appElement("Blog", By.name("wmbBlogButton normal"));
    appElement ShoppingCartButton = new appElement("ShoppingCart_Button", By.name("wmbCartButton normal"));
    appElement BetaFeedBack = new appElement("BetaFeedBack", By.name("wmbBetafeedbackButton normal"));
    appElement PlusButton = new appElement("PlusButton", By.name("wmbPlusButton normal"));

    List<appElement> MenuBarElements;

    public Makr_MenuBar_HeaderScreen(){
        initList();
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

    public void VerifyHeader(){
        //TODO: Need to build a logging function or something
        if(MenuBarElements.size() > 0){
            for(int i = 0; i < MenuBarElements.size(); i++){
                if(MenuBarElements.get(i).verifyPresent()){
                    System.out.println("This thing exists");
                }
                else {
                    System.out.println("This thing does not exist");
                }
            }
        }
    }



}
