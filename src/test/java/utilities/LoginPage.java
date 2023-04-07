package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Protect_to_driver {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
