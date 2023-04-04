package PojoDatas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class testcases {
    static RequestSpecification specification;
    static int userId = 67;
    static final int organizatinId = 1;
    static String statusId;
    static int roleId;
    static final int defaultRoleId = 23;
    static String subscriptionId = "ba361a19-5fbb-4366-b425-50230f1d7918";
    static final int appId = 2;
    static String password;
    ;
    static String email;
    static String username = "ahmetselim";
    String name = "ahmet";
    String lastname = "selim";
    String phone = "18597565478";
    String address = "clarusway";
    String countryId = "US";
    String statusName = "team01";
    String roleName = "Accountant";
    String newRoleId = "25";
    static User user;
    static String token;
    User user1;


    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions().setHeadless(true);
        opt.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://qa-gm3.quaspareparts.com/oauth2/authorization/a3m-client");
        driver.findElement(By.id("username")).sendKeys("bo@testevolve.com");
        driver.findElement(By.id("password")).sendKeys("wruSRD2xkxpbsbw");
        driver.findElement(By.tagName("button")).click();
        driver.navigate().to("https://qa-gm3.quaspareparts.com/auth/userinfo");
        JsonPath path = new JsonPath(driver.findElement(By.tagName("body")).getText());
        token = "Bearer " + path.getString("access_token");
        driver.quit();

        email = "denemeilyas@gmail.com";

     //   user = new userServiceBuilder()
     //           .setEmail(email)
     //           .setOrganization_id(organizatinId)
     //           .setApp_id(appId)
     //           .setDefault_role_id(defaultRoleId)
     //           .build();
        specification = new RequestSpecBuilder()
                .setBaseUri("https://a3m-qa-gm3.quaspareparts.com")
                .addHeader("Authorization", token)
                .build();
    }


    @Test
    public void registerUserManually() {
        Map<String, Object> registerUserBody = new HashMap<>();
        registerUserBody.put("email", email);
        registerUserBody.put("organization_id", organizatinId);
        registerUserBody.put("app_id", appId);
        registerUserBody.put("default_role_id", defaultRoleId);


        Response response = given()
                .spec(specification)
                .body(registerUserBody)
                .when()
                .post("/auth/api/user/register");
        response.then().statusCode(200);


        user1 = response.as(User.class);

        System.out.println(user1);
        userId = response.jsonPath().getInt("id");
        statusId = response.jsonPath().getString("status_id");
        subscriptionId = response.jsonPath().getString("subscription_id");
        password = response.jsonPath().getString("password");

        assertEquals(user1.getEmail(), email);
        assertFalse(user1.getUsername().isEmpty());
        assertTrue(user1.getId() > 0);


    }

    @Test
    public void deleteUserById() {
        Response response = given()
                .spec(specification)
                .when()
                .delete("/auth/api/user/" + 197);
        response.then().statusCode(200);

    }

    @Test
    public void resetUsersCredentials() {
        Map<String, Integer> resetCredentialsBody = new HashMap<>();
        resetCredentialsBody.put("id", user1.getId());
        resetCredentialsBody.put("organizationId", user1.getOrganization_id());

        Response response = given()
                .spec(specification)
                .body(resetCredentialsBody)
                .when()
                .post("/auth/api/user/reset-credentials");
        response.then().statusCode(201);

        user1.setPassword(response.jsonPath().getString("password"));
        assertEquals(user1.getId(), response.jsonPath().getInt("id"));

    }

    @Test
    public void getUserById() {
        Response response = given()
                .spec(specification)
                .when()
                .get("/auth/api/user/" + userId);
        response.then().statusCode(200);
        response.prettyPrint();
        System.out.println("*********************");
        user1 = response.as(User.class);
        System.out.println("*********************");
        System.out.println(user1);
        assertEquals(user1.getId(), response.jsonPath().getInt("id"));
        assertEquals(user1.getEmail(), response.jsonPath().getString("email"));



    }

    @Test
    public void addRoleToUser() {

        Map<String,Object> addRoleBody = new HashMap<>();
        addRoleBody.put("user_id", userId);
        addRoleBody.put("subscription_id", subscriptionId);
        addRoleBody.put("role_id", newRoleId);
        Response response = given()
                .spec(specification)
                .body(addRoleBody)
                .when()
                .put("/auth/api/membership/role");
        response.then().statusCode(200);



    }

    @Test
    public void updateExistingUser() {

        Map<String, Object> updateUserBody = new HashMap<>();
        updateUserBody.put("id", userId);
        updateUserBody.put("name", name);
        updateUserBody.put("lastname", lastname);
        updateUserBody.put("username", username);
        updateUserBody.put("phone", phone);
        updateUserBody.put("address", address);
        updateUserBody.put("country_id", countryId);

        Response response = given()
                .spec(specification)
                .body(updateUserBody)
                .when()
                .put("/auth/api/user");
        response.then().statusCode(200);
        user1 = new UserBuilder()
                .setName(name)
                .setUsername(username)
                .setLastname(lastname)
                .setPhone(phone)
                .setAddress(address)
                .setCountry_id(countryId).build();
        user1 = response.as(User.class);

        assertEquals(user1.getId(),response.jsonPath().getInt("id"));
        assertEquals(user1.getName(),response.jsonPath().getString("name"));
        assertEquals(user1.getUsername(),response.jsonPath().getString("username"));
        assertEquals(user1.getPhone(),response.jsonPath().getString("phone"));
        assertEquals(user1.getAddress(),response.jsonPath().getString("address"));
        assertEquals(user1.getCountry_id(),response.jsonPath().getString("country_id"));

    }

    @Test
    public void deleteRoleFromUser() {

        Map<String,Object> deleteRoleBody = new HashMap<>();
        deleteRoleBody.put("user_id", userId);
        deleteRoleBody.put("subscription_id", subscriptionId);
        deleteRoleBody.put("role_id", newRoleId);
        Response response = given()
                .spec(specification)
                .body(deleteRoleBody)
                .when()
                .delete("/auth/api/membership/role");
        response.then().statusCode(200);




    }

    @Test
    public void sendEmailVerification() {
        Map<String,Integer> sendVerificationBody = new HashMap<>();
        sendVerificationBody.put("id", userId);
        Response response = given()
                .spec(specification)
                .body(sendVerificationBody)
                .post("/auth/api/user/send-verification-request");

        response.then().statusCode(200);


    }

    @Test
    public void getAllUsers() throws IOException {

        Response response = given()
                .spec(specification)
                .when()
                .get("/auth/api/user");
        response.then().statusCode(200);



        ArrayList<User> users = (ArrayList<User>) new ObjectMapper()
                .readValue(response.asString(), new TypeReference<List<User>>() {});
        System.out.println(users);
        System.out.println("*************");
        System.out.println(response.prettyPrint());

    }

    @Test
    public void cherrypickUsersByProvidingListOfIds() {

        int[] cherryList = new int[3];
        cherryList[0] = 40;
        cherryList[1] = 44;
        cherryList[2] = 3;

        Response response = given()
                .spec(specification)
                .body(cherryList)
                .when()
                .post("/auth/api/user/cherry-pick");

        response.then().statusCode(200);

    }

    @Test
    public void addNewUser() {
        specification.pathParams("organization_id", organizatinId, "app_id", appId, "default_role_id", defaultRoleId);

        Map<String, Object> addnewUserBody = new HashMap<>();
        addnewUserBody.put("email", email);
        addnewUserBody.put("organization_id", organizatinId);
        addnewUserBody.put("app_id", appId);
        addnewUserBody.put("default_role_id", defaultRoleId);

        Response response = given()
                .spec(specification)
                .when()
                .post("/auth/api/organization"+"/{organization_id}"+"/application"+"/{app_id}"+"/role"+"/{default_role_id}"+"/user");

        response.then().statusCode(201);

    }

    @Test
    public void resendOrganizationInvitation() {

        Map<String, Integer> resendInvitationBody = new HashMap<>();
        resendInvitationBody.put("id", userId);
        resendInvitationBody.put("organization_id", organizatinId);
        resendInvitationBody.put("app_id", appId);
        Response response = given()
                .spec(specification)
                .body(resendInvitationBody)
                .when()
                .post("/auth/api/user/resend-organization-invitation");

        response.then().statusCode(200);

    }


}
