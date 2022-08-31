package Pages;

import Utility.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

@Data
public class UpdatePage  {

    public UpdatePage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(BaseDriver.Driver), this);
    }
    @AndroidFindBy(id = "search_button")
    public MobileElement search_button;

    @AndroidFindBy(id = "search_plate")
    public MobileElement search_plate;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView")
    public MobileElement customerRecord;


}
