package Page.userServices;

import PojoDatas.User;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class NegatifTestCases  {

    static RequestSpecification specification;
    static int userId;
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


    @Test(description = "[POST-406]/auth/api/organization/{organizationId}/application/{appId}/role/{roleId}/user")
    public void inviteNewUser() {

        System.out.println("test calisti");
        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();
        requestBody.setDefault_role_id(99);

        Response response = User.inviteNewUser(requestBody);
        assertNotEquals(response.statusCode(),201);
        System.out.println(response.getStatusCode());
    }

    @Test(description = "[POST-406]/auth/api/organization/{organizationId}/application/{appId}/role/{roleId}/user")
    public void inviteNewUser2() {

        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();
        String email = User.getAllUsers().jsonPath().getList("email").get(0).toString();
        requestBody.setEmail(email);

        Response response = User.inviteNewUser(requestBody);
        assertNotEquals(response.statusCode(),201);
    }

    @Test(description = "[GET-401]/auth/api/organization/{organizationId}/user")
    public void getAllUsersOfOrganization(){
        int invalidOrganizationId = 2;
        Response response = User.getAllUsersOfOrganization(invalidOrganizationId);
        assertEquals(response.getStatusCode(), 401);

    }

    @Test(description = "[PUT-404]/auth/api/user")
    public void updateExistingUser(){

        int userId = 9999;
        User.UpdateUser requestBody = new User.UpdateUser(userId);

        Response response = User.updateUser(requestBody);
        assertEquals(response.getStatusCode(),404, "sistemde olmayan kullanici update edilebilmektedir");

    }

    @Test(description = "[PUT-406]/auth/api/user")
    public void updateExistingUser2(){

        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);
        User.UpdateUser requestBody = new User.UpdateUser(userId);
        requestBody.setUsername("   ");

        Response response = User.updateUser(requestBody);
        assertEquals(response.getStatusCode(),406, "Username sadece bosluk kabul edebilmektedir" );
        response.then().statusCode(406);

    }
    @Test(description = "[PUT-406]/auth/api/user")
    public void updateExistingUser3(){

        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);
        User.UpdateUser requestBody = new User.UpdateUser(userId);
        requestBody.setUsername("34");

        Response response = User.updateUser(requestBody);
        assertEquals(response.getStatusCode(),406,"Username sadece rakam kabul edebilmektedir");
        response.prettyPrint();
        response.then().statusCode(406);

    }

    @Test(description = "[PUT-406]/auth/api/user")
    public void updateExistingUser4(){

        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);
        User.UpdateUser requestBody = new User.UpdateUser(userId);
        requestBody.setUsername("!§$");

        Response response = User.updateUser(requestBody);
        assertEquals(response.getStatusCode(),406,"Username sadece Özel karakter kabul etmektedir");

    }


    @Test(description = "[GET-404]/auth/api/user/{id}")
    public void getUserById(){

        userId = 9999;
        Response response = User.getUserById(userId);
        assertEquals(response.getStatusCode(),404,"Sistemde olmayan kullanici");

    }



    @Test(description = "[DELETE-404]/auth/api/user/{id}")
    public void deleteExistingUserById(){

        userId = 9999;
        Response response = User.getUserById(userId);
        assertEquals(response.getStatusCode(),404,"Sistemde olmayan kullanici");

    }



    @Test(description = "[POST-400]/auth/api/user/cherry-pick?content=fullTree")
    public void cherryPickUsers4(){

        RequestSpecification specification1 = specification;

        specification.queryParam("content", "fullTree");

        Response response = given()
                .spec(specification)
                .when()
                .body(-5)
                .post("/user/cherry-pick");
        response.prettyPrint();
        assertTrue(response.asString().contains("email"));
        assertTrue(response.asString().contains("user_groups"));

        specification = specification1;

    }










}
