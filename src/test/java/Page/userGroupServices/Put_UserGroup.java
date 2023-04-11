package Page.userGroupServices;

import BaseUrl.BaseURL;


import PojoDatas.UserGroup.Group_type;
import PojoDatas.UserGroup.Organization;
import PojoDatas.UserGroup.UserGroupMainPojo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import resources.Token;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class Put_UserGroup extends BaseURL {

    @Test

    public void TC_004() {


       specification.pathParam("getUserGroupPath", "user-group");
    //   Response response = given().spec(specification).when().header("Authorization", Token.BO_token()).get("/{getUserGroupPath}");
    //   JsonPath jsonPath = response.jsonPath();
    //   List<Map<String, Object>> userGroups = jsonPath.getList("");
    //   int otoID = 0;
    //   for (Map<String, Object> userGroup : userGroups) {
    //       if (userGroup.get("name").toString().contains("Team1s")) {
    //           otoID = (Integer) userGroup.get("id");
    //           break;
    //       }
    //   }
    //   int putId = otoID;
    //   System.out.println(putId);

       Group_type gt = new Group_type(1, "Department", "User account is deactivated, and not authorized to access any the application");

       Organization og = new Organization(181, "TestEvolve", 43, "TE", "2023-04-10T13:08:39.699420Z", "2023-04-10T13:08:39.699421Z");

       ArrayList<Map<String, Integer>> roles = new ArrayList<>();
       Map<String, Integer> rolesMap = new HashMap<>();
       rolesMap.put("id", 5);
       roles.add(rolesMap);



        UserGroupMainPojo reqBody =
          //      new UserGroupMainPojo(putId, "DepartmentTeam1s", 1, gt, 1, og,roles ,"denemedeldel");
                new UserGroupMainPojo(105, "DepartmentTeam1s", 1, gt, 1, og,roles ,"denemedeldel");
        System.out.println(reqBody);

        Response responsePut = given().spec(specification).when().contentType(ContentType.JSON).header("Authorization", Token.BO_token()).body(reqBody).put("/{getUserGroupPath}");
        responsePut.prettyPrint();
        //    JsonPath jsonPathForPut = responsePut.jsonPath();
        //   jsonPathForPut.prettyPrint();
        //  String actualName = jsonPathForPut.getString("short_name");
        //      System.out.println(actualName);
        //   assertEquals(actualName, "deldeldel");

/*{"id":105,"name":"DepartmentTeam1s","group_type_id":1,"group_type":{"id":1,"name":"Department","description":"User account is deactivated, and not authorized to access any the application"},"organization_id":181,
"organization":{"id":181,"name":"TestEvolve","founder_id":43,"short_name":"TE","created_at":"2023-04-10T13:08:39.699420Z","updated_at":"2023-04-10T13:08:39.699421Z"},"roles":[{"id":5}],"short_name":"del"} */

    }

}
