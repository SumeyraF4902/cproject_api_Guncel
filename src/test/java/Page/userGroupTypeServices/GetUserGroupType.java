package Page.userGroupTypeServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import resources.Token;
import static io.restassured.RestAssured.given;
public class GetUserGroupType extends BaseURL {
    @Test
    public void GetAllUserGroupTypeAPITest() {
        specification.pathParams("userGroupTypePath", "user-group-type");

        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).
                get("/{userGroupTypePath}");
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void GetUserGroupTypeByIdAPITest() {
        specification.pathParams("userGroupTypePath", "user-group-type", "idPath", "3");

        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).
                get("/{userGroupTypePath}/{idPath}");
        response.then().assertThat().statusCode(200).body("id", Matchers.hasItem(3));
    }
    @Test
    public void GetUserGroupTypeByIdAPINegativeTest() {
        specification.pathParams("userGroupTypePath", "user-group-type", "idPath", "12345");

        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).
                get("/{userGroupTypePath}/{idPath}");
        response.then().assertThat().statusCode(404);
    }
}