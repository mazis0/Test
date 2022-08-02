package com.qa.stepdef.login;

import com.qa.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.dashboard.DashboardPage;
import pages.login.DownloadResourcePage;
import pages.login.LoginKoltivaPage;
import pages.onboarding.GreatingPage;
import pages.onboarding.HomeKoltivaPage;
import pages.onboarding.StartingPage;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class LoginStep {

    private Properties props = new PropertyManager().getPropsProduction();

    private AndroidDriver<AndroidElement> driver;

    public LoginStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }
    @Given("Input valid username and password")
    public void input_valid_username_and_password() {
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        loginKoltivaPage.login(props.getProperty("data.login.username"),props.getProperty("data.login.password"));
    }
    @Given("User is on Login Page")
    public void user_is_on_login_page()  {
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        Assert.assertTrue(loginKoltivaPage.isUserOnLoginPage());
    }
    @When("User click On Continue Button")
    public void user_is_click_on_continue_button() {
        LoginKoltivaPage loginKoltivaPage = new LoginKoltivaPage(driver);
        loginKoltivaPage.clickContinueButton();
    }
    @Then("Wait Until download data is completed")
    public void verify_that_download_data_is_completed() throws InterruptedException{
        DownloadResourcePage downloadResourcePage = new DownloadResourcePage(driver);
        String expectedResult1 = "Download data done";
        String expectedResult2 = "100";
        Assert.assertEquals(expectedResult1,downloadResourcePage.getTextDownloadDataDone());
        Assert.assertEquals(expectedResult2,downloadResourcePage.getTextDownlaodPercentage());
    }
    @When("User click on closed button")
    public void user_click_on_closed_button() {
        DownloadResourcePage downloadResourcePage = new DownloadResourcePage(driver);
        downloadResourcePage.clickOnCloseButton();
    }

    @Then("Verify that user is on Dashboard Page")
    public void verify_that_user_is_on_dashboard_page() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isUserOnDashboardPage());
    }


}
