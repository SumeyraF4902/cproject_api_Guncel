package Page.permissionServices;

import BaseUrl.BaseURL;
import PojoDatas.Permission;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import resources.Token;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PutPermissions extends BaseURL {

    @Test
    public void put() {

    /*
 "id": 650,
    "resource": "CREATE",    TEAM01 OLARAK DEGİSTİR
    "action": "WORK, WRİTE.",
    "app_id": 2*/
        specification.pathParam("permissionPath", "permission");
        Permission reqBody= new Permission(727,"TEAM45","WORK, WRİTE.",2);

        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                body(reqBody).
                put("/{permissionPath}");

        response.then().statusCode(200);



        // Permission actualDataMap= response.as(Permission.class);
        //System.out.println("actualDataMap = " + actualDataMap);
        // JsonPath actualDataMap = response.jsonPath();
        //assertEquals(2,actualDataMap.getApp_id());
        ////assertEquals("WORK, WRİTE.",actualDataMap.getAction());
        //assertEquals("TEAM45",actualDataMap.getResource());

        /*
       assertEquals(reqBody.getApp_id(),actualDataMap.getApp_id());
        assertEquals(reqBody.getAction(),actualDataMap.getAction());
        assertEquals(reqBody.getResource(),actualDataMap.getResource());*/

    }

}