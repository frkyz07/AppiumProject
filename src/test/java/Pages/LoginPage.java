package Pages;


import Tests.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

@Data
public class LoginPage {

    BaseDriver baseDriver;

    public LoginPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(baseDriver.Driver), this);
    }

    @AndroidFindBy(id = "signInEmailTextInput")
    public MobileElement signInEmailTextInput;

    @AndroidFindBy(id = "signInPasswordTextInput")
    public MobileElement signInPasswordTextInput;

    @AndroidFindBy(id = "signInButton")
    public MobileElement signInButton;
}
