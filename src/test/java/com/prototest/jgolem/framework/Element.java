/**
 * Created with IntelliJ IDEA.
 * User: rizza
 * Date: 8/13/13
 * Time: 9:09 AM
 * To change this template use File | Settings | File Templates.
 */
//package JGolem.framework;

package com.prototest.jgolem.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Element {
    private By by;
    private WebDriver driver;
    private String name;
    private WebElement element;

    public Element(String name, By by) {
        this.name = name;
        this.by = by;
        this.driver = TestBase.getDriver();
        try {
            this.element = driver.findElement(by);
        }catch (NoSuchElementException e) {
            System.out.println("Failed to find element: " + this.name);
            e.printStackTrace();
        }
    }

    public boolean getDisplayed() {
        return element.isDisplayed();
    }

    public boolean getEnabled() {
        return element.isEnabled();
    }

    public boolean getSelected() {
        return element.isSelected();
    }

    public Point getLocation() {
        return element.getLocation();
    }

    public Dimension getSize() {
        return element.getSize();
    }

    public String getTagName() {
        return element.getTagName();
    }

    public String getText() {
        return element.getText();
    }

    public String getAttribute(String attribute) {
        try {
            return element.getAttribute(attribute);
        }
        catch (Exception e) {
            System.out.println("Failed to get attribute: " + attribute);
            e.printStackTrace();
        }

        return "";
    }

    public String getCssValue(String css) {
        return element.getCssValue(css);
    }

    public Element setCheckbox(boolean checked) {
        if(element.isSelected() != checked) {
            element.click();
        }

        return this;
    }

    // this shit crashes
    public void setText(String text) {
        WebElement textField = element;
        textField.clear();
        textField.sendKeys(text);
    }

    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    public void clear() {
        element.clear();
    }

    public void click() {
        element.click();
    }

    public void submit() {
        element.submit();
    }

    public void sendKeys(String text) {
        waitUntilVisible();
        element.sendKeys(text);
    }


    /* TODO */
    // TODO
    public Element waitUntilVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this;
    }

    public Element VerifyVisible() {
        return this;
    }

    public Element VerifyVisible(int seconds) {
        if (seconds >= 0) {
            return this;
        }
        else {
            return null;
        }
    }


}
