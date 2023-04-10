package Page.permissionServices;

import BaseUrl.BaseURL;
import PojoDatas.Permission;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import resources.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;



public class PostPermissions extends BaseURL {


    static int id;
    @Test
    public void post() {

        specification.pathParam("permissionPath", "permission");

        Permission reqBody=new Permission("Karete","Kusak",2);
       /* String reqBody= "{\n" +
                "               \"resource\": \"CREATE\",\n" +
                "                \"action\": \"WORK, WRİTE.\",\n" +
                "                \"app_id\": 2\n" +
                "        }";*/



        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                body(reqBody).
                post("/{permissionPath}");

        // response.then().assertThat().statusCode(201).
        //       contentType(ContentType.JSON);
        response.prettyPrint();

        response.then().assertThat().statusCode(201).contentType(ContentType.JSON);
        response.then().assertThat().body("resource",equalTo("CREATE"));
        response.then().assertThat().body("action",equalTo("WORK, WRİTE."));
        response.then().assertThat().body("app_id",equalTo(2));


        JsonPath jsonPath = response.jsonPath();
       //int id=JsonPath.
        //System.out.println("actualDataMap = " + actualDataMap);




        // assertEquals(2,actualDataMap.getApp_id());
        //("WORK, WRİTE.",actualDataMap.getAction());
        //  assertEquals("CREATE",actualDataMap.getResource());
        //JsonPath jsonPath = response.jsonPath();
        Map<String, Object> teams = jsonPath.getMap("");
        //id= (Map<String, Integer>) teams.get("id");
        System.out.println("id = " + id);



// Get the team01Id



    }
}