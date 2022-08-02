package com.qa.stepdef.producer;

import com.qa.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.dashboard.DashboardPage;
import pages.producer.ProducerPage;

import java.io.IOException;

public class ProducerStep {

    private AndroidDriver<AndroidElement> driver;

    public ProducerStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }
    @Then("Click on label Producer")
    public void click_on_label_producer() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnLabelProducer();
    }
    @Given("User is on Producer Page")
    public void user_is_on_producer_page() throws IOException{
        ProducerPage producerPage = new ProducerPage(driver);
        Assert.assertTrue(producerPage.isUserOnProducerPage());
    }
    @Given("Click on Add button")
    public void click_on_add_button() throws IOException{
        ProducerPage producerPage = new ProducerPage(driver);
        producerPage.clickOnButtonAdd();
    }
    @Given("User is on Producer General Data Page")
    public void userIsOnProducerGeneralDataPage()throws IOException{
        ProducerPage producerPage = new ProducerPage(driver);
        producerPage.isUserOnProducerGeneralDataPage();
    }
    @Given("Scroll down until element Producers Blood Type")
    public void scrollUntilElement() throws Exception {
        ProducerPage producerPage = new ProducerPage(driver);
        producerPage.checkElement();
    }

}
