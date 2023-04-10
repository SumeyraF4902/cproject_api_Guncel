package Page.permissionServices;

import BaseUrl.BaseURL;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import resources.Token;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;


public class DeletePermission extends BaseURL {
    int id=PostPermissions.id;
    @Test
    public void delete() {
        ///auth/api/permission/{id}



        // Burada post nesnesinin kimlik değerini alarak id değişkenine atayabilirsiniz.

        specification.pathParams("permissionPath", "permission", "idPath",id);
        //Permission reqBody = new Permission(PostPermissions.id, "TEAM45", "WORK, WRİTE.", 2);

        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                delete("/{permissionPath}/{idPath}");

        response.then().assertThat().statusCode(200);

    }
}