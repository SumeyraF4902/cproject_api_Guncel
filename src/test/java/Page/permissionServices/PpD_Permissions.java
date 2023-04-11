package Page.permissionServices;

import BaseUrl.BaseURL;
import Page.permissionServices.PermissionData;
import PojoDatas.Permission;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import resources.Token;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;



public class PpD_Permissions extends BaseURL {


     static int createdBookId ;
    @Test
    public void post() {

        specification.pathParam("permissionPath", "permission");

        PermissionData reqBody = new PermissionData();
        HashMap<String, Object> body = reqBody.expecdetData(null, "CREATE", "WORK, WRİTE.", 2);

        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                body(body).
                post("/{permissionPath}");
        response.prettyPrint();

        response.then().assertThat().statusCode(201).contentType(ContentType.JSON);
        response.then().assertThat().body("resource", equalTo("CREATE"));
        response.then().assertThat().body("action", equalTo("WORK, WRİTE."));
        response.then().assertThat().body("app_id", equalTo(2));

         createdBookId = response.getBody().as(Permission.class).getId();

    }

    @Test
    public void put() {

        specification.pathParam("permissionPath", "permission");
        PermissionData reqBody = new PermissionData();
        HashMap<String, Object> body = reqBody.expecdetData(createdBookId, "TEAM45", "WORK, WRİTE.", 2);

        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                body(body).
                put("/{permissionPath}");

        response.then().statusCode(200);
    }

       @Test (priority = 2)
        public void delete() {

            specification.pathParams("permissionPath", "permission", "idPath",createdBookId);
            Response response = given().spec(specification).contentType(ContentType.JSON).
                    when().
                    header("Authorization", Token.BO_token()).
                    delete("/{permissionPath}/{idPath}");

            response.then().assertThat().statusCode(200);

        }
    }






