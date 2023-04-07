package Page.organizationStatusServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import utilities.Token;

import static io.restassured.RestAssured.given;

public class MethodPut extends BaseURL {
    @Test
    public void GetAllOrganizationStatus() {
        specification.pathParams("org-stts-path", "organization-status");
        //OrganizationStatus org = new OrganizationStatus();
        Response response = given().spec(specification).when().
                header("Authorization", Token.BO_token()).
                //body().
                put("/{org-stts-path}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
