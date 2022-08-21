package Pages;

import Tests.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import Tests.AddCustomerTest;

import java.net.MalformedURLException;


@Data
public class AddCustomerPage extends BaseDriver {

    BaseDriver baseDriver;
    public AddCustomerPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(baseDriver.Driver), this);
    }


    @AndroidFindBy(id = "newCustomerInfo")
    public MobileElement newCustomerInfo;

    @AndroidFindBy(id = "customertelnumber")
    public MobileElement customerTelNumber;

    @AndroidFindBy(id = "customernamesurname")
    public MobileElement customerNameSurname;

    @AndroidFindBy(id = "customerworktracknumber")
    public MobileElement customerWorkTrackNumber;

    @AndroidFindBy(id = "customernotes")
    public MobileElement customerNotes;

    @AndroidFindBy(id = "com.appium.patika:id/customeraddress")
    public MobileElement customerAddress;

    @AndroidFindBy(id = "in_date")
    public MobileElement inDate;

    @AndroidFindBy(id = "btn_date")
    public MobileElement btnDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"27 August 2022\"]")
    public MobileElement datePick;

    @AndroidFindBy(id = "in_received_date")
    public MobileElement  inReceivedDate;

    @AndroidFindBy(id = "btn_received_date")
    public MobileElement  btnReceivedDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"31 August 2022\"]")
    public MobileElement returnDatePick;

    @AndroidFindBy(id = "customerInfoSave")
    public MobileElement  customerInfoSave;







}
