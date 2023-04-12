package Page.organizationServices;

import BaseUrl.BaseURL;
import PojoDatas.Organization;
import PojoDatas.OrganizationStatus;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.Token;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Organization_Post extends BaseURL {

    @Test
    public void PostAllOrganizationStatus() {
        specification.pathParams("org-stts-path", "organization");
        Organization org = new Organization("team01", 30,"2023-04-06T22:32:42.306169Z","2023-04-06T22:32:42.306170Z");
        System.out.println(org);
        Response response = given().spec(specification).contentType(ContentType.JSON).when().
                header("Authorization", Token.BO_token()).
                body(org).
                post("/{org-stts-path}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);

    }
}
