package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage  extends BasePage {
    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("access_toke n")));
    }

    public String getAccessToken() {
        return driver.findElement(By.id("access_token")).getText();
    }// ...
}
