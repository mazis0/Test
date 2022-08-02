package pages.producer;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class ProducerPage extends BasePage {
    private Properties props = new PropertyManager().getPropsProduction();
    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_add_quesioner")
    private MobileElement buttonAddProducer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"List Producer\"]")
    private MobileElement titleListProducer;

    @AndroidFindBy(id="com.koltiva.koltitrace:id/lbl_add_quesioner")
    private MobileElement labelCreateProducer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Producer\"]")
    private MobileElement titleProducer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"General Data\"]")
    private MobileElement labelGeneralData;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Producer Organization\"]")
    private MobileElement labelProducerOrganization;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Farm Information\"]")
    private MobileElement labelFarmInformation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Bank Information\"]")
    private MobileElement labelBankInformation;

    @AndroidFindBy(xpath = "//*[@text=\"Producer's blood type\"]")
    private MobileElement labelProducersBloodType;

    @AndroidFindBy(xpath = "(//*[@text=\"Producer's blood type\"]/parent::*/parent::*/parent::*/child::*)[2]/child::*/child::*")
    private MobileElement textLabelProducersBloodType;
    public ProducerPage(AndroidDriver<AndroidElement> driver) throws IOException {
        super(driver);
    }

    public boolean isUserOnProducerPage(){
        waitForVisibility(titleListProducer);
        titleListProducer.isDisplayed();
        buttonAddProducer.isDisplayed();
        buttonAddProducer.isEnabled();
        labelCreateProducer.isDisplayed();
        return true;
    }
    public void clickOnButtonAdd(){
        click(buttonAddProducer);
    }

    public boolean isUserOnProducerGeneralDataPage(){
        waitForVisibility(titleProducer);
        titleProducer.isDisplayed();
        labelGeneralData.isDisplayed();
        labelGeneralData.isEnabled();
        labelProducerOrganization.isDisplayed();
        labelProducerOrganization.isEnabled();
        labelFarmInformation.isDisplayed();
        labelFarmInformation.isEnabled();
    //    labelBankInformation.isDisplayed();
   //     labelBankInformation.isEnabled();
        return true;
    }

    public void checkElement() throws Exception {
 //       scrollToElement(labelProducersBloodType,"up");
 //       andScrollToElementUsingUiScrollable("text","Personal Data");
        Thread.sleep(2000);
        andScrollToElementUsingUiScrollable("text","Age");
        sendKeys(textLabelProducersBloodType,props.getProperty("data.producer.addnewproducer.generaldata.producersbloodtype"));
    }


}
