package testcases;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import pages.BaseSetup;
import pages.HomePage;

import java.net.MalformedURLException;

import static pages.BaseSetup.driver;

public class BaseTest {
    public static BaseSetup setup;
    public static HomePage homePage;


    public AndroidDriver getDriver(){
        return driver;
    }

    @Parameters({"port"})
    @BeforeSuite
    public void beforeSuite(@Optional("4723") int port) throws InterruptedException {
        setup = new BaseSetup();
        setup.startAppiumServer(port);
    }
    @Parameters({"device-url", "device-Name", "udid", "device-Version"})
    @BeforeTest
    public void initTest(@Optional("http://127.0.0.1:4723/wd/hub") String fullUrl, @Optional("sdk_gphone64_x86") String deviceName,@Optional("emulator-5554") String udid,@Optional("11") String version) throws MalformedURLException {
        setup.setupDriver(fullUrl, deviceName, udid, version);
        homePage = setup.navigateToHomePage();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        setup.tearDownDriver();
    }
    @AfterSuite
    public void afterSuite(){
        setup.stopAppiumServer();
    }
}
