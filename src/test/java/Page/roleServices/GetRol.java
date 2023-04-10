package Page.roleServices;

import BaseUrl.BaseURL;


import PojoDatas.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.Token;
import java.util.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;



public class GetRol extends BaseURL {

    @Test
    public void getRolAppId() throws JsonProcessingException {


        //application/{appId}/role             ==>       appId=2
        specification.pathParams("applicationPath", "application", "appIdPath", 2, "rolePath", "role");
        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                get("/{applicationPath}/{appIdPath}/{rolePath}");
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON);


        JsonPath jsonPath=response.jsonPath();
        List < Map<Integer,Object>>rollers=jsonPath.getList("");
        int otoId=0;
        for(Map<Integer,Object> actualDataMap : rollers) {
            if (actualDataMap.get("id").equals(23)) {
                otoId = (Integer) actualDataMap.get("id");
                break;
            }
            System.out.println("rollers = " + rollers);
        }

        User rol=new User();
        JSONArray jsonArray = new JSONArray(rollers);
        List<Map<String, Object>> expectetData = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Map<String, Object> dataMap = new HashMap<>();

            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jsonObject.get(key);
                dataMap.put(key, value);
            }
            expectetData.add(dataMap);

        }
        //  System.out.println("expectetData = " + expectetData);
        assertEquals(expectetData.size(), rollers.size());

        for (int i = 0; i < expectetData.size(); i++) {
            assertEquals(expectetData.get(i).get("name"), rollers.get(i).get("name"));
            assertEquals(expectetData.get(i).get("id"), rollers.get(i).get("id"));
            assertEquals(expectetData.get(i).get("app_id"), rollers.get(i).get("app_id"));

        }
    }
    @Test
    public void negatifGetRolAppId() {

        //                       PathParam    ==> appId=3

        specification.pathParams("applicationPath", "application", "appIdPath", 3, "rolePath", "role");
        Response response1 = given().spec(specification).
                contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                get("/{applicationPath}/{appIdPath}/{rolePath}");

        response1.prettyPrint();
        response1.then().assertThat().statusCode(404);



    }
    @Test
    public void id23() {
        //                       PathParam    ==> /role/id    JsonPath cevirerek  dogrulama

        specification.pathParams("rolePath", "role","idPath",23);
        Response response2 = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response2.then().assertThat().statusCode(200).body("id",equalTo(23));
        response2.then().assertThat().contentType(ContentType.JSON);
        // response2.prettyPrint();
        JsonPath jsonPath = response2.jsonPath();
        assertEquals(23,jsonPath.getInt("id"));
        assertEquals("Accountant",jsonPath.getString("name"));

    }
    @Test
    public void id27() {
        //                       PathParam    ==> /role/id     Matchers ile dogrulama

        specification.pathParams("rolePath", "role","idPath",27);
        Response response3 = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response3.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", Matchers.equalTo(27),
                        "name", Matchers.equalTo("Logistics Personnel"),
                        "app_id", Matchers.equalTo(2));

    }

    @Test
    public void id30() {

        //                       PathParam    ==> /role/id            Matchers ile dogrulama

        specification.pathParams("rolePath", "role","idPath",30);
        Response response4 = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response4.
                then().
                assertThat().
                statusCode(200).
                body("id", Matchers.equalTo(30),
                        "name", Matchers.equalTo("Customer"),
                        "app_id", Matchers.equalTo(2));


    }
    @Test
    public void negatifId10() {

        //   PathParam    ==> /role/id

        Response response5= null;

        specification.pathParams("rolePath", "role","idPath",10);
        try {
            response5 = given().spec(specification).
                    when().
                    header("Authorization", Token.BO_token()).
                    get("/{rolePath}/{idPath}");

        }catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("Not Found"));

        }


    }

}
