package Tests;

import Devices.DeviceFarm;
import Pages.AddCustomerPage;
import Pages.CustomerSearchPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utility.DeviceFarmUtility;
import Utility.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import jdk.jfr.DataAmount;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class SearchCustomerTest {

    public static AppiumDriver<?> Driver;
    HomePage homePage;
    LoginPage loginPage;
    CustomerSearchPage customerSearchPage;
    String oreo;
    DesiredCapabilities capabilities;
    Helper helper;

    public SearchCustomerTest() {
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
        customerSearchPage = new CustomerSearchPage();
        helper = new Helper();

    }
    @Test
    public void addCustomerTest(){

        loginPage = new LoginPage();

        helper.login();

        homePage.searchCustomerInfo.click();
        customerSearchPage.search_plate.sendKeys(helper.phone);

        Assert.assertEquals(helper.phone,customerSearchPage.textOne.getText());
    }

    @AfterClass
    public void waiter() throws InterruptedException {
        Thread.sleep(5000);
    }
    
}
