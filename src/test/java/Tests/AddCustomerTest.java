package Tests;


import Pages.AddCustomerPage;
import Pages.CustomerSearchPage;
import Pages.LoginPage;
import Utility.Helper;
import Devices.DeviceFarm;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Pages.HomePage;
import Utility.DeviceFarmUtility;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AddCustomerTest {

    // needed variables added
    public static AppiumDriver<?> Driver;
    HomePage homePage;
    LoginPage loginPage;
    AddCustomerPage addCustomerPage;
    CustomerSearchPage customerSearchPage;

    String oreo;
    DesiredCapabilities capabilities;
    Helper helper;




   // in here I create a method that takes the element text and finds the element with that text in the
    // homepage.

    // in here we are giving our apk path
    public AddCustomerTest() {
        oreo = DeviceFarm.ANDROID_OREO.path;
    }
    @BeforeClass
    public void setup() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.oreo);
        capabilities.setCapability("app", new File("/Users/farukayaz/Applications/patikaappium.apk").getAbsolutePath());
        Driver = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
        Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage();
        loginPage = new LoginPage();
        addCustomerPage = new AddCustomerPage();
        customerSearchPage = new CustomerSearchPage();
        helper = new Helper();

    }
    // in here I write the tests in the feature file with every possible options
    // check the add contact button is working or not


    @Test
    public void addNewCustomerTest(){
        homePage = new HomePage();

        helper.login();

        homePage.newCustomerInfo.click();
        addCustomerPage.customerTelNumber.sendKeys(helper.phone);
        helper.inPutter(addCustomerPage.customerNameSurname, helper.fullName());

        helper.scroll(Driver);

        helper.inPutter(addCustomerPage.customerNotes, helper.workNumber());
        helper.inPutter(addCustomerPage.customerAddress, helper.address());
        addCustomerPage.btnDate.click();
        addCustomerPage.datePick.click();
        addCustomerPage.btnReceivedDate.click();
        addCustomerPage.returnDatePick.click();
        addCustomerPage.customerInfoSave.click();

        homePage.searchCustomerInfo.click();
        customerSearchPage.search_plate.sendKeys(helper.phone);

        Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());

    }

    @AfterClass
    public void waiter() throws InterruptedException {
        Thread.sleep(5000);
    }

}
