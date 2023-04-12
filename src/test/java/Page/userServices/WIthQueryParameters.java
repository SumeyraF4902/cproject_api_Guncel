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
import resources.Token;

import java.util.List;
import java.util.Random;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WIthQueryParameters extends BaseURL {

    @Test(description = "[POST]/auth/api/user/cherry-pick?content=slim")
    public void cherryPickUsers(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());
        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");

        int[] requestBody = new int[1];
        requestBody[0] = ids.get(new Random().nextInt(ids.size()-1));
        specification.queryParam("content", "slim");

        Response response = given()
                .spec(specification)
                .when()
                .body(requestBody)
                .post("/user/cherry-pick");
        assertFalse(response.asString().contains("email"));

    }

    @Test(description = "[POST]/auth/api/user/cherry-pick?content=full")
    public void cherryPickUsers2(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());
        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");

        int[] requestBody = new int[1];
        requestBody[0] = ids.get(new Random().nextInt(ids.size()-1));
        specification.queryParam("content", "full");

        Response response = given()
                .spec(specification)
                .when()
                .body(requestBody)
                .post("/user/cherry-pick");
        assertTrue(response.asString().contains("email"));
        assertFalse(response.asString().contains("user_groups"));


    }

    @Test(description = "[POST]/auth/api/user/cherry-pick?content=fullTree")
    public void cherryPickUsers3(){
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());
        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");

        int[] requestBody = new int[1];
        requestBody[0] = ids.get(new Random().nextInt(ids.size()-1));
        specification.queryParam("content", "fullTree");

        Response response = given()
                .spec(specification)
                .when()
                .body(requestBody)
                .post("/user/cherry-pick");
        assertTrue(response.asString().contains("email"));
        assertTrue(response.asString().contains("user_groups"));


    }
}
