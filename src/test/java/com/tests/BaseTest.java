package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    @BeforeTest

    //BROWSER=>chrome/firefox
    //hub_host=lpcalhost/10.2.34.
    public void setup(ITestContext ctx) throws MalformedURLException {

        String host="localhost";
        DesiredCapabilities dc;
        if(System.getProperty("BROWSER")!=null &&
        System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc= DesiredCapabilities.firefox();
        }else{
            dc=DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST")!=null ){
            host= System.getProperty("HUB_HOST");

        }
        String testname=ctx.getCurrentXmlTest().getName();
        String completeUrl="http://" + host + ":4444/wd/hub/";
        dc.setCapability("name",testname);
        this.driver = new RemoteWebDriver(new URL(completeUrl),dc);

    }
    @AfterTest
    public void quit(){
        this.driver.quit();
    }
}


