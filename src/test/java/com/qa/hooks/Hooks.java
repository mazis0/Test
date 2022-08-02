package com.qa.hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.AppiumServer;
import utils.DeviceApi;
import utils.PropertyManager;
import utils.STFService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Hooks {
 //   private static final String STF_SERVICE_URL = ;
// public static AndroidDriver<AndroidElement> driver;
// private final DesiredCapabilities caps = new DesiredCapabilities();
//
//    @Before
//    public void setupDeviceCapabilities() throws MalformedURLException {
//        caps.setCapability("deviceName", "Samsung");
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "9");
//        caps.setCapability("udid","emulator-5554");
//        caps.setCapability("app", new File(System.getProperty("user.dir")
//                + "/src/test/resources/apk/apk-production/app-koltitrace-release.apk").getAbsolutePath());
//        caps.setCapability("appPackage", "com.koltiva.koltitrace");
//        caps.setCapability("appActivity", "com.koltiva.farmxtension.ui.main.MainActivity2");
//        caps.setCapability("autoGrantPermissions",true);
//        caps.setCapability("noReset", false);
//        caps.setCapability("fullReset", false);
//
//        try {
//            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        driver.manage().timeouts().implicitlyWait(10, SECONDS);
//    }

    private static Properties props;

    static {
        try {
            props = new PropertyManager().getPropsProduction();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String STF_SERVICE_URL = props.getProperty("device-farmer-serviceurl");  // Change this URL
    private static final String ACCESS_TOKEN = props.getProperty("device-farmer-accesstoken"); // Change this access token

    public static AndroidDriver<AndroidElement> driver;
    private String deviceSerial;
    private DeviceApi deviceApi;


  //  private AppiumServer appiumServer = new AppiumServer();


    @Before
    public void setup() throws IOException, URISyntaxException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        desiredCapabilities.setCapability("app", new File(System.getProperty("user.dir")
                + "/src/test/resources/apk/apk-production/app-koltitrace-release.apk").getAbsolutePath());
        desiredCapabilities.setCapability("appPackage", "com.koltiva.koltitrace");
        desiredCapabilities.setCapability("appActivity", "com.koltiva.farmxtension.ui.main.MainActivity2");

        desiredCapabilities.setCapability("autoGrantPermissions",true);
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("fullReset", false);

        STFService stfService = new STFService(STF_SERVICE_URL, ACCESS_TOKEN);
        deviceApi = new DeviceApi(stfService);
        deviceApi.connectDevice("emulator-5554");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void stopAndroidDriver() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
