package Tests;

import Devices.DeviceFarm;
import Pages.*;
import Utility.BaseDriver;
import Utility.Helper;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CheckUserTest extends BaseTest{
    private static Logger logger = LoggerFactory.getLogger(CheckUserTest.class);

    public CheckUserTest() throws MalformedURLException {
        oreo = DeviceFarm.ANDROID_OREO.path;
    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        try{
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
            customerSearchPage = new CustomerSearchPage();
            updatePage = new UpdatePage();
            loginPage = new LoginPage();
            logger.info("Drive initilazed");
        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
            logger.error("Driver could not initilazed");
        }
    }
    @Test
    public void UpdateUserInformationTest() throws MalformedURLException {
        try{
            loginPage.login();
            logger.info("Login is successfull");
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
            logger.error("Logins is not successfull");
        }
        try{
            updatePage.search_button.click();
            logger.info("Search button clicked");
        }catch (NoSuchElementException | ElementNotVisibleException e){
            System.out.println("Couldnt find the element"+e);
            logger.error("Search button is not clicked");
        }

        try{
            helper.inPutter(updatePage.search_plate,helper.phone);
            updatePage.search_plate.sendKeys(Keys.ENTER);
            logger.info("Search text searched");
        }catch (NoSuchElementException | ElementNotVisibleException e){
            System.out.println("Couldnt find the element"+e);
            logger.error("Search text couldnt searched");
        }

        try{
            Assert.assertTrue(updatePage.customerRecord.isDisplayed());
            Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());
            logger.info("Assertion passed");
        }catch (AssertionError e){
            System.out.println("Assertion Error"+e);
            logger.error("Assertion could not passed");
        }

    }

    @AfterClass
    public void waiter() throws InterruptedException {
        try{
            Thread.sleep(5000);
            Driver.quit();
            logger.info("Drive closed");
        }catch (RuntimeException e){
            System.out.println("Couldnt quit the driver");
            logger.error("Driver could not clossed");
        }
    }

}
