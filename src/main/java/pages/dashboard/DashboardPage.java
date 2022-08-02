package pages.dashboard;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;


public class DashboardPage extends BasePage {
    @AndroidFindBy(id = "com.koltiva.koltitrace:id/tvGreeting")
    private MobileElement txtGreatingHi;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/tvUserName")
    private MobileElement txtGreatingDescription;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.koltiva.koltitrace:id/menu_icon\"])[1]")
    private MobileElement labelDashboard;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.koltiva.koltitrace:id/menu_icon\"])[2]")
    private MobileElement labelLandUse;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.koltiva.koltitrace:id/menu_icon\"])[3]")
    private MobileElement labelActionPlan;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.koltiva.koltitrace:id/menu_icon\"])[4]")
    private MobileElement labelTraining;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.koltiva.koltitrace:id/menu_icon\"])[5]")
    private MobileElement labelProducer;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.koltiva.koltitrace:id/menu_icon\"])[6]")
    private MobileElement labelSME;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.koltiva.koltitrace:id/menu_icon\"])[7]")
    private MobileElement labelGroup;

    public DashboardPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isUserOnDashboardPage(){
        waitForVisibility(txtGreatingHi);
        txtGreatingHi.isDisplayed();
        txtGreatingDescription.isDisplayed();
        labelDashboard.isDisplayed();
        labelDashboard.isEnabled();
        labelActionPlan.isDisplayed();
        labelActionPlan.isEnabled();
        labelLandUse.isDisplayed();
        labelLandUse.isEnabled();
        labelGroup.isDisplayed();
        labelGroup.isEnabled();
        labelProducer.isDisplayed();
        labelProducer.isEnabled();
        labelSME.isDisplayed();
        labelSME.isEnabled();
        labelTraining.isDisplayed();
        labelTraining.isEnabled();
        return true;
    }
    public void clickOnLabelProducer(){
        click(labelProducer);
    }
}
