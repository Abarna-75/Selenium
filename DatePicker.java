package com.BrowserLaunching;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;

public class DatePicker {
    public static void main(String[] args) throws Exception {


        System.setProperty("webdriver.chrome.driver", "C://Users//mahap//selenium download//chromedriver_win32//chromedriver.exe/");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/datepicker");
        driver.manage().window().maximize();
        WebElement datePicker =driver.findElementByCssSelector("input#datepicker");
        datePicker.sendKeys("10/10/2020");
        Thread.sleep(1000);
        datePicker.sendKeys(Keys.RETURN);  // to hit the Enter or RETURN key





    }

}
