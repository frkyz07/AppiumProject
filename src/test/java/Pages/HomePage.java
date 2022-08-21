package Pages;

import Tests.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;


import java.net.MalformedURLException;

@Data
public class HomePage {

    BaseDriver baseDriver;

    public HomePage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(baseDriver.Driver), this);
    }
    @AndroidFindBy(id = "newCustomerInfo")
    public MobileElement newCustomerInfo;

    @AndroidFindBy(id = "searchCustomerInfo")
    public MobileElement  searchCustomerInfo;

    @AndroidFindBy(id = "oldCustomerInfo")
    public MobileElement  oldCustomerInfo;

}
