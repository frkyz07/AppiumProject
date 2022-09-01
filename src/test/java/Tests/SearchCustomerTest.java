package Tests;

import Devices.DeviceFarm;
import Pages.*;

import io.qameta.allure.Description;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;



public class SearchCustomerTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(SearchCustomerTest.class);
    public SearchCustomerTest(){
        oreo = DeviceFarm.ANDROID_OREO.path;    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        try{
            homePage = new HomePage();
            customerSearchPage = new CustomerSearchPage();
            loginPage = new LoginPage();
            logger.info("Driver initialize");
        }catch (RuntimeException e){
            logger.error("Driver Could not initialize "+e);
        }
    }
    @Test
    @Description("addCustomerTest")
    public void addCustomerTest() throws MalformedURLException {

        try{
            loginPage.login();
            logger.info("Login is successful");
        }catch (RuntimeException e){
            logger.error("Login is not successful "+e);
        }

        try{
            homePage.searchCustomerInfo.click();
            logger.info("Search customer page opened");
        }catch (NoSuchElementException | ElementNotVisibleException e){
                logger.error("Search customer could not opened "+e);
        }

        try{
            customerSearchPage.search_plate.sendKeys(helper.phone);
            logger.info("Phone number send to search field");
        }catch (NoSuchElementException | ElementNotVisibleException e){
            logger.error("Phone number could not send to search filed "+e);
    }

        try{
            Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());
            logger.info("Assertions passed");
        }catch(AssertionError e){
            logger.error("Assertion could not passed "+e);
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
