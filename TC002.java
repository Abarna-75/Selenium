package com.BrowserLaunching;

import org.openqa.selenium.By;

public class TC002 extends BaseTest {

    public static void main(String[] args) throws Exception {


        initiatePropertiesFile();
        chooseBrowser("chromebrowser");
        goToSite("url");
        driver.manage().window().maximize();
        //calling all relevant methods to select from Amazon website - dropdown and enter an item and click go button from Base test

        selectItem("selectDropdownBox_id","Books");
        searchItem("searchTextbox_name","UCAT");
        clickSubmit("goButton_xpath");
        Thread.sleep(5000);
        driver.close();


    }
}
