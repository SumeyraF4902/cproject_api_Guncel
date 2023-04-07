package Page.roleServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import resources.Token;

import static io.restassured.RestAssured.given;

public class GetRolAppId extends BaseURL {
    @Test
    public void Test1() {
        specification.pathParams("applicationPath", "application", "appIdPath", 2, "rolePath", "role");
        Response response = given().spec(specification).
                when().
                header("Authorization",  Token.BO_token()).
                get("/{applicationPath}/{appIdPath}/{rolePath}");
        response.then().

                assertThat().

                statusCode(200);
    }
}
