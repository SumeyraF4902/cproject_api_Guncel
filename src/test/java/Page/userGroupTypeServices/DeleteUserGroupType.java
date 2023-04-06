package Page.userGroupTypeServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import resources.Token;
import static io.restassured.RestAssured.given;
public class DeleteUserGroupType extends BaseURL {
    @Test
    public void GetUserGroupTypeByIdAPITest() {
        specification.pathParams("userGroupTypePath", "user-group-type", "idPath",
                                            PostUserGroupType.rahatUnıtId);
        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).
                delete("/{userGroupTypePath}/{idPath}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
