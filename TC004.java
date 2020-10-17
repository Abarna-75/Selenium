package com.BrowserLaunching;
//TC004- Take screenshots

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.util.Date;
import java.util.List;

public class TC004 extends BaseTest{

    public static void main(String[] args) throws Exception {

        initiatePropertiesFile();
        chooseBrowser("chromebrowser");
        goToSite("url");
        driver.manage().window().maximize();

        Date dt = new Date();
        System.out.println(dt);
        String mydateNow= dt.toString().replace(":","_").replace(" ","_");

        System.out.println(mydateNow);
        File myScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(myScreenShot, new File("C:\\Users\\mahap\\Pictures\\Screenshots\\amazon.png"));
        //C:\Users\mahap\Pictures\Screenshots
        selectItem("selectDropdownBox_id", "Books");
        searchItem("searchTextbox_id", "Rajinikanth");
        clickSubmit("goButton_xpath");
        List<WebElement> rLinks = driver.findElements(By.partialLinkText("Rajinikanth"));
        int linksCount = rLinks.size();
        for(int i=0; i<linksCount;i++){
            if (!rLinks.get(i).getText().isEmpty())
            {
                rLinks.get(i).click();
                Thread.sleep(2000);
                File myThalaiva = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileHandler.copy(myThalaiva, new File("C:\\Users\\mahap\\Pictures\\Screenshots\\Rajinikanth_" +mydateNow+".png"));
                Thread.sleep(2000);
                driver.navigate().back();
                rLinks=driver.findElements(By.partialLinkText("Rajinikanth"));
        }
            driver.close();
        }



    }

    }