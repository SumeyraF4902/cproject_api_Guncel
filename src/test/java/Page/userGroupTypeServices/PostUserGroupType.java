package Page.userGroupTypeServices;

import BaseUrl.BaseURL;
import PojoDatas.UserGroupType;
import io.restassured.response.Response;
import org.junit.Test;
import resources.Token;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class PostUserGroupType extends BaseURL {
    @Test
    public void PostUserGroupTypeAPITest() {
        specification.pathParams("userGroupTypePath", "user-group-type");
        UserGroupType reqBody = new UserGroupType("Rahat Unit", "Boş Beleşler");

        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).body(reqBody).
                post("/{userGroupTypePath}");
        response.then().assertThat().statusCode(201);
        UserGroupType actualData = response.as(UserGroupType.class);
        assertEquals(reqBody.getName(),actualData.getName());
        assertEquals(reqBody.getDescription(),actualData.getDescription());
    }
    @Test
    public void PostUserGroupTypeNegativeAPITest() {
        specification.pathParams("userGroupTypePath", "user-group-type");
        UserGroupType reqBody = new UserGroupType(" ", "+%&");

        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).body(reqBody).
                post("/{userGroupTypePath}");
        response.then().assertThat().statusCode(400);
    }
}
