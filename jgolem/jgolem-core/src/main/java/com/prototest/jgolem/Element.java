
package com.prototest.jgolem;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

//Element class can be instantiated any time but only looks for the element on the page when a function is called
public class Element implements WebElement{
    private By by;
    private WebDriver driver;
    private String name;
    private WebElement element;
    public Verification Verify;

    public Element(String name, By by) {
        this.name = name;
        this.by = by;
        this.Verify = new Verification();
        this.driver = TestBase.getDriver();
    }

    public Verification Verify(int timeoutSec){
        return new Verification(this,timeoutSec);
    }

    public By getBy(){
        return by;
    }

    public WebElement getElement()
    {
            return driver.findElement(this.by);
    }

    public Point getLocation() {
        return getElement().getLocation();
    }

    public Dimension getSize() {
        return getElement().getSize();
    }

    public String getTagName() {
        return getElement().getTagName();
    }

    public String getText() {
        return getElement().getText();
    }

    public String getAttribute(String attribute) {
        try {
            return getElement().getAttribute(attribute);
        }
        catch (Exception e) {
            System.out.println("Failed to get attribute: " + attribute);
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public boolean isSelected() {
        if (getElement().isSelected()) return true;
        else return false;
    }

    @Override
    public boolean isEnabled() {
        if (getElement().isEnabled()) return true;
        else return false;
    }

    public String getCssValue(String css) {
        return getElement().getCssValue(css);
    }

    public Element setCheckbox(boolean checked) {
        if(getElement().isSelected() != checked) {
            getElement().click();
        }

        return this;
    }

    // this shit crashes
    public void setText(String text) {
        getElement().clear();
        getElement().sendKeys(text);
    }

    public WebElement findElement(By by) {
        return getElement().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        if ((isPresent())&&(getElement().isDisplayed())) return true;
        else
            return false;
    }

    public boolean isPresent() {
        if(driver.findElements(by).size()>0)
            return true;
        else
            return false;
    }


    public List<WebElement> findElements(By by) {
        return getElement().findElements(by);
    }

    public void clear() {
        getElement().clear();
    }

    public void click() {
        getElement().click();
    }

    public void submit() {
        getElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        sendKeys(charSequences.toString());
    }

    public void sendKeys(String text) {
        waitUntilVisible();
        getElement().sendKeys(text);
    }

    public Element waitUntilVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this;
    }
}
