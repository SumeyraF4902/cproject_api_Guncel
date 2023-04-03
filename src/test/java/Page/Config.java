package Page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config {

    public static String BO_token() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions().setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("<https://qa-gm3.quaspareparts.com/oauth2/authorization/a3m-client>");
        // Load username and password from config file
        LoginPage loginPage = new LoginPage(driver);
        //String username = Config.getUsername();
        //String password = Config.getPassword();
       // loginPage.enterUsername(username);
       // loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        UserPage userPage = new UserPage(driver);
        userPage.waitForPageLoad();
        String token = userPage.getAccessToken();
        driver.quit();
        return token;
    }

    public static String cstmr_token() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions().setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("<https://qa-gm3.quaspareparts.com/oauth2/authorization/a3m-client>");
        // Load username and password from config file
        LoginPage loginPage = new LoginPage(driver);
       // String username = Config.getUsername();
       // String password = Config.getPassword();
       // loginPage.enterUsername(username);
       // loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        UserPage userPage = new UserPage(driver);
        userPage.waitForPageLoad();
        String token = userPage.getAccessToken();
        driver.quit();
        return token;
    }

    public static String test1_token() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions().setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("<https://qa-gm3.quaspareparts.com/oauth2/authorization/a3m-client>");
        // Load username and password from config file
        LoginPage loginPage = new LoginPage(driver);
        //String username = Config.getUsername();
        //String password = Config.getPassword();
        //loginPage.enterUsername(username);
        //loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        UserPage userPage = new UserPage(driver);
        userPage.waitForPageLoad();
        String token = userPage.getAccessToken();
        driver.quit();
        return token;
    }
}