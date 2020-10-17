package com.BrowserLaunching;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class BrowserLaunch {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C://Users//mahap//selenium download//chromedriver_win32//chromedriver.exe/");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in");
        WebElement element1 = driver.findElementByName("q");
        element1.sendKeys("amma");
        element1.submit();



        //sleep(6000);
        //driver.quit();
        //driver.get("https://realestate.com.au");






    }


}
