package com.BrowserLaunching;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToDemo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Users//mahap//selenium download//chromedriver_win32//chromedriver.exe/");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/switch-window");
        String originalWindow = driver.getWindowHandle();
        System.out.println(originalWindow);

        WebElement openTab = driver.findElementById("new-tab-button");
        openTab.click();

        System.out.println("list of all windows " + driver.getWindowHandles());
        //even though a new tab is open, the driver is still on the original window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);

        }

        Thread.sleep(6000);

        driver.switchTo().window(originalWindow);

        //driver.quit();
        System.out.println("making the focus shift to the pop up alert box ");
        WebElement popupButton = driver.findElementById("alert-button");
        popupButton.click();
        //calling alert method from Alert class
        Alert myalert = driver.switchTo().alert();
        Thread.sleep(6000);
        myalert.accept();  // to say ok for the alert message - to simulate clicking ok
    }
}










