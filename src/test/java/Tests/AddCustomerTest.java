package Tests;


import Pages.AddCustomerPage;
import Pages.CustomerSearchPage;

import Utility.Helper;
import Devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;

import lombok.SneakyThrows;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import Pages.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class AddCustomerTest {

    public static AppiumDriver<?> Driver;
    String oreo;
    Helper helper;
    HomePage homePage;
    AddCustomerPage addCustomerPage;
    CustomerSearchPage customerSearchPage;

    // log method created
    private static Logger logger = LoggerFactory.getLogger(AddCustomerTest.class);

    public AddCustomerTest() throws MalformedURLException {
        oreo = DeviceFarm.ANDROID_OREO.path;
    }
    // before test initilazed the driver
    @BeforeTest
    public void setup() throws MalformedURLException {
        try{
            BaseDriver baseDriver = new BaseDriver();
            logger.info("Driver initilaze");

        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
            logger.error("Driver could not initilaze");
        }

    }
    // add customer test added
    @SneakyThrows
    @Test
    public void addNewCustomerTest(){

        try {
            helper = new Helper();
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
            customerSearchPage = new CustomerSearchPage();
            logger.info("Pages initilazed");
        }catch (RuntimeException e ){
            System.out.println("Run time error "+e);
            logger.error("Pages could not initilazed");
        }

        try{
            helper.login();
            logger.info("Login is succesfull");
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
            logger.error("Login is not succesfull");
        }
        try{
            homePage.newCustomerInfo.click();
            logger.info("New customer page opened");
        }catch (NoSuchElementException e){
            System.out.println("Couldnt find the locator"+e);
            logger.error("New customer page could not opened");
        }

        try{
            addCustomerPage.customerTelNumber.sendKeys(helper.phone);
            helper.inPutter(addCustomerPage.customerNameSurname, helper.fullName());
            logger.info("Customer information added");
        }catch (NoSuchElementException e){
            System.out.println("Coulndt find the locator"+e);
            logger.error("Customer information could not added");
        }

        try{
            helper.scroll(Driver);
            logger.info("Scroll worked");
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
            logger.error("Scroll could not worked");
        }

        try{
            helper.inPutter(addCustomerPage.customerNotes, helper.workNumber());
            helper.inPutter(addCustomerPage.customerAddress, helper.address());
            logger.info("Customer informations added");
        }catch (NoSuchElementException e){
            System.out.println("Couldnt find the locator"+e);
            logger.error("Customer informations could not added");
        }

       try{
           addCustomerPage.btnDate.click();
           addCustomerPage.datePick.click();
           addCustomerPage.btnReceivedDate.click();
           addCustomerPage.returnDatePick.click();
           addCustomerPage.customerInfoSave.click();
           logger.info("Date are added");
       }catch (NoSuchElementException | ElementNotVisibleException e ){
           System.out.println("Coulnt find the element or element is not clickable"+e);
           logger.error("Date are not added");
       }
        try{
            homePage.searchCustomerInfo.click();
            customerSearchPage.search_plate.sendKeys(helper.phone);
            logger.info("Input send to the field");
        }catch (NoSuchElementException | ElementNotVisibleException e)
        {
            System.out.println("Couldnt find the elemenet or element is not clickable");
            logger.error("Input could not sended");
        }

        try{
            Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());
            logger.info("Assertions passed");
        }catch (AssertionError e){
            System.out.println("Assertion error"+e);
            logger.error("Assertions could not passed");
        }

    }

    @AfterClass
    public void waiter() throws InterruptedException {
        try{
            Thread.sleep(5000);
            Driver.quit();
            logger.info("Driver closed");
        }catch (RuntimeException e){
            System.out.println("Couldnt quit the driver");
            logger.error("Driver could not closed");
        }
    }

}
