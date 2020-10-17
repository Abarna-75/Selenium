// test to click radio buttons using three different locators

package com.BrowserLaunching;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonDemo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Users//mahap//selenium download//chromedriver_win32//chromedriver.exe/");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/radiobutton");
        driver.manage().window().maximize();
        WebElement radioButton1 = driver.findElementByCssSelector("#radio-button-1");
        radioButton1.click();
        Thread.sleep(1000);
        WebElement radioButton2= driver.findElementByCssSelector("input[value='option2']");
        radioButton2.click();
        Thread.sleep(1000);
        WebElement radioButton3= driver.findElementByXPath("//input[@value='option3']");
        radioButton3.click();
        Thread.sleep(1000);



    }
}
