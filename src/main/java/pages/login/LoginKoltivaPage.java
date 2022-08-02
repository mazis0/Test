package pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class LoginKoltivaPage extends BasePage {


    @AndroidFindBy(id = "com.koltiva.koltitrace:id/edittext_username")
    private MobileElement username;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/edittext_password")
    private MobileElement password;

    @AndroidFindBy(id = "com.koltiva.koltitrace:id/btn_login_bottom")
    private MobileElement continueButton;

    public LoginKoltivaPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void setUsername(String usernamed) {

      //  username.sendKeys(usernamed);
        sendKeys(username,usernamed);
    }

    public void setPassword(String passworded) {

        sendKeys(password,passworded);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void login(String username,String password) {
        setUsername(username);
        setPassword(password);
    }

    public boolean isUserOnLoginPage(){
        username.isDisplayed();
        password.isDisplayed();
        return true;
    }
}
