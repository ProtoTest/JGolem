package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.lang.reflect.ParameterizedType;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/11/13
 * Time: 7:25 PM
 * This is the screen that comes up when the user clicks the plus button
 */
public class Makr_NewProjectMenu_Screen extends appiumScreenBase {
    appElement PlusButton = new appElement("PlusButton", By.name("wmbPlusButton normal"));
    appElement NewProject = new appElement("NEW PROJECT", By.xpath("//window[1]/text[1]"));

    //Selected menu Item
    appElement Category = new appElement("Category", By.name("Category"));
    appElement Format = new appElement("Format", By.name("Format"));
    appElement Size = new appElement("Size", By.name("Size"));
    appElement Avery = new appElement("Avery", By.name("Avery"));

    //The selected menu item above results are displayed in the SelectedList item
    appElement SelectedList = new appElement("SelectedList", By.xpath("//window[1]/tableview[5]"));

    appElement Category_Baby = new appElement("Category_Baby", By.name("Baby"));
    appElement Category_Business = new appElement("Category_Business", By.name("Business"));
    appElement Category_Gifting = new appElement("Category_Gifting", By.name("Gifting"));
    appElement Category_Holiday = new appElement("Category_Holiday", By.name("Holiday"));
    appElement Category_Kitchen = new appElement("Category_Kitchen", By.name("Kitchen"));
    appElement Category_Moving = new appElement("Category_Moving", By.name("Moving"));
    appElement Category_Organization = new appElement("Category_Organization", By.name("Organization"));
    appElement Category_Packaging = new appElement("Category_Packaging", By.name("Packaging"));
    appElement Category_Party = new appElement("Category_Party", By.name("Party"));
    appElement Category_Promotion = new appElement("Category_Promotion", By.name("Promotion"));
    appElement Category_Stationary = new appElement("Category_Stationery", By.name("Stationery"));
    appElement Category_TableTop = new appElement("Category_TableTop", By.name("Table Top"));
    appElement Category_ThankYou = new appElement("Category_ThankYou", By.name("Thank You"));
    appElement Category_Wedding = new appElement("Category_Wedding", By.name("Wedding"));



}
