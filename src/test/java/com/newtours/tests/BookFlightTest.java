package com.newtours.tests;

import com.tests.BaseTest;
import newtours.page.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;
    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setupParameters(String noOfPassengers,String expectedPrice){
        this.noOfPassengers=noOfPassengers;
        this.expectedPrice=expectedPrice;

    }

    @Test
    public void registerationPage() throws InterruptedException {
        RegisterationPage registerationPage =new RegisterationPage(driver);
        registerationPage.goTo();
        registerationPage.enterUserDetails("Kunal","Docker");
        registerationPage.userCredentials("Kunal","Docker");

        Thread.sleep(20000);
        registerationPage.submit();

    }
    @Test(dependsOnMethods = "registerationPage")
    public void registerationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage= new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailPage();
    }

    @Test(dependsOnMethods = "registerationConfirmationPage")
    public void flightDetailPage(){
        FlightDetailPage flightDetailPage =new FlightDetailPage(driver);
        flightDetailPage.selectPassangers(noOfPassengers);
        flightDetailPage.goToFindFlightDetailPage();
    }

    @Test(dependsOnMethods = "flightDetailPage")
    public void findFlightPage(){
        FindFlightPage findFlightPage =new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.goToFlightConfirmationPage();

    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage= new FlightConfirmationPage(driver);
        String actualPrice=flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice,expectedPrice);
    }



}
