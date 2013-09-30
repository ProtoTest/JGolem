package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/29/13
 * Time: 1:57 PM
 * The screen used to checkout
 */
public class Makr_ShoppingCart_Items_Screen extends Makr_MenuBar_HeaderScreen {
    appElement ScreenTitle = new appElement("ScreenTitle", By.xpath("//window[1]/text[2]"));
    appElement Items = new appElement("Items", By.xpath("//window[1]/text[3]"));
    appElement SubTotalAmount = new appElement("SubTotalAmount", By.xpath("//window[1]/text[6]"));
    appElement TaxAmount = new appElement("TaxAmount", By.xpath("//window[1]/text[8]"));
    appElement ShippingAmount = new appElement("ShippingAmount", By.xpath("//window[1]/text[10]"));
    appElement PromoCodeAmount = new appElement("PromoAmount", By.xpath("//window[1]/text[12]"));
    appElement GrandTotalAmount = new appElement("GrandTotalAmount", By.xpath("//window[1]/text[14]"));

    appElement PromoCode = new appElement("PromoCode", By.xpath("//window[1]/textfield[1]"));
    appElement ZipCode = new appElement("ZipCode", By.xpath("//window[1]/textfield[2]"));
    appElement Checkout = new appElement("CheckoutButton", By.name("CHECKOUT"));



    List<appElement> ScreenElements;

    public Makr_ShoppingCart_Items_Screen(){
        InitList();
        VerifyContent(ScreenElements);
    }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(ScreenTitle);
        ScreenElements.add(Items);
        ScreenElements.add(SubTotalAmount);
        ScreenElements.add(TaxAmount);
        ScreenElements.add(ShippingAmount);
        ScreenElements.add(PromoCodeAmount);
        ScreenElements.add(GrandTotalAmount);
        ScreenElements.add(PromoCode);
        ScreenElements.add(ZipCode);
        ScreenElements.add(Checkout);
    }

    public Makr_ShoppingCart_Items_Screen addPromoCode(String pcode){
        //String total =  GrandTotalAmount.GetAttribute("value");

        PromoCode.SendKeys(pcode);
        return new Makr_ShoppingCart_Items_Screen();
    }

    public Makr_ShoppingCart_Items_Screen addZipCode(String zip){
        ZipCode.SendKeys(zip);
        return new Makr_ShoppingCart_Items_Screen();
    }




}
