package com.prototest.appium;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 6:03 PM
 * Elements for appium
 */
import org.openqa.selenium.*;
import org.openqa.selenium.lift.TestContext;

public class appElement {
    private By by;
    private WebDriver driver;
    private String name;
    private WebElement element;

    public appElement(String n, By b){
        this.name = n;
        this.by = b;
        this.driver = appiumTestBase.getDriver();
        //this.element = driver.findElement(b);
    }

    public WebElement getAppElement(){
        return element;
    }

    public void setAppElement(){
        element = driver.findElement(by);
    }



    public void tap(){
        setAppElement();
        element.click();
    }

    public boolean verifyPresent(){
        setAppElement();
        boolean exists;
        if(driver.findElements(this.by).size() != 0)
        {
            exists = true;
        }
        else {
            exists = false;
        }
        return exists;

    }
}
