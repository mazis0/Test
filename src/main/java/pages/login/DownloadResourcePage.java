package pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;


public class DownloadResourcePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Download data done\"]")
    private MobileElement labelDownloadDataDone;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"100\"]")
    private MobileElement percentageValue;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_next")
    private MobileElement buttonClose;

    public DownloadResourcePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public String getTextDownloadDataDone(){
        return getText(labelDownloadDataDone,"text downlaod data done");
    }

    public String getTextDownlaodPercentage(){
        return getText(percentageValue,"100");
    }

    public void clickOnCloseButton(){
        click(buttonClose);
    }
}
