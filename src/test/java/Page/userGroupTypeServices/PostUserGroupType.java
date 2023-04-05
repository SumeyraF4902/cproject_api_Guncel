package Page.userGroupTypeServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import resources.Token;

import static io.restassured.RestAssured.given;

public class PostUserGroupType extends BaseURL {
    @Test
    public void GetAllUserGroupTypeAPITest() {
        specification.pathParams("userGroupTypePath", "user-group-type");
        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).
                get("/{userGroupTypePath}");

        response.then().assertThat().statusCode(201);
    }

}
