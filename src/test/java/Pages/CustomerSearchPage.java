package Pages;

import Tests.AddCustomerTest;
import Tests.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

@Data
public class CustomerSearchPage {

    BaseDriver baseDriver;

    public CustomerSearchPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(baseDriver.Driver), this);
    }
    @AndroidFindBy(id = "search_plate")
    public MobileElement search_plate;

    @AndroidFindBy(id = "text1")
    public MobileElement textOne;

}
