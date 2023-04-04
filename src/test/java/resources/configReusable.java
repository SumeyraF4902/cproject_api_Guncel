package resources;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class configReusable extends Protect_to_driver {
    public configReusable(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoad(String by, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if (by == "id") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        }
        if (by == "xpath") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        }
        if (by == "tagName") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
        }
        if (by == "className") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
        }
        if (by == "cssSelector") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        }
        if (by == "linkText") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
        }
        if (by == "partialLinkText") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
        }
    }

    public String getAccessToken() {
        String response = driver.findElement(By.tagName("pre")).getText();
        JSONObject jsonResponse = new JSONObject(response);
        String accessToken = jsonResponse.getString("access_token");

        return accessToken;
    }
}
