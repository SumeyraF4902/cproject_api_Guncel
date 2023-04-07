package utilities;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Protect_to_driver;

public class configReusable extends Protect_to_driver {
    public configReusable(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("pre")));
    }



        public String getAccessToken() {
            String response = driver.findElement(By.tagName("pre")).getText();
            JSONObject jsonResponse = new JSONObject(response);
            String accessToken = jsonResponse.getString("access_token");

            return accessToken;
        }
    }
