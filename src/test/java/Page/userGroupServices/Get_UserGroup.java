package Page.userGroupServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import resources.Token;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;


public class Get_UserGroup extends BaseURL {

    @Test
    public void TC001(){
        specification.pathParam("getUserGroupPath","user-group");
        Response response=given().spec(specification).when().header("Authorization", Token.BO_token()).get("/{getUserGroupPath}");
        response.then().assertThat().statusCode(200).body("name", hasItem("test1S-Teams"));

    }

    @Test
    public void TC002(){
        specification.pathParams("getUserGroupPath","user-group","idPath","15");
        Response response=given().spec(specification).when().header("Authorization", Token.BO_token()).get("/{getUserGroupPath}/{idPath}");
       response.then().assertThat().statusCode(200).body("id",equalTo(15));

    }

    @Test
    public void TC_009(){
        specification.pathParam("getUserGroupPath","user-group");
        Response response=given().spec(specification).when().header("Authorization", Token.cstmr_token()).get("/{getUserGroupPath}");
        response.then().assertThat().statusCode(401);

    }

}
