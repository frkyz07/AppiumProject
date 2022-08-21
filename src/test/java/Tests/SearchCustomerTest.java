package Tests;

import Devices.DeviceFarm;
import Pages.*;

import Utility.Helper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

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

    public SearchCustomerTest() throws MalformedURLException {
        oreo = DeviceFarm.ANDROID_OREO.path;    }


    @BeforeClass
    public void setup() throws MalformedURLException {
        try{
            BaseDriver baseDriver = new BaseDriver();
        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
        }
    }
    @Test
    public void addCustomerTest() throws MalformedURLException {

        try{
            helper = new Helper();
            homePage = new HomePage();
            customerSearchPage = new CustomerSearchPage();
        }catch (RuntimeException e ){
            System.out.println("Run time error "+e);
        }

        try{
            helper.login();
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
        }

        try{
            homePage.searchCustomerInfo.click();
        }catch (NoSuchElementException | ElementNotVisibleException e){
                System.out.println("Couldnt find the element"+e);
        }

        try{
            customerSearchPage.search_plate.sendKeys(helper.phone);
        }catch (NoSuchElementException | ElementNotVisibleException e){
            System.out.println("Couldnt find the element"+e);
    }

        try{
            Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());
        }catch(AssertionError e){
            System.out.println("Assertion Error"+e);
    }
    }

    @AfterClass
    public void waiter() throws InterruptedException {
        Thread.sleep(5000);
    }
    
}
