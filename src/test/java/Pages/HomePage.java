package Pages;

import Tests.SearchCustomerTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import Tests.AddCustomerTest;

@Data
public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(SearchCustomerTest.Driver), this);
    }
    @AndroidFindBy(id = "com.appium.patika:id/newCustomerInfo")
    public MobileElement newCustomerInfo;

    @AndroidFindBy(id = "searchCustomerInfo")
    public MobileElement  searchCustomerInfo;

    @AndroidFindBy(id = "oldCustomerInfo")
    public MobileElement  oldCustomerInfo;

}
