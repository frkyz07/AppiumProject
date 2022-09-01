package Tests;

import Pages.*;
import Utility.BaseDriver;
import Utility.Helper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest extends BaseDriver {

    static AppiumDriver driver;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static CustomerSearchPage customerSearchPage;
    public static AddCustomerPage addCustomerPage;
    public static UpdatePage updatePage;
    public static Helper helper;

    @BeforeClass
    public WebDriver initilaze() throws MalformedURLException {
        driver = BaseDriver();
        helper = new Helper(driver);
        return driver;
    }
}
