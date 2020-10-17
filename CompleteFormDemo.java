package com.BrowserLaunching;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CompleteFormDemo {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Users//mahap//selenium download//chromedriver_win32//chromedriver.exe/");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();
        submitForm(driver);

        //adding explicit wait time to submit the form

        WebDriverWait myWaiter = new WebDriverWait(driver, 10);
        WebElement alertmsg = myWaiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
        //adding Assertion for Test Verification

        //import junit framework for java for assertEquals() from https://junit.org/junit5/ and the below pkg must be imported on the java class file
        
        //import static org.junit.Assert.assertEquals;
        String alertText= alertmsg.getText();

        String expMsg= ("The form was successfully submitted!");

        if(expMsg.equals(alertText)==true)
        {
            System.out.println("Your form has been successfully filled in");
        }
        else
            System.out.println("there is an error in filling out the form - Please Try again ");

    }

    public static void submitForm(ChromeDriver driver)
    {
        driver.findElementByCssSelector("#first-name"). sendKeys("Shiva");
        driver.findElementByCssSelector("#last-name").sendKeys("Shiva");
        driver.findElementByCssSelector("#job-title").sendKeys("Creator Of universe");
        driver.findElementByCssSelector("#radio-button-3").click();
        driver.findElementByCssSelector("#checkbox-1").click();
        driver.findElementByCssSelector("option[value='4']").click();
        WebElement  datePicker= driver.findElementByCssSelector("#datepicker");
        datePicker.sendKeys("10/20/2020");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        datePicker.sendKeys(Keys.RETURN);
        driver.findElementByCssSelector("a[role='button']").click();
    }

}
