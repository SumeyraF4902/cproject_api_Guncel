package Page.organizationStatusServices;

import BaseUrl.BaseURL;
import PojoDatas.OrganizationStatus;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import utilities.Token;

import static Page.organizationStatusServices.MethodPost.team_id;
import static io.restassured.RestAssured.given;

public class MethodPut extends BaseURL {
    @Test
    public void Put_org_stts() {
        System.out.println(team_id);
        specification.pathParams("org-stts-path", "organization-status");
        OrganizationStatus org = new OrganizationStatus("team011","team011",team_id);
        Response response = given().spec(specification).when().
                header("Authorization", Token.BO_token()).
                body(org.toString()).
                put("/{org-stts-path}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
