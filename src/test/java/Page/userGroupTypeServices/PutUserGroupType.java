package Page.userGroupTypeServices;

import BaseUrl.BaseURL;
import PojoDatas.UserGroupType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import resources.Token;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
public class PutUserGroupType extends BaseURL {
    @Test
    public void PutUserGroupTypeAPITest() {
        specification.pathParams("userGroupTypePath", "user-group-type");
        UserGroupType reqBody = new UserGroupType(PostUserGroupType.rahatUnıtId, " ", "+%&");

        Response response = given().spec(specification).contentType(ContentType.JSON).when().
                header("Authorization",  Token.BO_token()).body(reqBody).
                put("/{userGroupTypePath}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        UserGroupType actualData = response.as(UserGroupType.class);
        assertEquals(reqBody.getId(), actualData.getId());
        assertEquals(reqBody.getName(),actualData.getName());
        assertEquals(reqBody.getDescription(),actualData.getDescription());
    }
    @Test
    public void PutUserGroupTypeNegativeAPITest() {
        specification.pathParams("userGroupTypePath", "user-group-type");
        UserGroupType reqBody = new UserGroupType(12345, "Yokluk:(", "Hiçlik:)");

        Response response = given().spec(specification).contentType(ContentType.JSON).
                header("Authorization",  Token.BO_token()).body(reqBody).
                when().put("/{userGroupTypePath}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(404);
    }
}

