package Pages;


import Utility.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

import static Utility.BaseDriver.helper;

@Data
public class LoginPage {


    public LoginPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(BaseDriver.Driver), this);
    }

    @AndroidFindBy(id = "signInEmailTextInput")
    public MobileElement signInEmailTextInput;

    @AndroidFindBy(id = "signInPasswordTextInput")
    public MobileElement signInPasswordTextInput;

    @AndroidFindBy(id = "signInButton")
    public MobileElement signInButton;

    public void login() throws MalformedURLException {


        helper.inPutter(getSignInEmailTextInput(),helper.eMail );
        helper.inPutter(getSignInPasswordTextInput(),helper.password);
        signInButton.click();
    }
}
