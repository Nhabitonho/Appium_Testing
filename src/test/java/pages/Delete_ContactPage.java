package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Delete_ContactPage extends BaseSetup{
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='More options']")
    public WebElement more;
    @FindBy(xpath = "//*[@text='Delete']")
    public WebElement deleteButton;

    @FindBy(id = "android:id/button1")
    public WebElement acceptButton;

    public Delete_ContactPage(){
        PageFactory.initElements(driver, this);
    }

    public void deleteContact(){
        more.click();
        deleteButton.click();
        acceptButton.click();
        System.out.println("Delete contacts successfully");
    }
}