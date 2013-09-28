package com.prototest.appium;

import com.prototest.appiumcore.*;
import org.openqa.selenium.By;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/11/13
 * Time: 7:25 PM
 * This is the screen that comes up when the user clicks the plus button
 */
public class Makr_Menu__NewProject_Screen extends appiumScreenBase {
    appElement PlusButton = new appElement("PlusButton", By.name("wmbPlusButton normal"));
    appElement NewProject = new appElement("NEW PROJECT", By.xpath("//window[1]/text[1]"));

    //Selected menu Item
    appElement Category = new appElement("Category", By.name("Category"));
    appElement Format = new appElement("Format", By.name("Format"));
    appElement Size = new appElement("Size", By.name("Size"));
    appElement Avery = new appElement("Avery", By.name("Avery"));

    //<editor-fold desc="Elements">
    //The selected menu item above results are displayed in the SelectedList item
    //appElement SelectedList = new appElement("SelectedList", By.xpath("//window[1]/tableview[5]"));
    //category
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

    //avery
    appElement Avery_Cards = new appElement("Cards", By.name("Cards"));
    appElement Avery_labels = new appElement("Labels", By.name("Labels"));
    appElement Avery_88221 = new appElement("88221", By.name("88221"));
    //</editor-fold>

    List<appElement> MainItems;
    List<appElement> FormatItems;
    List<appElement> SizeItems;
    List<appElement> AveryItems;

    List<appElement> BabyItems;
    List<appElement> BusinessItems;
    List<appElement> GiftingItems;
    List<appElement> HolidayItems;
    List<appElement> KitchenItems;
    List<appElement> Movingitems;
    List<appElement> OrganizationItems;
    List<appElement> PackagingItems;
    List<appElement> PartyItems;
    List<appElement> PromotionItems;
    List<appElement> StationaryItems;
    List<appElement> TableTopItems;
    List<appElement> ThankyouItems;
    List<appElement> WeddingItems;

    public Makr_Menu__NewProject_Screen(){
        InitList();
        VerifyContent(MainItems);
    }
    private void InitWedding(){
        SetupList(WeddingItems, "//window[1]/tableview[6]/cell[", 8);
    }
    private void InitThankYou(){
        SetupList(ThankyouItems, "//window[1]/tableview[6]/cell[", 2);
    }
    private void InitTableTop(){
        SetupList(TableTopItems, "//window[1]/tableview[6]/cell[", 5);
    }
    private void InitStationary(){
        SetupList(StationaryItems, "//window[1]/tableview[6]/cell[", 7);
    }
    private void InitPromotion(){
        SetupList(PromotionItems, "//window[1]/tableview[6]/cell[", 2);
    }
    private void InitParty(){
        SetupList(PartyItems, "//window[1]/tableview[6]/cell[", 12);
    }
    private void InitPackaging(){
        SetupList(PackagingItems, "//window[1]/tableview[6]/cell[", 7);
    }
    private void InitOrganization(){
        SetupList(OrganizationItems, "//window[1]/tableview[6]/cell[", 5);
    }
    private void InitMoving(){
        SetupList(Movingitems, "//window[1]/tableview[6]/cell[", 4);
    }
    private void InitKitchen(){
        SetupList(KitchenItems, "//window[1]/tableview[6]/cell[", 6);
    }
    private void InitHoliday(){
        SetupList(HolidayItems, "//window[1]/tableview[6]/cell[", 6);
    }
    private void InitGifting() {
        SetupList(GiftingItems, "//window[1]/tableview[6]/cell[", 9);
    }
    private void InitBusinessItems() {
        SetupList(BusinessItems, "//window[1]/tableview[6]/cell[", 7);
    }
    private void InitBaby() {
        SetupList(BabyItems, "//window[1]/tableview[6]/cell[", 6);
    }
    private void InitSize() {
        SetupList(SizeItems, "//window[1]/tableview[2]/cell[", 9);
    }
    private void InitFormat() {
        SetupList(FormatItems, "//window[1]/tableview[4]/cell[", 14);
    }

    private void SetupList(List<appElement> list, String ReplaceString, int max){
        list = new ArrayList<appElement>();
        for(int i = 1; i < max; i++){
            String num = Integer.toString(i);
            list.add(new appElement("Item" + num, By.xpath(ReplaceString + "]")));
        }
    }
    private void InitList() {
        MainItems = new ArrayList<appElement>();
        MainItems.add(Category);
        MainItems.add(Format);
        MainItems.add(Size);
        MainItems.add(Avery);
    }

    public Makr_Content_Category_Screen OpenFormat(int item){
        InitFormat();
        Format.tap();
        FormatItems.get(item).tap();
        return new Makr_Content_Category_Screen();
    }
    public Makr_Content_Category_Screen OpenCategory(String cat, int item){
        //I hate the way the function works but i can't think of a faster way to do it
        Category.tap();
        cat.toUpperCase();
        if(cat == "BABY"){
            InitBaby();
            Category_Baby.tap();
            BabyItems.get(item).tap();
        }
        if(cat == "BUSINESS"){
            InitBusinessItems();
            Category_Business.tap();
            BusinessItems.get(item).tap();
        }
        if(cat == "GIFTING"){
            InitGifting();
            Category_Gifting.tap();
            GiftingItems.get(item).tap();
        }
        if(cat == "HOLIDAY"){
            InitHoliday();
            Category_Holiday.tap();
            HolidayItems.get(item).tap();
        }
        if(cat == "KITCHEN"){
            InitKitchen();
            Category_Kitchen.tap();
            KitchenItems.get(item).tap();
        }
        if(cat == "MOVING"){
            InitMoving();
            Category_Moving.tap();
            Movingitems.get(item).tap();
        }
        if(cat == "ORGANIZATION"){
            InitOrganization();
            Category_Organization.tap();
            OrganizationItems.get(item).tap();
        }
        if(cat == "PACKAGING"){
            InitPackaging();
            Category_Packaging.tap();
            PackagingItems.get(item).tap();
        }
        if(cat == "PARTY"){
            InitParty();
            Category_Party.tap();
            PartyItems.get(item).tap();
        }
        if(cat == "PROMOTION"){
            InitPromotion();
            Category_Promotion.tap();
            PromotionItems.get(item).tap();
        }
        if(cat == "STATIONERY"){
            InitStationary();
            Category_Stationary.tap();
            StationaryItems.get(item).tap();
        }
        if(cat == "TABLETOP"){
            InitTableTop();
            Category_TableTop.tap();
            TableTopItems.get(item).tap();
        }
        if(cat == "THANKYOU"){
            InitThankYou();
            Category_ThankYou.tap();
            ThankyouItems.get(item).tap();
        }
        if(cat == "WEDDING"){
            InitWedding();
            Category_Wedding.tap();
            WeddingItems.get(item).tap();
        }
        else{
            PlusButton.tap();
        }
        return new Makr_Content_Category_Screen();
    }

    public Makr_Content_Category_Screen OpenSize(int item){
        InitSize();
        SizeItems.get(item).tap();
        return new Makr_Content_Category_Screen();
    }

    public Makr_Content_Category_Screen OpenAvery(int item){
        Avery.tap();
        Avery_Cards.tap();
        Avery_88221.tap();
        return new Makr_Content_Category_Screen();
    }




}
