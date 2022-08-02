package pages.onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HomeKoltivaPage{

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_login_bottom")
    private MobileElement masukButton;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/txt_versi")
    private MobileElement appVersion;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_logo")
    private MobileElement logoKoltiTrace;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_logo")
    private MobileElement language;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/img_logo_koltiva")
    private MobileElement logoKoltiva;

    private final AndroidDriver<AndroidElement> driver;

    public HomeKoltivaPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void clickLoginButton() {
        masukButton.click();
    }

    public boolean isUserOnHomePage(){
        logoKoltiva.isDisplayed();
        language.isDisplayed();
        logoKoltiTrace.isDisplayed();
        appVersion.isDisplayed();
        return true;
    }

}
