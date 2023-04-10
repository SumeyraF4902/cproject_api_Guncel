package Page.roleServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import resources.Token;
import static io.restassured.RestAssured.given;
public class GetRolAppId extends BaseURL {
    @Test
    public void GetAllAppRolesAPITest() {
        specification.pathParams("applicationPath", "application", "appIdPath", 2, "rolePath", "role");

        Response response = given().spec(specification).when().header("Authorization",  Token.BO_token()).
                                    get("/{applicationPath}/{appIdPath}/{rolePath}");

        response.then().assertThat().statusCode(200);
    }
    @Test
    public void GetAllRolesAPITest() {
        specification.pathParams("rolePath", "role");

        Response response = given().spec(specification).when().header("Authorization",  Token.BO_token()).
                get("/{rolePath}");

        response.then().assertThat().statusCode(200);
    }
    @Test
    public void GetRoleByIdAPITest() {
        specification.pathParams("rolePath", "role", "idPath", 1);

        Response response = given().spec(specification).when().header("Authorization",  Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response.then().assertThat().statusCode(200);
    }
    @Test
    public void GetAllAppRolesNegativeAPITest() {
        specification.pathParams("applicationPath", "application", "appIdPath", 12345, "rolePath", "role");

        Response response = given().spec(specification).when().header("Authorization",  Token.BO_token()).
                get("/{applicationPath}/{appIdPath}/{rolePath}");

        response.then().assertThat().statusCode(404);
    }
    @Test
    public void GetRoleByIdNegativeAPITest() {
        specification.pathParams("rolePath", "role", "idPath", 12345);

        Response response = given().spec(specification).when().header("Authorization",  Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response.then().assertThat().statusCode(404);
    }
}
