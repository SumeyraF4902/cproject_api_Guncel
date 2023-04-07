package Page.organizationStatusServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import resources.Token;

import static io.restassured.RestAssured.given;

public class MethodDelete extends BaseURL {

    @Test
    public void organization_status_delete_selected() {
        specification.pathParams("org-stts-path", "organization-status",
                "idPath", MethodPost.team_id);
        Response response = given().spec(specification).when().
                header("Authorization", Token.BO_token()).
                delete("/{org-stts-path}/{idPath}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void organization_status_delete_list() {
        specification.pathParams("org-stts-path", "organization-status",
                "idPath", 70);
        Response response = given().spec(specification).when().
                header("Authorization", Token.BO_token()).
                delete("/{org-stts-path}/{idPath}");
        System.out.println("Response:  ");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        MethodGet.team_id_list.remove(MethodGet.team_id_list.get(0));
        if (MethodGet.team_id_list.size()>0){
            organization_status_delete_list();
        };
    }

}

