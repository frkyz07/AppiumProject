package Tests;

import Devices.DeviceFarm;
import Pages.AddCustomerPage;
import Pages.HomePage;
import Pages.LoginPage;

import io.qameta.allure.Description;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class HomaPageDisplayedTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(HomaPageDisplayedTest.class);

    // in here we are giving our apk path
    public HomaPageDisplayedTest(){
        oreo = DeviceFarm.ANDROID_OREO.path;
    }
    @BeforeClass
    public void setup() throws MalformedURLException {
        try{
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
            loginPage = new LoginPage();
            logger.info("Driver initilazed");
        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
            logger.info("Driver could not initilazed");
        }
    }
    @Test
    @Description("addNewCustomerTest")
    public void addNewCustomerTest(){

        try{
            loginPage.login();
            logger.info("Login is successful");
        }catch (RuntimeException | MalformedURLException e){
            logger.error("Login is not successful "+e);
        }

        try {
            homePage.newCustomerInfo.click();
            logger.info("New Customer page opened");
        }catch (NoSuchElementException | ElementNotVisibleException e){
            logger.error("New Customer page could not opened "+e);
        }
        try {
            Assert.assertTrue(homePage.searchCustomerInfo.isDisplayed());
            Assert.assertTrue(homePage.newCustomerInfo.isDisplayed());
            Assert.assertTrue(homePage.oldCustomerInfo.isDisplayed());
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
