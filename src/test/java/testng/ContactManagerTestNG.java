package testng;

import devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.HomePage;
import utility.DeviceFarmUtility;

import javax.swing.text.Utilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
public class ContactManagerTestNG {

    public static AppiumDriver<?> Driver;
    HomePage homePage;
    AddContactPage addContactPage;
    String oreo, kitkat;
    DesiredCapabilities capabilities;

    public ContactManagerTestNG() {
        oreo = DeviceFarm.ANDROID_OREO.path;
        kitkat = DeviceFarm.ANDROID_KITKAT.path;

    }
    @BeforeClass
    public void setup() throws MalformedURLException {

        capabilities = new DesiredCapabilities();
        capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.oreo);
        capabilities.setCapability("app", new File("src/test/resources/apps/ContactManager.apk").getAbsolutePath());
        Driver = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
        homePage = new HomePage();
        addContactPage = new AddContactPage();
    }
    @Test(priority = 0)
    public void openAddContactOnOreo() throws NullPointerException, InterruptedException {

        homePage.getAddContactBtn().click();
        Thread.sleep(4000);
    }
    @Test(priority = 1)
    public void checkAddContactTitle(){
        Assert.assertEquals(addContactPage.getTitle().getText(),"Add Contact");
    }
    @AfterClass
    public void waiter() throws InterruptedException {
        Thread.sleep(5000);
    }

}
