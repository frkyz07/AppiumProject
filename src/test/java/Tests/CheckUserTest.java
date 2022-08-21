package Tests;

import Devices.DeviceFarm;
import Pages.*;
import Utility.Helper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CheckUserTest {
    public static AppiumDriver<?> Driver;

    HomePage homePage;
    AddCustomerPage addCustomerPage;
    UpdatePage updatePage;
    CustomerSearchPage customerSearchPage;
    String oreo;
    Helper helper;
    public CheckUserTest() throws MalformedURLException {
        oreo = DeviceFarm.ANDROID_OREO.path;
    }
    @BeforeClass
    public void setup() throws MalformedURLException {
        try{
            BaseDriver baseDriver = new BaseDriver();
        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
        }
    }
    @Test
    public void UpdateUserInformationTest() throws MalformedURLException {
         try{
            helper = new Helper();
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
            customerSearchPage = new CustomerSearchPage();
            updatePage = new UpdatePage();
         }catch (RuntimeException e ){
            System.out.println("Run time error "+e);
          }

        try{
            helper.login();
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
        }
        try{
            updatePage.search_button.click();
        }catch (NoSuchElementException | ElementNotVisibleException e){
            System.out.println("Couldnt find the element"+e);
        }

        try{
            helper.inPutter(updatePage.search_plate,helper.phone);
            updatePage.search_plate.sendKeys(Keys.ENTER);
        }catch (NoSuchElementException | ElementNotVisibleException e){
            System.out.println("Couldnt find the element"+e);
        }

        try{
            Assert.assertTrue(updatePage.customerRecord.isDisplayed());
            Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());
        }catch (AssertionError e){
            System.out.println("Assertion Error"+e);
        }

    }

    @AfterClass
    public void waiter() throws InterruptedException {
        try{
            Thread.sleep(5000);
            Driver.quit();
        }catch (RuntimeException e){
            System.out.println("Couldnt quit the driver");
        }
    }

}
