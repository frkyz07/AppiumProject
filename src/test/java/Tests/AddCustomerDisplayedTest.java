package Tests;

import Devices.DeviceFarm;
import Pages.AddCustomerPage;
import Pages.HomePage;
import Utility.BaseDriver;
import Utility.Helper;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AddCustomerDisplayedTest extends BaseDriver {

    // Log functions added
    private static Logger logger = LoggerFactory.getLogger(AddCustomerDisplayedTest.class);


    // in here we are giving our apk path
    public AddCustomerDisplayedTest() throws MalformedURLException {
        oreo = DeviceFarm.ANDROID_OREO.path;
    }
    // setting basedriver before test
    /*
    @BeforeClass
    public void setup() throws MalformedURLException {
        try{
            helper = new Helper();
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
            logger.info("Base Driver initilaze");
        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
            logger.error("Base Driver could not initilaze");
        }
    }*/
    // Add new Customer test craeted
    @Test
    public void addNewCustomerTest(){

        // login function called
        try{
            loginPage.login();
            logger.info("Login is successfull");
        }catch (RuntimeException | MalformedURLException e){
            System.out.println("Run time error"+e);
            logger.error("Login is not successfull");
        }
        // cicked in the new customer button
        try {
            homePage.newCustomerInfo.click();
            logger.info("New customer page opened");
        }catch (WebDriverException e){
            System.out.println("Couldnt find the element"+e);
            logger.error("New customer page could not opened");
        }
        // assertions added
        try {
            Assert.assertTrue(addCustomerPage.customerTelNumber.isDisplayed());
            Assert.assertTrue(addCustomerPage.customerNameSurname.isDisplayed());
            Assert.assertTrue(addCustomerPage.customerAddress.isDisplayed());
            logger.info("Assertions passed");
        }catch (NoSuchElementException | AssertionError e){
            System.out.println("Assertion error or Cant find the locators"+e);
            logger.error("Assertions didnt passed");
        }
    }
    // after test driver is closed
    @AfterClass
    public void waiter() throws InterruptedException {
        try{
            Thread.sleep(5000);
            Driver.quit();
            logger.info("Driver closed");
        }catch (RuntimeException e){
            System.out.println("Couldnt quit the driver");
            logger.error("Driver couldnt closed");
        }
    }
}
