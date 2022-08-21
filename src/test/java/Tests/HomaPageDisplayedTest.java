package Tests;

import Devices.DeviceFarm;
import Pages.AddCustomerPage;
import Pages.HomePage;
import Utility.Helper;
import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class HomaPageDisplayedTest {

    public static AppiumDriver<?> Driver;
    String oreo;
    Helper helper;
    HomePage homePage;
    AddCustomerPage addCustomerPage;

    private static Logger logger = LoggerFactory.getLogger(HomaPageDisplayedTest.class);



    // in here we are giving our apk path
    public HomaPageDisplayedTest() throws MalformedURLException {
        oreo = DeviceFarm.ANDROID_OREO.path;
    }
    @BeforeTest
    public void setup() throws MalformedURLException {
        try{
            BaseDriver baseDriver = new BaseDriver();
            logger.info("Driver initilazed");
        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
            logger.info("Driver could not initilazed");
        }
    }
    @SneakyThrows
    @Test
    public void addNewCustomerTest(){

        try{
            helper = new Helper();
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
            logger.info("Pages initilazed");
        }catch (RuntimeException e ){
            System.out.println("Run time error "+e);
            logger.error("Pages are not initilazed");
        }

        try{
            helper.login();
            logger.info("Login is succesfull");
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
            logger.error("Login is not successfull");
        }

        try {
            homePage.newCustomerInfo.click();
            logger.info("New Customer page opened");
        }catch (NoSuchElementException | ElementNotVisibleException e){
            System.out.println("Couldnt find the element"+e);
            logger.error("New Customer page could not opened");
        }
        try {
            Assert.assertTrue(homePage.searchCustomerInfo.isDisplayed());
            Assert.assertTrue(homePage.newCustomerInfo.isDisplayed());
            Assert.assertTrue(homePage.oldCustomerInfo.isDisplayed());
            logger.info("Assertions passed");
        }catch (AssertionError e){
            System.out.println("Assertion Error"+e);
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
        }    }
}
