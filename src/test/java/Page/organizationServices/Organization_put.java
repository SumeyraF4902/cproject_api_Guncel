package Page.organizationServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.Token;

import static io.restassured.RestAssured.given;

public class Organization_put extends BaseURL {
    @Test
    public void Put_org_stts() {
        specification.pathParams("org-stts-path", "organization");
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
