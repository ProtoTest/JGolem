package com.prototest.jgolem;

import com.prototest.jgolem.web.BasePage;
import com.prototest.jgolem.web.Element;
import com.prototest.jgolem.web.WebBrowserTestBase;
import org.openqa.selenium.By;

public class GoogleHomePage extends BasePage {

    Element searchField = new Element("SearchField", By.name("q"));
    //Element googleLogo = new Element("GoogleLogo", By.id("hplogo"));
    Element searchButton = new Element("SearchButton", By.name("btnK"));
    Element feelingLuckyButton = new Element("ImFeelingLuckyButton", By.name("btnI"));
    Element signInButton = new Element("SignInButon", By.className("gbit"));
    Element gmailbutton = new Element("GmailButton", By.className("gbts"));

    public static GoogleHomePage OpenGoogle()
    {
        GoogleHomePage homePage = new GoogleHomePage();
        homePage.getDriver().navigate().to("http://www.google.com/");
        return homePage;
    }

    public GoogleResultsPage SearchFor(String text)
    {
        logger.info("Searching Google for ({})", text);
        searchField.setText(text);
        searchField.submit();
        return new GoogleResultsPage();
    }

}
