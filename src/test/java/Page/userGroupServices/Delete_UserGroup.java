package Page.userGroupServices;

import BaseUrl.BaseURL;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import resources.Token;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertFalse;

public class Delete_UserGroup extends BaseURL {

    @Test
    public void TC_005() {

        specification.pathParam("getUserGroupPath", "user-group");
        Response response = given().spec(specification).when().header("Authorization", Token.BO_token()).get("/{getUserGroupPath}");
        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> userGroups = jsonPath.getList("");
        int otoID = 0;
        for (Map<String, Object> userGroup : userGroups) {

            if (userGroup.get("name").toString().contains("Team1s")) {
                System.out.println(userGroup);
                otoID = (Integer) userGroup.get("id");
                System.out.println(otoID);
                break;
            }
        }
        int deleteId=otoID;
      specification.pathParam("idPath", deleteId);
      System.out.println(deleteId);
   Response responseDel = given().spec(specification).when().header("Authorization", Token.BO_token()).contentType(ContentType.JSON).delete("/{getUserGroupPath}/{idPath}");
    responseDel.then().assertThat().statusCode(200);
   Response responseGet = given().spec(specification).when()
           .contentType(ContentType.JSON)
           .header("Authorization", Token.BO_token())
           .get("/{getUserGroupPath}/{idPath}");
   responseGet.then().assertThat().statusCode(404);


    }


    @Test
    public void TC_007() {




        specification.pathParam("orgPath", "organization")
                .pathParam("orgId", 181)
                .pathParam("userPath1", "user-group")
                .pathParam("userGroupId", 99)
                .pathParam("userPath2", "user")
                .pathParam("userId", 351);


        Response response = given().spec(specification).header("Authorization", Token.BO_token())
                .contentType(ContentType.JSON)
                .when()
                .delete("/{orgPath}/{orgId}/{userPath1}/{userGroupId}/{userPath2}/{userId}");
        response.then().assertThat().statusCode(200);
        RequestSpecification
                specificationnew = new RequestSpecBuilder().
                setBaseUri("https://a3m-qa-gm3.quaspareparts.com/auth/api").
                build();

        specificationnew.pathParams("userPath1", "user-group", "userGroupId", 99);




    }

}