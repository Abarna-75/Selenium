package com.BrowserLaunching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DropDownDemo extends BaseTest{

    public static void main(String[] args) throws Exception {

        initiatePropertiesFile();
        chooseBrowser("chromebrowser");
        goToSite("url");
        driver.manage().window().maximize();

        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));



        WebElement ddMenuItem = driver.findElement(By.cssSelector("option[value='search-alias=beauty-intl-ship']"));
        ddMenuItem.click();
        WebElement searchBox= driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("Shiva");
     //   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement goButton= driver.findElement(By.cssSelector("input[type='submit'][class='nav-input'][value='Go']"));
        goButton.click();


        WebDriverWait myWait= new WebDriverWait(driver, 10);
        WebElement searchResults= myWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("SHIVA REA: DAILY ENERGY COLLECTION")));
        searchResults.click();



    }
}
