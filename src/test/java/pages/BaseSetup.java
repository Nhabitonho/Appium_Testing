package pages;

//import driverManager.AndroidDriverManager;
import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import untils.Helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class BaseSetup {
    public static AndroidDriver driver;
    public static Helper helper;
    public static WebDriverWait wait;
    static String Appium_Node_Path = "C:\\Program Files\\nodejs\\node.exe";
    static String Appium_JS_Path = "C:\\Users\\lonbui\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
//    static String fullUrl = "http://127.0.0.1:4723/wd/hub";
    static String url = "127.0.0.1";
    static String minorUrl = "/wd/hub";
    static DesiredCapabilities cap;
    static AppiumServiceBuilder builder;
    static AppiumDriverLocalService service;


    public static AndroidDriver getDriver(){
        return driver;
    }

    public void startAppiumServer() throws InterruptedException {
        builder = new AppiumServiceBuilder();
        builder.withIPAddress(url)
                .usingPort(4723)
                .withAppiumJS(new File(Appium_JS_Path))
                .usingDriverExecutable(new File(Appium_Node_Path))
                .withArgument(BASEPATH, minorUrl)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE);
                //.withArgument (GeneralServerFlag.LOG_LEVEL, "debug");
        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public void stopAppiumServer() {
        service.stop();
    }

    public void setupDriver(String fullUrl, String deviceName, String udid, String version) throws MalformedURLException {
        helper = new Helper(driver);
        cap = new DesiredCapabilities();
        URL appiumServer = new URL(fullUrl);
        System.out.println("Launching Android device...");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        cap.setCapability(MobileCapabilityType.UDID, udid);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        //Phone
        cap.setCapability("addPackage", "com.android.contacts.common.dialog");
        cap.setCapability("addActivity", ".CallSubjectDialog");

        driver = (new AndroidDriver(appiumServer, cap));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public HomePage navigateToHomePage(){
        return new HomePage();
        }
    public void tearDownDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    public String verifyToastMessDisplay(){
        return helper.getMessToast();
    }
}
