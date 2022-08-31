package Utility;

import Pages.LoginPage;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

import java.util.Locale;

@Data
public class Helper {
    Faker faker = new Faker();
    BaseDriver baseDriver;

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public Helper() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(baseDriver.Driver), this);
    }

    public String fullName(){return faker.name().fullName();}
    public String workNumber(){return faker.number().digit();}
    public String address(){return String.valueOf(faker.address());}
    public void inPutter(MobileElement element, String keys){
        element.sendKeys(keys);
    }

    public String proReader(String properties){
        return ConfigReader.getProperty(properties);
    }
    public String eMail = proReader("mail");
    public String password = proReader("password");
    public String phone = proReader("phone");

    public void scroll(AppiumDriver driver) {
        Dimension dimensions = driver.manage().window().getSize();
        int Startpoint = (int) (dimensions.getHeight() * 0.5);
        int scrollEnd = (int) (dimensions.getHeight() * 0.5);
        driver.swipe(200, Startpoint,200,scrollEnd,2000);
    }


}

