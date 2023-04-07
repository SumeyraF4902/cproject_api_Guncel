package Page.organizationStatusServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import utilities.Token;

import static io.restassured.RestAssured.given;

public class MethodGet extends BaseURL {
    @Test()
    public void GetAllOrganizationStatus() {
        specification.pathParams("org-stts-path", "organization-status");

        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).
                get("/{org-stts-path}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void GetOrganizationStatusByid(){
        specification.pathParams("org-stts-path", "organization-status","id-path", "4");

        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).
                get("/{org-stts-path}/{id-path}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
