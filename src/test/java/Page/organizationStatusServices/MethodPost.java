package Page.organizationStatusServices;

import BaseUrl.BaseURL;
import PojoDatas.OrganizationStatus;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Token;

import static io.restassured.RestAssured.given;

public class MethodPost extends BaseURL {
    @Test
    public void GetAllOrganizationStatus() {
        specification.pathParams("org-stts-path", "organization-status");
        OrganizationStatus org = new OrganizationStatus("team01","team01");
        System.out.println(org);
        Response response = given().spec(specification).contentType(ContentType.JSON).when().
                header("Authorization", Token.BO_token()).
                body(org.toString()).
                post("/{org-stts-path}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
    }
}
