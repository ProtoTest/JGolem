package com.prototest.jgolem.web;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.prototest.jgolem.core.AutoInjection;
import com.prototest.jgolem.core.Verification;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//Element class can be instantiated any time but only looks for the element on the page when a function is called
public class Element extends WebAutoInjection implements WebElement {

    private By by;
    private String name;
    private WebElement element;

    private Logger logger = LoggerFactory.getLogger(getClass());
    //public Verification Verify;

    public Element(String name, By by) {
        this.name = name;
        this.by = by;
        // TODO use config
        //this.driver = TestBase.getDriver();
    }

    public Verification verify() {
        return verify(10);
    }

    public Verification verify(int timeoutSec) {
        return new Verification(this, timeoutSec);
    }

    public By getBy() {
        return by;
    }

    public WebElement getElement() {
        return driver.get().findElement(this.by);
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
        } catch (Exception e) {
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
        if (getElement().isSelected() != checked) {
            getElement().click();
        }

        return this;
    }

    // this shit crashes
    public void setText(String text) {
        logger.info("Set text for element ({}) to ({}).", name, text);
        getElement().clear();
        getElement().sendKeys(text);
    }

    public WebElement findElement(By by) {
        return getElement().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        if ((isPresent()) && (getElement().isDisplayed())) return true;
        else
            return false;
    }

    public boolean isPresent() {
        if (driver.get().findElements(by).size() > 0)
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
        WebDriverWait wait = new WebDriverWait(driver.get(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this;
    }
}
