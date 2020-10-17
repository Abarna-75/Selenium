package com.BrowserLaunching;

public class TC001 extends BaseTest{

    public static void main(String[] args) throws Exception {


         initiatePropertiesFile();
         chooseBrowser("chromebrowser");
         goToSite("url");
         driver.manage().window().maximize();
         String url = driver.getCurrentUrl();
         System.out.println(url);


    }
}
