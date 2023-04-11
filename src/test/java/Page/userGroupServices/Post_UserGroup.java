package Page.userGroupServices;

import BaseUrl.BaseURL;

import PojoDatas.UserGroup.UserGroup;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import resources.Token;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class Post_UserGroup extends BaseURL {

@Test
    public void TC_003(){
     ArrayList<Map<String,Integer>> body=new ArrayList<>();
    Map<String, Integer> id = new HashMap<>();
    id.put("id",5);
    body.add(id);

    specification.pathParam("postUserGroupPath","user-group");

    UserGroup.body userGroupBody = new UserGroup.body("DepartmentTeam1s", 1,body);

     Response response=given().spec(specification).when()
             .contentType(ContentType.JSON)
             .header("Authorization", Token.BO_token())
            .body(userGroupBody).post("/{postUserGroupPath}");

    JsonPath jsonPath = response.jsonPath();
    String actualName = jsonPath.get("name");
    assertEquals(actualName, userGroupBody.getName());
     assertEquals(response.getStatusCode(),201);
   int autId=jsonPath.get("id");

   specification.pathParam("idPath",autId);
   Response responseGet=given().spec(specification).when()
           .contentType(ContentType.JSON)
           .header("Authorization", Token.BO_token())
       .get("/{postUserGroupPath}/{idPath}");
   responseGet.then().assertThat().statusCode(200);

}    @Test
    public void TC_006(){


specification.pathParam("orgPath", "organization")
                .pathParam("orgId", 181)
                .pathParam("userPath1", "user-group")
                .pathParam("userGroupId", 99)
                .pathParam("userPath2", "user")
                .pathParam("userId", 351);

 Response response=given().spec(specification).header("Authorization", Token.BO_token())
                .contentType(ContentType.JSON)
                .when()
                .post("/{orgPath}/{orgId}/{userPath1}/{userGroupId}/{userPath2}/{userId}");
    response.then().assertThat().statusCode(201);


    }



    @Test
    public void TC_008(){
        ArrayList<Map<String,Integer>> body=new ArrayList<>();
        Map<String, Integer> id = new HashMap<>();
        id.put("id",5);
        body.add(id);

        specification.pathParam("postUserGroupPath","user-group");
        UserGroup.body userGroupBody = new UserGroup.body("DepartmentForPostcst", 1,body);
        Response response=given().spec(specification).when()
                .contentType(ContentType.JSON)
                .header("Authorization", Token.cstmr_token())
                .body(userGroupBody).post("/{postUserGroupPath}");
response.then().assertThat().statusCode(401);




    }
    }

