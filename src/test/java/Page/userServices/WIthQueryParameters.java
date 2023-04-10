package Page.userServices;

import BaseUrl.BaseURL;
import PojoDatas.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WIthQueryParameters extends BaseURL {

    static RequestSpecification specification;
    static String token;



    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions().setHeadless(true);
        opt.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://qa-gm3.quaspareparts.com/oauth2/authorization/a3m-client");
        driver.findElement(By.id("username")).sendKeys("bo@testevolve.com");
        driver.findElement(By.id("password")).sendKeys("y5HWgTQnMG733cy");
        driver.findElement(By.tagName("button")).click();
        driver.navigate().to("https://qa-gm3.quaspareparts.com/auth/userinfo");
        JsonPath path = new JsonPath(driver.findElement(By.tagName("body")).getText());
        token = "Bearer " + path.getString("access_token");
        driver.quit();

        specification = new RequestSpecBuilder()
                .setBaseUri("https://a3m-qa-gm3.quaspareparts.com/auth/api")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", token)
                .build();
    }


    @Test(description = "[POST]/auth/api/user/cherry-pick?content=slim")
    public void cherryPickUsers(){

        RequestSpecification specification1 = specification;
        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");

        int[] requestBody = new int[1];
        requestBody[0] = ids.get(new Random().nextInt(ids.size()-1));
        specification.queryParam("content", "slim");

        Response response = given()
                .spec(specification)
                .when()
                .body(requestBody)
                .post("/user/cherry-pick");
        response.prettyPrint();
        assertFalse(response.asString().contains("email"));
        specification = specification1;

    }

    @Test(description = "[POST]/auth/api/user/cherry-pick?content=full")
    public void cherryPickUsers2(){

        RequestSpecification specification1 = specification;
        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");

        int[] requestBody = new int[1];
        requestBody[0] = ids.get(new Random().nextInt(ids.size()-1));
        specification.queryParam("content", "full");

        Response response = given()
                .spec(specification)
                .when()
                .body(requestBody)
                .post("/user/cherry-pick");
        response.prettyPrint();
        assertFalse(response.asString().contains("email"));
        assertFalse(response.asString().contains("user_groups"));

        specification = specification1;

    }

    @Test(description = "[POST]/auth/api/user/cherry-pick?content=fullTree")
    public void cherryPickUsers3(){

        RequestSpecification specification1 = specification;
        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");

        int[] requestBody = new int[1];
        requestBody[0] = ids.get(new Random().nextInt(ids.size()-1));
        specification.queryParam("content", "fullTree");

        Response response = given()
                .spec(specification)
                .when()
                .body(requestBody)
                .post("/user/cherry-pick");
        response.prettyPrint();
        assertTrue(response.asString().contains("email"));
        assertTrue(response.asString().contains("user_groups"));

        specification = specification1;

    }
}
