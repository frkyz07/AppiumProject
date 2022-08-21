package Tests;

import Devices.DeviceFarm;
import Pages.AddCustomerPage;
import Pages.HomePage;
import Utility.Helper;
import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.XSlf4j;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

@XSlf4j
public class AddCustomerDisplayedTest {

    // needed variables added
    public static AppiumDriver<?> Driver;
    String oreo;
    Helper helper;
    HomePage homePage;
    AddCustomerPage addCustomerPage;

    private static Logger logger = LoggerFactory.getLogger(AddCustomerDisplayedTest.class);


    // in here we are giving our apk path
    public AddCustomerDisplayedTest() throws MalformedURLException {
        oreo = DeviceFarm.ANDROID_OREO.path;
    }
    @BeforeTest
    public void setup() throws MalformedURLException {
        try{
            BaseDriver baseDriver = new BaseDriver();
            logger.info("Base Driver initilaze");
        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
            logger.error("Base Driver could not initilaze");
        }
    }
    @SneakyThrows
    @Test
    public void addNewCustomerTest(){

        try{
            helper = new Helper();
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
            logger.info("Pages initilaze");
        }catch (RuntimeException e ){
            System.out.println("Run time error "+e);
            logger.error("Pages could not initilaze");
        }

        try{
            helper.login();
            logger.info("Login is successfull");
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
            logger.error("Login is not successfull");
        }

        try {
            homePage.newCustomerInfo.click();
            logger.info("New customer page opened");
        }catch (NoSuchElementException | ElementNotVisibleException e){
            System.out.println("Couldnt find the element"+e);
            logger.error("New customer page could not opened");
        }

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
