package Page.userServices;

import BaseUrl.BaseURL;
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
import resources.Token;

import java.util.List;


public class NegatifTestCases  extends BaseURL {

    static int userId;

    @Test(description = "[POST-406]/auth/api/organization/{organizationId}/application/{appId}/role/{roleId}/user")
    public void inviteNewUser() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();
        requestBody.setDefault_role_id(99);

        Response response = User.inviteNewUser(requestBody, specification);
        assertNotEquals(response.statusCode(),201);
    }

    @Test(description = "[POST-406]/auth/api/organization/{organizationId}/application/{appId}/role/{roleId}/user")
    public void inviteNewUser2() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();
        String email = User.getAllUsers(specification).jsonPath().getList("email").get(0).toString();
        requestBody.setEmail(email);

        Response response = User.inviteNewUser(requestBody, specification);
        assertNotEquals(response.statusCode(),201);
    }

    @Test(description = "[GET-401]/auth/api/organization/{organizationId}/user")
    public void getAllUsersOfOrganization(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        int invalidOrganizationId = 2;
        Response response = User.getAllUsersOfOrganization(invalidOrganizationId, specification);
        assertEquals(response.getStatusCode(), 401);

    }

    @Test(description = "[PUT-404]/auth/api/user")
    public void updateExistingUser(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        int userId = 9999;
        User.UpdateUser requestBody = new User.UpdateUser(userId);

        Response response = User.updateUser(requestBody, specification);
        assertEquals(response.getStatusCode(),404, "sistemde olmayan kullanici update edilebilmektedir");

    }

    @Test(description = "[PUT-406]/auth/api/user")
    public void updateExistingUser2(){

        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);
        User.UpdateUser requestBody = new User.UpdateUser(userId);
        requestBody.setUsername("   ");

        Response response = User.updateUser(requestBody, specification);
        assertEquals(response.getStatusCode(),406, "Username sadece bosluk kabul edebilmektedir" );
        response.then().statusCode(406);

    }
    @Test(description = "[PUT-406]/auth/api/user")
    public void updateExistingUser3(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);
        User.UpdateUser requestBody = new User.UpdateUser(userId);
        requestBody.setUsername("34");

        Response response = User.updateUser(requestBody, specification);
        assertEquals(response.getStatusCode(),406,"Username sadece rakam kabul edebilmektedir");
        response.then().statusCode(406);

    }

    @Test(description = "[PUT-406]/auth/api/user")
    public void updateExistingUser4(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);
        User.UpdateUser requestBody = new User.UpdateUser(userId);
        requestBody.setUsername("!§$");

        Response response = User.updateUser(requestBody, specification);
        assertEquals(response.getStatusCode(),406,"Username sadece Özel karakter kabul etmektedir");

    }


    @Test(description = "[GET-404]/auth/api/user/{id}")
    public void getUserById(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());
        userId = 9999;
        Response response = User.getUserById(userId, specification);
        assertEquals(response.getStatusCode(),404,"Sistemde olmayan kullanici");

    }



    @Test(description = "[DELETE-404]/auth/api/user/{id}")
    public void deleteExistingUserById(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());
        userId = 9999;
        Response response = User.getUserById(userId, specification);
        assertEquals(response.getStatusCode(),404,"Sistemde olmayan kullanici");

    }



    @Test(description = "[POST-400]/auth/api/user/cherry-pick?content=fullTree")
    public void cherryPickUsers4(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token())
                .queryParam("content", "fullTree");

        Response response = given()
                .spec(specification)
                .when()
                .body(-5)
                .post("/user/cherry-pick");
        assertTrue(response.asString().contains("email"));
        assertTrue(response.asString().contains("user_groups"));


    }










}
