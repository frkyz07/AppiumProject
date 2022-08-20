package Utility;

import Pages.LoginPage;
import Tests.AddCustomerTest;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

@Data
public class Helper {


    Faker faker = new Faker();
    LoginPage loginPage;

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public Helper(){
        PageFactory.initElements(new AppiumFieldDecorator(AddCustomerTest.Driver), this);
    }

    public String name(){return faker.name().firstName();}
    public String surname(){return faker.name().lastName();}
    public String fullName(){return faker.name().fullName();}
    public String workNumber(){return faker.number().digit();}


    public String email() {return fakeValuesService.bothify("????##@gmail.com");}
    public long phoneNumber(){return faker.number().randomNumber();}
    public String password(){return "123123";}
    public String address(){return String.valueOf(faker.address());}
    public String practiceCity(){return faker.address().city();}
    public String practiceZipCode(){return faker.address().zipCode();}

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
    public void login(){
       inPutter(loginPage.getSignInEmailTextInput(),eMail );
       inPutter(loginPage.getSignInPasswordTextInput(),password);
       loginPage.signInButton.click();
    }

}

