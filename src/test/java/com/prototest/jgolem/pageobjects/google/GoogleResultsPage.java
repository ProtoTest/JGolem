package com.prototest.jgolem.pageobjects.google;

/**
 * Created with IntelliJ IDEA.
 * User: rizza
 * Date: 8/21/13
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
import com.prototest.jgolem.framework.Element;
import org.openqa.selenium.By;

public class GoogleResultsPage {
    //Element googleLogo = new Element("GoogleLogo", By.className("qbqlca"));
    Element searchField = new Element("SearchField", By.name("q"));
    Element searchButton = new Element("SearchButton", By.name("btnK"));
    Element signInButton = new Element("SignInButton", By.className("gbit"));
    Element gmailbutton = new Element("GmailButton", By.partialLinkText("Gmail"));
    private Element searchResult;

    public Element searchResult(String text)
    {
        searchResult = new Element("SearchResultLink", By.partialLinkText(text));
        return searchResult;
    }

    private String searchString;

    public GoogleResultsPage SearchFor(String text)
    {
        searchField.sendKeys(text);
        searchField.submit();
        return new GoogleResultsPage();
    }

    public GoogleResultsPage VerifyResult(String text)
    {
        searchResult(text).VerifyVisible(10);
        return new GoogleResultsPage();
    }

    public SearchResultPage GoToResult(String text)
    {
        searchResult(text).click();
        return new SearchResultPage();
    }
}
