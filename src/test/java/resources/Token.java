package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ConfigReader;
import utilities.configReusable;

public class Token {

    public static String BO_token() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions().setHeadless(true);//setHeadles methodu ghost mode açıyor :)
        options.addArguments("--remote-allow-origins=*", "--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-gm3.quaspareparts.com/oauth2/authorization/a3m-client");
        // Load username and password from config file
        LoginPage loginPage = new LoginPage(driver);
        String username = ConfigReader.getProperty("bo_username");
        String password = ConfigReader.getProperty("bo_password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        driver.get(ConfigReader.getProperty("token_url"));
        configReusable configReusable = new configReusable(driver);
        configReusable.waitForPageLoad();
        String token = configReusable.getAccessToken();
        driver.quit();
        return "Bearer " + token;
    }


    public static String cstmr_token() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions().setHeadless(true);
        options.addArguments("--remote-allow-origins=*", "--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-gm3.quaspareparts.com/oauth2/authorization/a3m-client");
        //Load username and password from config file
        LoginPage loginPage = new LoginPage(driver);
        String username = ConfigReader.getProperty("ctm_username");
        String password = ConfigReader.getProperty("ctm_password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        driver.get(ConfigReader.getProperty("token_url"));
        configReusable configReusable = new configReusable(driver);
        configReusable.waitForPageLoad();
        String token = configReusable.getAccessToken();
        driver.quit();
        return "Bearer " + token;
    }

}