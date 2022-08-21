package Tests;

import Devices.DeviceFarm;
import Pages.*;

import Utility.Helper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;



public class SearchCustomerTest extends BaseDriver {

    public static AppiumDriver<?> Driver;

    String oreo;
    Helper helper;
    HomePage homePage;
    CustomerSearchPage customerSearchPage;

    private static Logger logger = LoggerFactory.getLogger(SearchCustomerTest.class);
    public SearchCustomerTest() throws MalformedURLException {
        oreo = DeviceFarm.ANDROID_OREO.path;    }


    @BeforeClass
    public void setup() throws MalformedURLException {
        try{
            BaseDriver baseDriver = new BaseDriver();
            logger.info("Driver initilaze");
        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
            logger.error("Driver Could not initilaze");
        }
    }
    @Test
    public void addCustomerTest() throws MalformedURLException {

        try{
            helper = new Helper();
            homePage = new HomePage();
            customerSearchPage = new CustomerSearchPage();
            logger.info("Pages initilazed");
        }catch (RuntimeException e ){
            System.out.println("Run time error "+e);
            logger.error("Pages could not initilazed");
        }

        try{
            helper.login();
            logger.info("Login is successfull");
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
            logger.error("Login is not successfull");
        }

        try{
            homePage.searchCustomerInfo.click();
            logger.info("Search customer page opened");
        }catch (NoSuchElementException | ElementNotVisibleException e){
                System.out.println("Couldnt find the element"+e);
                logger.error("Search customer could not opened");
        }

        try{
            customerSearchPage.search_plate.sendKeys(helper.phone);
            logger.info("Phone number send to search field");
        }catch (NoSuchElementException | ElementNotVisibleException e){
            System.out.println("Couldnt find the element"+e);
            logger.error("Phone number could not send to search filed");
    }

        try{
            Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());
            logger.info("Assertions passed");
        }catch(AssertionError e){
            System.out.println("Assertion Error"+e);
            logger.error("Assertion could not passed");
    }
    }

    @AfterClass
    public void waiter() throws InterruptedException {
        Thread.sleep(5000);
    }
    
}
