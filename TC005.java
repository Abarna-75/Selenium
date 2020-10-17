package com.BrowserLaunching;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TC005 extends BaseTest{

    public static void main(String[] args) throws Exception {
        Date dt = new Date();
        System.out.println(dt);
        String mydateNow= dt.toString().replace(":","_").replace(" ","_");
        System.out.println(mydateNow);
        initiatePropertiesFile();
        chooseBrowser("chromebrowser");
        goToSite("url");
        driver.manage().window().maximize();
        selectItem("selectDropdownBox_id","Arts & Crafts");
        searchItem("searchTextbox_id","Shiva");
        clickSubmit("goButton_xpath");


        List<WebElement> allLinks = driver.findElements(By.cssSelector("span[dir='auto']"));

        for (int i = 0; i < allLinks.size(); i++) {

            if (!allLinks.get(i).getText().isEmpty())
            {
                String thisLinkName = allLinks.get(i).getText(); // to get the text of the link at index i
                allLinks.get(i).click(); // to click on the first link
                System.out.println("now navigating to all links after searching for Shiva");
                File shivaScrn = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileHandler.copy(shivaScrn, new File("C:\\Users\\mahap\\Pictures\\Screenshots\\" + thisLinkName + mydateNow + ".png"));
                Thread.sleep(5000);
                driver.navigate().back();
                allLinks = driver.findElements(By.cssSelector("span[dir='auto']")); // loading the alllinks web element list  with all the links
            }

            else

                System.out.println("no elements found");
            driver.close();

        }
    }
}
