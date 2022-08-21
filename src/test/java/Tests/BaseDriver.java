package Tests;

import Devices.DeviceFarm;
import Pages.CustomerSearchPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utility.DeviceFarmUtility;
import Utility.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class BaseDriver {

    public static AppiumDriver<?> Driver;
    HomePage homePage;
    LoginPage loginPage;
    CustomerSearchPage customerSearchPage;
    String oreo;
    DesiredCapabilities capabilities;
    Helper helper;

    // create a base driver function to run our driver in every test
    public BaseDriver() throws MalformedURLException {

        oreo = DeviceFarm.ANDROID_OREO.path;
        capabilities = new DesiredCapabilities();
        capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.oreo);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", new File("/Users/farukayaz/Applications/patikaappium.apk").getAbsolutePath());
        Driver = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
        Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage();
        loginPage = new LoginPage();
        customerSearchPage = new CustomerSearchPage();
        helper = new Helper();
    }

}
