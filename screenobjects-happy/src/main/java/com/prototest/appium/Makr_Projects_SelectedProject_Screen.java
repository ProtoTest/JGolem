package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/29/13
 * Time: 1:19 PM
 * This screen is displayed when the user selects an already created project
 */
public class Makr_Projects_SelectedProject_Screen extends Makr_MenuBar_HeaderScreen {
    appElement BackButton = new appElement("BackButton", By.xpath("//window[1]/button[9]"));
    appElement LockButton = new appElement("LockButton", By.xpath("//window[1]/button[11]"));
    appElement ProjectTitle = new appElement("ProjectTitle", By.xpath("//window[1]/textfield[1]"));

    appElement OrderPrints = new appElement("OrderPrints", By.xpath("//window[1]/scrollview[1]/button[1]"));
    appElement HiResDownload = new appElement("HiResDownload", By.xpath("//window[1]/scrollview[1]/button[2]"));
    appElement DuplicateProject = new appElement("DuplicateProject", By.xpath("//window[1]/scrollview[1]/button[3]"));
    appElement Pinterest = new appElement("Pinterest", By.xpath("//window[1]/scrollview[1]/button[4]"));
    appElement Facebook = new appElement("FaceBook", By.xpath("//window[1]/scrollview[1]/button[5]"));
    appElement Twitter = new appElement("Twitter",By.xpath("//window[1]/scrollview[1]/button[6]"));
    appElement email = new appElement("email", By.xpath("//window[1]/scrollview[1]/button[7]"));

    //OrderPrints
    appElement OrderText = new appElement("OrderText", By.xpath("//window[1]/scrollview[1]/scrollview[1]/scrollview[1]/text[1]"));
    //Need to figure out a way to change quantity
    appElement QuantityButton = new appElement("QuantityButton", By.xpath("//window[1]/scrollview[1]/scrollview[1]/scrollview[1]/button[1]"));
    appElement AddtoCart = new appElement("AddtoCart", By.xpath("//window[1]/scrollview[1]/scrollview[1]/scrollview[1]/button[2]"));

    //OrderPrints Two
    appElement CheckoutNow = new appElement("CheckoutNow", By.xpath("//window[1]/scrollview[1]/scrollview[1]/button[1]"));
    appElement ContinueMaking = new appElement("ContinueMaking", By.xpath("//window[1]/scrollview[1]/scrollview[1]/button[1]"));

    //HiResDownload
    appElement HiRes_Email = new appElement("PDFEmail", By.xpath("//window[1]/scrollview[1]/scrollview[1]/button[2]"));
    appElement HiRes_iTunes = new appElement("PDFiTunes", By.xpath("//window[1]/scrollview[1]/scrollview[1]/button[3]"));
    appElement HiRes_iTunes_Help = new appElement("iTunes_Help", By.xpath("//window[1]/scrollview[1]/scrollview[1]/button[4]"));
    appElement HiRes_DropBox = new appElement("HiRes_DropBox", By.xpath("//window[1]/scrollview[1]/scrollview[1]/button[5]"));
    appElement HiRes_DropBox_Help = new appElement("DropBox_Help", By.xpath("//window[1]/scrollview[1]/scrollview[1]/button[6]"));
    appElement HiRes_AirDrop = new appElement("PDFAirDrop", By.xpath("//window[1]/scrollview[1]/scrollview[1]/button[7]"));
    appElement HiRes_AirDrop_Help = new appElement("PDFAirDrop_Help", By.xpath("//window[1]/scrollview[1]/scrollview[1]/button[8]"));

    //Proof
    appElement checkedmyspellingfront = new appElement("SpellingCheckBoxFront", By.xpath("//window[1]/scrollview[1]/button[17]"));
    appElement Iunderstandthatcolorsfront = new appElement("ColorCheckboxFront", By.xpath("//window[1]/scrollview[1]/button[18]"));
    appElement ProofFrontNext = new appElement("Next", By.xpath("//window[1]/scrollview[1]/button[20]"));

    List<appElement> ScreenElements;

    public Makr_Projects_SelectedProject_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(BackButton);
        ScreenElements.add(LockButton);
        ScreenElements.add(ProjectTitle);
        ScreenElements.add(OrderPrints);
        ScreenElements.add(HiResDownload);
        ScreenElements.add(DuplicateProject);
        ScreenElements.add(Pinterest);
        ScreenElements.add(Facebook);
        ScreenElements.add(Twitter);
        ScreenElements.add(email);
    }

    public Makr_ShoppingCart_Items_Screen OrderPrints(){
        OrderPrints.tap();
        AddtoCart.tap();
        CheckoutNow.tap();
        return new Makr_ShoppingCart_Items_Screen();
    }

    public void ChangeQuantity(int quantLevel){
        //not sure how to do this yet
        //Hope this works
        QuantityButton.tap();
        String thing = String.valueOf(quantLevel);
        appElement SelectedQuantity = new appElement("SelectedQuantity", By.xpath("//window[1]/scrollview[1]/scrollview[1]/scrollview[1]/button["+thing+"]"));
        SelectedQuantity.tap();
    }

    public void OrderPrints_ContinueMaking(){
        OrderPrints.tap();
        AddtoCart.tap();
        ContinueMaking.tap();
    }

    public void verifyOrderText(){

    }

    public void TapOrderPrints() {
        OrderPrints.tap();
        // TODO: Make a screen a return it
    }



}
