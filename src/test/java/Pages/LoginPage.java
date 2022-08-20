package Pages;

import Tests.AddCustomerTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

@Data
public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AddCustomerTest.Driver), this);
    }

    @AndroidFindBy(id = "signInEmailTextInput")
    public MobileElement signInEmailTextInput;

    @AndroidFindBy(id = "signInPasswordTextInput")
    public MobileElement signInPasswordTextInput;

    @AndroidFindBy(id = "signInButton")
    public MobileElement signInButton;
}
