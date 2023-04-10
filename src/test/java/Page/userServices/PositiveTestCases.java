package Page.userServices;

import BaseUrl.BaseURL;
import PojoDatas.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import resources.Token;
import utilities.JsonToJava;

import java.util.List;

import static org.testng.Assert.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PositiveTestCases extends BaseURL {
    static int userId;

    @Test(description = "[POST]/auth/api/user/register")
    public void registerUserManually() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();

        Response response = User.registerNewUser(requestBody, specification);
        response.then().statusCode(201);

        User newUser = JsonToJava.convertJsonToJavaObject(response.asString(), User.class);

        assertEquals(requestBody.getEmail(), newUser.getEmail());
        assertFalse(newUser.getUsername().isEmpty());
        assertTrue(newUser.getId() > 0);
        assertFalse(newUser.getPassword().isEmpty());


    }

    @Test(description = "[DELETE]/auth/api/user/{id}")
    public void deleteUserById() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();
        Response response = User.registerNewUser(requestBody, specification);

        response.then().statusCode(201);
        userId = response.jsonPath().getInt("id");

        Response getUser = User.getUserById(userId, specification);
        getUser.then().statusCode(200);

        Response deleteUser = User.deleteUser(userId, specification);
        deleteUser.then().statusCode(200);

        Response userControl = User.getUserById(userId, specification);
        userControl.then().statusCode(404);

    }

    @Test(description = "[POST]/auth/api/user/reset-credentials")
    public void resetUsersCredentials() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("findAll{it.id>=360}.id");
        int size = ids.size();
        userId = ids.get(size - 1);
        Response selectedUser = User.getUserById(userId, specification);

        User.ResetUserCredentials requestBody = new User.ResetUserCredentials(userId);
        Response response = User.resetUserCredentials(requestBody, specification);

        response.then().statusCode(201);
        assertEquals(requestBody.getId(), response.jsonPath().getInt("id"));

    }

    @Test(description = "[GET]/auth/api/user/{id}")
    public void getUserById() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);

        Response response = User.getUserById(userId, specification);
        response.then().statusCode(200);
        assertEquals(userId, response.jsonPath().getInt("id"));
        assertFalse(response.jsonPath().getString("email").isEmpty());

    }

    @Test
    public void addRoleToUser() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);

        User.DeleteOrAddRoleBody requestBody;
        while (true) {
            requestBody = new User.DeleteOrAddRoleBody(userId);
            System.out.println(requestBody);
            if (!User.getUserById(userId, specification).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id())) {
                Response response = User.addRoleToUser(requestBody, specification);
                response.then().statusCode(200);
                break;
            }
        }
        assertTrue(User.getUserById(userId, specification).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id()));
        Response response = User.deleteRoleFromUser(requestBody, specification);
        response.then().statusCode(200);

    }

    @Test(description = "[PUT]/auth/api/user")
    public void updateExistingUser() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);

        User.UpdateUser requestBody = new User.UpdateUser(userId);

        Response response = User.updateUser(requestBody, specification);

        response.then().statusCode(200);

        assertEquals(requestBody.getId(), response.jsonPath().getInt("id"));
        assertEquals(requestBody.getUsername(), response.jsonPath().getString("username"));
        assertEquals(requestBody.getAddress(), response.jsonPath().getString("address"));

    }

    @Test
    public void deleteRoleFromUser() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);

        User.DeleteOrAddRoleBody requestBody;
        while (true) {
            requestBody = new User.DeleteOrAddRoleBody(userId);
            if (!User.getUserById(userId, specification).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id())) {
                Response response = User.addRoleToUser(requestBody, specification);
                response.then().statusCode(200);
                break;
            }
        }

        Response response = User.deleteRoleFromUser(requestBody, specification);
        response.then().statusCode(200);
        assertFalse(User.getUserById(userId, specification).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id()));

    }

    @Test(description = "[POST]/auth/api/user/send-verification-request")
    public void sendEmailVerification() {

        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("findAll{it.id>=360}.id");
        userId = ids.get(0);

        Response response = User.sendEmailVerification(userId, specification);
        response.then().statusCode(200);
        assertNotNull(response.jsonPath().getString("response_status"));
        assertNotNull(response.jsonPath().getString("message"));


    }

    @Test(description = "[GET]/auth/api/user")
    public void getAllUsers() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        Response response = User.getAllUsers(specification);

        response.then().statusCode(200);
        assertTrue((response.jsonPath().getList("id")).size() > 0);


    }

    @Test(description = "[POST]/auth/api/user/cherry-pick")
    public void cherrypickUsersByProvidingListOfIds() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath().getList("id");

        int[] requestBody = new int[3];
        requestBody[0] = ids.get(1);
        requestBody[1] = ids.get(2);
        requestBody[2] = ids.get(3);

        Response response = User.cherryPickUsers(requestBody, specification);
        response.then().statusCode(200);
        assertEquals(3, response.jsonPath().getList("id").size());
    }

    @Test(description = "[POST]/auth/api/organization/{organizationId}/application/{appId}/role/{roleId}/user")
    public void inviteNewUser() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();

        Response response = User.inviteNewUser(requestBody, specification);
        response.then().statusCode(201);
        assertEquals(requestBody.getEmail(), response.jsonPath().getString("email"));
        assertEquals(requestBody.getEmail(), response.jsonPath().getString("username"));
        assertFalse(Boolean.parseBoolean(response.jsonPath().getString("is_email_verified")));


    }

    @Test(description = "[POST]/auth/api/user/resend-organization-invitation")
    public void resendOrganizationInvitation() {
        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        List<Integer> ids = User.getAllUsers(specification).jsonPath()
                .getList("id");
        userId = ids.get(0);
        User.ResendOrganizationInvitation requestBody = new User.ResendOrganizationInvitation(userId);

        Response response = User.resendOrganizationInvitation(requestBody, specification);
        response.then().statusCode(200);
        assertEquals("Invitation email request sent successfully", response.jsonPath().getString("message"));

    }

    @Test(description = "[GET]/auth/api/organization/{organizationId}/user")
    public void getAllUsersOfOrganization() {

        specification
                .contentType(ContentType.JSON)
                .header("Authorization", Token.BO_token());

        int organizationId = 181;
        Response response = User.getAllUsersOfOrganization(organizationId, specification);
        response.then().statusCode(200);
        List<Integer> differenIdList = response.jsonPath()
                .getList("findAll { user -> user.user_groups.any { group -> group.organization_id != 1 } }");
        assertFalse(differenIdList.size() > 0);


    }


}
