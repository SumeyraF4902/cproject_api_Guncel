package Page.organizationStatusServices;

import BaseUrl.BaseURL;
import PojoDatas.OrganizationStatus;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.Token;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MethodPost extends BaseURL {
    static int team_id;
    @Test
    public void GetAllOrganizationStatus() {
        specification.pathParams("org-stts-path", "organization-status");
        OrganizationStatus org = new OrganizationStatus("team01", "team01");
        System.out.println(org);
        Response response = given().spec(specification).contentType(ContentType.JSON).when().
                header("Authorization", Token.BO_token()).
                body(org.toString()).
                post("/{org-stts-path}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
        JsonPath jsonPath = response.jsonPath();

// Get the teams object from the response body
        Map<String, ?> teams = jsonPath.getMap("");


// Get the team01Id
        team_id = (int) teams.get("id");
    }
}

