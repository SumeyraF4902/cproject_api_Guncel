
package Page.membershipTypeServices;

import BaseUrl.BaseURL;
import PojoDatas.MembershipType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import resources.LoginPage;
import resources.Token;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class a  extends BaseURL {


    HashMap<String, Object>MembershipData;

    @Test
    public void GET_TC001_MembershipTypeAppID(){
        specification.pathParams( "applicationPath","application","idPath", 2 ,"MembershiptypePath","membership-type");
        Response response = given().
                spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{applicationPath}/{idPath}/{MembershiptypePath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }


    @Test
    public void GET_TC002_MembershipType(){
        specification.pathParam("MembershiptypePath", "membership-type");

        Response response = given().
                spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{MembershiptypePath}");

        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());


    }


    @Test
    public void POST_TC003_AddNewUser(){

        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/membership-type";
        MembershipType pj=new MembershipType("Ali", "true", 2);
        Response response=given().
                contentType(ContentType.JSON).
                header("Authorization",  Token.BO_token()).
                body(pj).
                when().
                post(URL);
        response.prettyPrint();


        MembershipData= JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actuelDataMap = " + MembershipData);

        response.then().assertThat().statusCode(201);
        System.out.println("response.getStatusCode = " + response.getStatusCode());

    }




}
