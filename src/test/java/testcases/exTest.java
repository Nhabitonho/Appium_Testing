package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static pages.BaseSetup.driver;

public class exTest extends BaseTest{
    @Test
    public void exTesting(){
        System.out.println("test");
        driver.findElement(By.id("com.android.dialer:id/contacts_tab")).click();
        driver.findElement(By.id("com.android.dialer:id/contact_name")).click();
        driver.findElement(By.xpath("//*[@text='First name']")).sendKeys("E");
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@text='Phone']")).sendKeys("12345");
        driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();
        driver.navigate().back();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
//        String toastMess = driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
//        System.out.println(toastMess);

        System.out.println("Create contacts successfully");
    }
}
