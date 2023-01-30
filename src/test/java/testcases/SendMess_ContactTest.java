package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SendMess_ContactPage;

import static pages.BaseSetup.helper;

public class SendMess_ContactTest extends BaseTest{
    SendMess_ContactPage sendMess_contactPage;
    @BeforeClass
    public void navigateToPage(){
        sendMess_contactPage = homePage.navigateToMessTab();
    }

    @Test(priority = 1)
    public void sendMessContact(){
        sendMess_contactPage.sendMess("Hello", helper.message);
    }
}
