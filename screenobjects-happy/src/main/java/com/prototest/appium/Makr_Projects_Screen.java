package com.prototest.appium;


import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 9/12/13
 * Time: 2:00 PM
 * Projects screen is opened from the Home_Screen
 */
public class Makr_Projects_Screen extends Makr_MenuBar_HeaderScreen {

    appElement EditButton = new appElement("EditButton", By.name("mprProjectEdit normal"));
    appElement AllProjectsText = new appElement("AllProjectsText", By.xpath("//window[1]/text[2]"));
    appElement SideBarMenu = new appElement("SideBarMenu", By.name("mprSidebarPanelButton"));

    //These elements are displayed in the sidebar after the sidebarmenu button is clicked
    appElement SideBar_All = new appElement("SideBar_All", By.xpath("/window[1]/tableview[1]/cell[1]"));

    //These are the expected projects on the page
    String Project = "//window[1]/UIACollectionView[1]/UIACollectionCell";

    List<appElement> ScreenElements;

    public Makr_Projects_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(EditButton);
        ScreenElements.add(AllProjectsText);
        ScreenElements.add(SideBarMenu);

    }

    public void SelectProject(int projectID){
        String thing = "[" + String.valueOf(projectID) + "]";
        String elementXpath = Project + thing;
        appElement SelectedProject = new appElement("SelectedProject", By.xpath(elementXpath));
        SelectedProject.tap();

    }



}
