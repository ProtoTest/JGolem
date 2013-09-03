package com.prototest.jgolem.pageobjects.google;

/**
 * Created with IntelliJ IDEA.
 * User: rizza
 * Date: 8/21/13
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
import com.prototest.jgolem.framework.Element;
import com.prototest.jgolem.framework.TestBase;
import org.openqa.selenium.By;

public class GoogleHomePage {

    Element searchField = new Element("SearchField", By.name("q"));
    //Element googleLogo = new Element("GoogleLogo", By.id("hplogo"));
    Element searchButton = new Element("SearchButton", By.name("btnK"));
    Element feelingLuckyButton = new Element("ImFeelingLuckyButton", By.name("btnI"));
    Element signInButton = new Element("SignInButon", By.className("gbit"));
    Element gmailbutton = new Element("GmailButton", By.className("gbts"));

    public static GoogleHomePage OpenGoogle()
    {

        TestBase.getDriver().navigate().to("http://www.google.com/");
        return new GoogleHomePage();
    }

    public GoogleResultsPage SearchFor(String text)
    {
        searchField.setText(text);
        searchField.submit();
        return new GoogleResultsPage();
    }

}
