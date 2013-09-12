package com.prototest.appiumcore;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/9/13
 * Time: 6:03 PM
 * Elements for appium
 */
import org.openqa.selenium.*;


import java.util.HashMap;

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

    public String getName(){
        return this.name;
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

    public void AcceptAlert(){
        driver.switchTo().alert().accept();

    }

    public void Swipe(String direction) {
        double SwipeDuration = 0.5; //This is the minimum amount, anything less crashes the app
        direction.toUpperCase();
        if ((direction.equals("LEFT")) || (direction.equals("L"))) {
            SwipeDirection(0.95, 0.5, 0.05, 0.5, SwipeDuration);
        } else if ((direction.equals("RIGHT")) || (direction.equals("R"))) {
            SwipeDirection(0.05, 0.5, 0.95, 0.5, SwipeDuration);
        } else if ((direction.equals("UP")) || (direction.equals("U"))) {
            SwipeDirection(0.5, 0.95, 0.5, 0.05, SwipeDuration);
        } else if ((direction.equals("DOWN")) || (direction.equals("D"))) {
            SwipeDirection(0.5, 0.05, 0.5, 0.95, SwipeDuration);
        } else {
            System.out.println("Invalid Swipe Direction called.");
        }
    }

    public void SendKeys(String text){
        element.sendKeys(text);
    }
    public String getText(){
        return element.getText();
    }

    public void ScrollUp(){
       SwipeDirection(0.0, 0.0, 0.5, 0.95, 0.0);
    }

    public void ScrollDown(){
        SwipeDirection(0.0, 0.0, 0.5, 0.20, 0.0);
    }
    private void SwipeDirection(Double SrtX, Double SrtY, Double endX, Double endY, Double duration){

        setAppElement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();

        if(duration > 0.0)
        {
            swipeObject.put("startX", SrtX);
            swipeObject.put("startY", SrtY);
            swipeObject.put("endX", endX);
            swipeObject.put("endY", endY);
            swipeObject.put("duration", duration);
            js.executeScript("mobile: swipe", swipeObject);
        }
        else {

            swipeObject.put("endX", endX);
            swipeObject.put("endY", endY);
            js.executeScript("mobile: flick", swipeObject);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread Sleep in SwipeDirection() Interrupted");
        }
    }

}
