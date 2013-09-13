package com.prototest.appium;

import com.prototest.appiumcore.appElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: prototest
 * Date: 9/13/13
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Makr_Blog_Screen extends Makr_MenuBar_HeaderScreen {

    appElement Blog = new appElement ("Blog", By.name("BLOG"));
    appElement BlgSidebar = new appElement ("blgOpenSidebar", By.name("blgMenuOpenSidebar"));

    //These are the expected Blogs on page

    String BlogSelect = "//window1/UIACollectionView[1]/UIACollectionCell";

    List<appElement> ScreenElements;

   public Makr_Blog_Screen(){
       InitList();
       VerifyContent(ScreenElements);

   }

    private void InitList() {
        ScreenElements = new ArrayList<appElement>();
        ScreenElements.add(Blog);
        ScreenElements.add(BlgSidebar);

    }

    public void SelectBlog(int blogID){
        String stuff = "[" + String.valueOf(blogID) + "]";
        String elementXpath = BlogSelect + stuff;
        appElement SelectBlog = new appElement("SelectBlog", By.xpath(elementXpath));
        SelectBlog.tap();

    }
}
