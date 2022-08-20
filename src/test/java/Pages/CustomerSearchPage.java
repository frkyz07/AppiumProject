package Pages;

import Tests.AddCustomerTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

@Data
public class CustomerSearchPage {

    public CustomerSearchPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AddCustomerTest.Driver), this);
    }

    @AndroidFindBy(id = "search_plate")
    public MobileElement search_plate;

    @AndroidFindBy(id = "text1")
    public MobileElement textOne;

}
