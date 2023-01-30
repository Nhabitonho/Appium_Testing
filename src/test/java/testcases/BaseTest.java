package testcases;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.BaseSetup;
import pages.HomePage;
import untils.Helper;

import java.net.MalformedURLException;

import static pages.BaseSetup.driver;

public class BaseTest {
    public static BaseSetup setup;
    public static HomePage homePage;


    public AndroidDriver getDriver(){
        return driver;
    }


    @BeforeSuite
    public void beforeSuite() throws InterruptedException {
        setup = new BaseSetup();
        setup.startAppiumServer();
    }

    @BeforeTest
    public void initTest() throws MalformedURLException {
        setup.setupDriver();
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
