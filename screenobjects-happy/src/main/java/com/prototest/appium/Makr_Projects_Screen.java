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
    appElement SideBar_All = new appElement("SideBar_All", By.xpath("//window[1]/tableview[1]/cell[1]"));
    appElement SideBar_Download = new appElement("SideBar_Download", By.xpath("//window[1]/tableview[1]/cell[2]"));
    appElement SideBar_AddCategory = new appElement("SideBar_AddCategory", By.name("mprAddCategorySidebar normal"));
    appElement SideBar_EditCategory = new appElement("SideBar_EditCategory", By.name("mprEditCategory normal"));


    //These are the expected projects on the page
    String Project = "//window[1]/UIACollectionView[1]/UIACollectionCell";

    List<appElement> ScreenElements;
    List<appElement> SideBarElements;

    public Makr_Projects_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(EditButton);
        ScreenElements.add(AllProjectsText);
        ScreenElements.add(SideBarMenu);
        SideBarElements = new ArrayList<appElement>();
        SideBarElements.add(SideBar_All);
        SideBarElements.add(SideBar_Download);
        SideBarElements.add(SideBar_AddCategory);
        SideBarElements.add(SideBar_EditCategory);
    }

    public void SelectProject(int projectID){
        String thing = "[" + String.valueOf(projectID) + "]";
        String elementXpath = Project + thing;
        appElement SelectedProject = new appElement("SelectedProject", By.xpath(elementXpath));
        SelectedProject.tap();
    }



}
