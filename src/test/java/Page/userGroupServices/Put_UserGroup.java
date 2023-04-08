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
    public void TC_004(){


       specification.pathParam("getUserGroupPath","user-group");
       Response response=given().spec(specification).when().header("Authorization", Token.BO_token()).get("/{getUserGroupPath}");
       JsonPath jsonPath = response.jsonPath();
      List<Map<String, Object>> userGroups = jsonPath.getList("");
      int otoID =0;
      for (Map<String, Object> userGroup : userGroups) {
          if (userGroup.get("name").equals("DepartmentForPost")) {
              otoID = (Integer) userGroup.get("id");
              break;
          }
       }

/*
{"id":,"name":"deneme","group_type_id":1,"group_type":{"id":1,"name":"Department",
"description":"User account is deactivated, and not authorized to access any the application"},
"organization_id":1,"organization":{"id":1,"name":"Acme01","founder_id":2,"short_name":"team",
"address":"Ronald Avenue McMillan Drive No. 5, Tysons, Virginia","phone":"15555555555","email":"contactacme.com","website":"www.acme.com","fax":"1555555555",
"status_id":1,"created_at":"2023-01-17T20:35:06.419830Z","updated_at":"2023-04-07T14:30:42.199813Z"},"users":[],"roles":[{"id":5}],"short_name":"deldeldel"}
 */
  Group_type gt=new Group_type(1,"Department","User account is deactivated, and not authorized to access any the application");
  Organization og=new Organization(1,"Acme01",2,
          "team","Ronald Avenue McMillan Drive No. 5, Tysons, Virginia","15555555555","contactacme.com","www.acme.com","1555555555"
          ,1,"2023-01-17T20:35:06.419830Z","2023-04-07T14:30:42.199813");
  ArrayList<Map<String,Integer>> roles=new ArrayList<>();
  Map<String, Integer> rolesMap = new HashMap<>();
  rolesMap.put("id",5);
  roles.add(rolesMap);

  UserGroupMainPojo reqBody= new UserGroupMainPojo(otoID,"DepartmentForPost",1,gt,1,og,new ArrayList<>(),roles,"deldeldel");
       System.out.println(reqBody.toString());
       response=given().spec(specification).when().header("Authorization", Token.BO_token()).contentType(ContentType.JSON).body(reqBody).put("/{getUserGroupPath}");
       JsonPath jsonPathForPut = response.jsonPath();
       jsonPathForPut.prettyPrint();
      String actualName = jsonPathForPut.getString("name");
       assertEquals(actualName, "deldeldel");



    }

}
