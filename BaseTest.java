package com.BrowserLaunching;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static String browserName;
    public static String url;
    public static WebDriver driver;
    public static String projectPath= System.getProperty("user.dir");;
    public static FileInputStream fis;
    public static Properties prop;
    public static Properties parentProp;
    public static Properties childProp;
    public static Properties locProp;


    public static void initiatePropertiesFile() throws Exception {

         fis= new FileInputStream(projectPath+"//data.properties");
         prop = new Properties();  // use Properties class to initiate data.properties file on our class
         prop.load(fis);

         fis= new FileInputStream(projectPath+"//environment.properties");
         parentProp = new Properties();
         parentProp.load(fis);
         String environ = parentProp.getProperty("env");
         System.out.println(environ);

         fis= new FileInputStream(projectPath+"//"+environ +".properties");
         childProp= new Properties();
         childProp.load(fis);
         String currentUrl=  childProp.getProperty("url");
         System.out.println(currentUrl);

         //initiating the Locators.properties file

        fis= new FileInputStream(projectPath+"//locators.properties");
        locProp= new Properties();
        locProp.load(fis);

        /*initiating the logconfig.properties file to get the logs printed
        fis= new FileInputStream(projectPath+"//logconfig.properties");
         //use this class from log4j library to set up configuration. we dont have to read the file
        PropertyConfigurator.configure(fis);*/
        }

    public static void chooseBrowser(String browserName)
    {
        if(prop.getProperty(browserName).equalsIgnoreCase("chrome"))
        {
             System.setProperty("webdriver.chrome.driver",projectPath+"//drivers//chromedriver.exe");
              driver= new ChromeDriver();
        }else if (prop.getProperty(browserName).equalsIgnoreCase("firefox"))

        {
            //paste the path to gecko driver folder
        }

    }

    public static void goToSite(String url)
    {
        driver.get(childProp.getProperty(url));
    }

    public static void selectItem(String locator_key, String choice)
    {

        getElement(locator_key).sendKeys(choice);; // to find the locator type whether it is id or name or xpath dynamically

    }
    public static void searchItem(String locator_key, String searchedItem)
    {
        getElement(locator_key).sendKeys(searchedItem);
    }
    public static void clickSubmit(String locator_key)
    {
        getElement(locator_key).click();
    }

    public  static  WebElement getElement(String locator_key)
    {
        WebElement element =null;
        if(locator_key.endsWith("_id"))
        {
            element= driver.findElement(By.id(locProp.getProperty(locator_key)));
        }
        else if(locator_key.endsWith("_name"))
        {
           element= driver.findElement(By.name(locProp.getProperty(locator_key)));
        }
        else if(locator_key.endsWith("_xpath"))
        {
            element = driver.findElement(By.xpath(locProp.getProperty(locator_key)));
        }
        else if(locator_key.endsWith("_css"))

        {
        element= driver.findElement(By.cssSelector(locProp.getProperty(locator_key)));
        }
        else if(locator_key.endsWith("_link"))
        {
        element= driver.findElement(By.linkText(locProp.getProperty(locator_key)));
        }

        return element;
    }



}
