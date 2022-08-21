package Tests;

import Devices.DeviceFarm;
import Pages.AddCustomerPage;
import Pages.HomePage;
import Utility.Helper;
import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
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


    // in here we are giving our apk path
    public HomaPageDisplayedTest() throws MalformedURLException {
        oreo = DeviceFarm.ANDROID_OREO.path;
    }
    @BeforeTest
    public void setup() throws MalformedURLException {
        try{
            BaseDriver baseDriver = new BaseDriver();
        }catch (RuntimeException e){
            System.out.println("Couldnt start the Driver"+e);
        }
    }
    @SneakyThrows
    @Test
    public void addNewCustomerTest(){

        try{
            helper = new Helper();
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
        }catch (RuntimeException e ){
            System.out.println("Run time error "+e);
        }

        try{
            helper.login();
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
        }

        try {
            homePage.newCustomerInfo.click();
        }catch (NoSuchElementException | ElementNotVisibleException e){
            System.out.println("Couldnt find the element"+e);
        }
        try {
            Assert.assertTrue(homePage.searchCustomerInfo.isDisplayed());
            Assert.assertTrue(homePage.newCustomerInfo.isDisplayed());
            Assert.assertTrue(homePage.oldCustomerInfo.isDisplayed());
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
        }    }
}
