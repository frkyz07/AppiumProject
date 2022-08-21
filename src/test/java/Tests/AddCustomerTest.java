package Tests;


import Pages.AddCustomerPage;
import Pages.CustomerSearchPage;

import Utility.Helper;
import Devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;

import lombok.SneakyThrows;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import Pages.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class AddCustomerTest {

    public static AppiumDriver<?> Driver;
    String oreo;
    Helper helper;
    HomePage homePage;
    AddCustomerPage addCustomerPage;
    CustomerSearchPage customerSearchPage;

    public AddCustomerTest() throws MalformedURLException {
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

        try {
            helper = new Helper();
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
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
            homePage.newCustomerInfo.click();
        }catch (NoSuchElementException e){
            System.out.println("Couldnt find the locator"+e);
        }

        try{
            addCustomerPage.customerTelNumber.sendKeys(helper.phone);
            helper.inPutter(addCustomerPage.customerNameSurname, helper.fullName());
        }catch (NoSuchElementException e){
            System.out.println("Coulndt find the locator"+e);
        }

        try{
            helper.scroll(Driver);
        }catch (RuntimeException e){
            System.out.println("Run time error"+e);
        }

        try{
            helper.inPutter(addCustomerPage.customerNotes, helper.workNumber());
            helper.inPutter(addCustomerPage.customerAddress, helper.address());
        }catch (NoSuchElementException e){
            System.out.println("Couldnt find the locator"+e);
        }

       try{
           addCustomerPage.btnDate.click();
           addCustomerPage.datePick.click();
           addCustomerPage.btnReceivedDate.click();
           addCustomerPage.returnDatePick.click();
           addCustomerPage.customerInfoSave.click();
       }catch (NoSuchElementException | ElementNotVisibleException e ){
           System.out.println("Coulnt find the element or element is not clickable"+e);
       }
        try{
            homePage.searchCustomerInfo.click();
            customerSearchPage.search_plate.sendKeys(helper.phone);
        }catch (NoSuchElementException | ElementNotVisibleException e)
        {
            System.out.println("Couldnt find the elemenet or element is not clickable");
        }

        try{
            Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());
        }catch (AssertionError e){
            System.out.println("Assertion error"+e);
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
