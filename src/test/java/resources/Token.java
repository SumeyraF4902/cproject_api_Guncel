package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Token {

    public static String BO_token() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--url=https://a3m-qa-gm3.quaspareparts.com/login","--start-maximized");
        WebDriver driver = new ChromeDriver(options);
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
        return token;
    }

    public static String cstmr_token() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--url=https://a3m-qa-gm3.quaspareparts.com/login","--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //Load username and password from config file
        LoginPage loginPage = new LoginPage(driver);
        String username = ConfigReader.getProperty("cstmr_username");
        String password = ConfigReader.getProperty("cstmr_password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        driver.get(ConfigReader.getProperty("token_url"));
        configReusable configReusable = new configReusable(driver);
        configReusable.waitForPageLoad();
        String token = configReusable.getAccessToken();
        driver.quit();
        return token;
    }

    public static String test1_token() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--url=https://a3m-qa-gm3.quaspareparts.com/login","--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        // Load username and password from config file
        LoginPage loginPage = new LoginPage(driver);
        String username = ConfigReader.getProperty("default_username");
        String password = ConfigReader.getProperty("default_password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        driver.get(ConfigReader.getProperty("token_url"));
        configReusable configReusable = new configReusable(driver);
        configReusable.waitForPageLoad();
        String token = configReusable.getAccessToken();
        driver.quit();
        return token;
    }
}