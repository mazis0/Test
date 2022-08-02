package com.qa.stepdef.onboarding;

import com.qa.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.onboarding.GreatingPage;
import pages.onboarding.HomeKoltivaPage;
import pages.onboarding.StartingPage;

import java.io.IOException;

public class OnboardingStep {
    private AndroidDriver<AndroidElement> driver;

    public OnboardingStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }
    @Given("User is on Greating Page")
    public void user_is_on_greating_page() {
        GreatingPage greatingPage = new GreatingPage(driver);
        Assert.assertTrue(greatingPage.isUserIsOnGreatingPage());
    }
    @Given("Click on right arrow button")
    public void click_on_right_arrow_button() {
        GreatingPage greatingPage = new GreatingPage(driver);
        greatingPage.clickOnArrowButton();
    }
    @Given("User is On Software Description Page")
    public void user_is_on_software_description_page() {
        StartingPage startingPage = new StartingPage(driver);
        Assert.assertTrue(startingPage.isUserOnStartingPage());
    }
    @Given("Click on GET STARTED button")
    public void click_on_get_started_button() {
        StartingPage startingPage = new StartingPage(driver);
        startingPage.clickOnGetStartedButton();
    }
    @Given("User is On Home Page")
    public void user_is_on_home_page() {
        HomeKoltivaPage homeKoltivaPage = new HomeKoltivaPage(driver);
        Assert.assertTrue(homeKoltivaPage.isUserOnHomePage());
    }
    @Given("Click On Masuk button")
    public void click_on_masuk_button() {
        HomeKoltivaPage homeKoltivaPage = new HomeKoltivaPage(driver);
        homeKoltivaPage.clickLoginButton();
    }
}
