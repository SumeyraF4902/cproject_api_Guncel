package Page.organizationStatusServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.Token;
import java.util.List;


import static io.restassured.RestAssured.given;

public class MethodGet extends BaseURL {
      static List<Integer>team_id_list;
    @Test
    public void ZGetAllOrganizationStatus() {
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
        specification.pathParams("org-stts-path", "organization-status");

        Response response = given().spec(specification).when().
                header("Authorization",  Token.BO_token()).
                get("/{org-stts-path}");
        response.then().assertThat().statusCode(200);


        team_id_list = response.jsonPath().getList("findAll { it.name == 'team01' }.id");


    }
}
