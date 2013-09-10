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
        this.element = driver.findElement(b);
    }

    public void tap(){
        element.click();
    }

    public boolean verifyPresent(){

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
