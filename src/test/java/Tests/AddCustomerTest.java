package Tests;


import Pages.AddCustomerPage;
import Pages.CustomerSearchPage;

import Pages.LoginPage;
import Devices.DeviceFarm;


import io.qameta.allure.Description;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import Pages.HomePage;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class AddCustomerTest extends BaseTest{

    // log method created
    private static Logger logger = LoggerFactory.getLogger(AddCustomerTest.class);

    public AddCustomerTest(){
        oreo = DeviceFarm.ANDROID_OREO.path;
    }
    // before test initialized the driver

    @BeforeClass
    public void setup() throws MalformedURLException {
        try{
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
            customerSearchPage = new CustomerSearchPage();
            loginPage = new LoginPage();
            logger.info("Driver initialize");

        }catch (RuntimeException e){
            logger.error("Driver could not initialize "+e);
        }

    }
    // add customer test added
    @Test
    @Description("addNewCustomerTest")
    public void addNewCustomerTest(){

        try{
            loginPage.login();
            logger.info("Login is successful");
        }catch (RuntimeException | MalformedURLException e){
            logger.error("Login is not successful "+e);
        }
        try{
            homePage.newCustomerInfo.click();
            logger.info("New customer page opened");
        }catch (NoSuchElementException e){
            logger.error("New customer page could not opened "+e);
        }

        try{
            addCustomerPage.customerTelNumber.sendKeys(helper.phone);
            helper.inPutter(addCustomerPage.customerNameSurname, helper.fullName());
            logger.info("Customer information added");
        }catch (NoSuchElementException e){
            logger.error("Customer information could not added "+e);
        }

        try{
            helper.scroll(Driver);
            logger.info("Scroll worked");
        }catch (RuntimeException e){
            logger.error("Scroll could not worked "+e);
        }

        try{
            helper.inPutter(addCustomerPage.customerNotes, helper.workNumber());
            helper.inPutter(addCustomerPage.customerAddress, helper.address());
            logger.info("Customer information's added");
        }catch (NoSuchElementException e){
            logger.error("Customer information's could not added "+e);
        }

       try{
           addCustomerPage.btnDate.click();
           addCustomerPage.datePick.click();
           addCustomerPage.btnReceivedDate.click();
           addCustomerPage.returnDatePick.click();
           addCustomerPage.customerInfoSave.click();
           logger.info("Date are added");
       }catch (NoSuchElementException | ElementNotVisibleException e ){
           logger.error("Date are not added "+e);
       }
        try{
            homePage.searchCustomerInfo.click();
            customerSearchPage.search_plate.sendKeys(helper.phone);
            logger.info("Input send to the field");
        }catch (NoSuchElementException | ElementNotVisibleException e)
        {
            logger.error("Input could not sent "+e);
        }

        try{
            Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());
            logger.info("Assertions passed");
        }catch (AssertionError e){
            logger.error("Assertions could not passed "+e);
        }

    }

    @AfterClass
    public void waiter() throws InterruptedException {
        try{
            Thread.sleep(5000);
            Driver.quit();
            logger.info("Driver closed");
        }catch (RuntimeException e){
            logger.error("Driver could not closed "+e);
        }
    }

}
