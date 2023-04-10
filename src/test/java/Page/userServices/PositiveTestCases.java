package Page.userServices;

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
import utilities.JsonToJava;
import java.util.List;

import static org.testng.Assert.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PositiveTestCases {
    public static RequestSpecification specification;
    static int userId;
    static String token;


    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions().setHeadless(true);
        opt.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://qa-gm3.quaspareparts.com/oauth2/authorization/a3m-client");
        driver.findElement(By.id("username")).sendKeys("bo@testevolve.com");
        driver.findElement(By.id("password")).sendKeys("y5HWgTQnMG733cy");
        driver.findElement(By.tagName("button")).click();
        driver.navigate().to("https://qa-gm3.quaspareparts.com/auth/userinfo");
        JsonPath path = new JsonPath(driver.findElement(By.tagName("body")).getText());
        token = "Bearer " + path.getString("access_token");
        driver.quit();

        specification = new RequestSpecBuilder()
                .setBaseUri("https://a3m-qa-gm3.quaspareparts.com/auth/api")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", token)
                .build();
    }


    @Test(description = "[POST]/auth/api/user/register")
    public void registerUserManually() {

        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();

        Response response = User.registerNewUser(requestBody);
        response.then().statusCode(201);

        User newUser = JsonToJava.convertJsonToJavaObject(response.asString(), User.class);

        assertEquals(requestBody.getEmail(), newUser.getEmail());
        assertFalse(newUser.getUsername().isEmpty());
        assertTrue(newUser.getId() > 0);
        assertFalse(newUser.getPassword().isEmpty());


    }

    @Test(description = "[DELETE]/auth/api/user/{id}")
    public void deleteUserById() {

        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();
        Response response = User.registerNewUser(requestBody);

        response.then().statusCode(201);
        userId = response.jsonPath().getInt("id");

        Response getUser = User.getUserById(userId);
        getUser.then().statusCode(200);

        Response deleteUser = User.deleteUser(userId);
        deleteUser.then().statusCode(200);

        Response userControl = User.getUserById(userId);
        userControl.then().statusCode(404);

    }

    @Test(description = "[POST]/auth/api/user/reset-credentials")
    public void resetUsersCredentials() {
//     //   findAll{it.status.description!='User account is activated and authorized to use the application'}.id
        List<Integer> ids = User.getAllUsers().jsonPath().getList("findAll{it.id>=360}.id");
        int size = ids.size();
        userId = ids.get(size - 1);
        Response selectedUser = User.getUserById(userId);
        selectedUser.jsonPath().prettyPrint();

        User.ResetUserCredentials requestBody = new User.ResetUserCredentials(userId);
        Response response = User.resetUserCredentials(requestBody);

        response.prettyPrint();
        response.then().statusCode(201);
        assertEquals(requestBody.getId(), response.jsonPath().getInt("id"));

    }

    @Test(description = "[GET]/auth/api/user/{id}")
    public void getUserById() {

        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);

        Response response = User.getUserById(userId);
        response.then().statusCode(200);
        assertEquals(userId, response.jsonPath().getInt("id"));
        assertFalse(response.jsonPath().getString("email").isEmpty());

    }

    @Test
    public void addRoleToUser() {

        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);

        User.DeleteOrAddRoleBody requestBody;
        while (true) {
            requestBody = new User.DeleteOrAddRoleBody(userId);
            System.out.println(requestBody);
            if (!User.getUserById(userId).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id())) {
                Response response = User.addRoleToUser(requestBody);
                response.then().statusCode(200);
                break;
            }
        }
        assertTrue(User.getUserById(userId).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id()));
        Response response = User.deleteRoleFromUser(requestBody);
        response.prettyPrint();
        response.then().statusCode(200);


    }

    @Test(description = "[PUT]/auth/api/user")
    public void updateExistingUser() {

        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);

        User.UpdateUser requestBody = new User.UpdateUser(userId);

        Response response = User.updateUser(requestBody);

        response.then().statusCode(200);

        assertEquals(requestBody.getId(), response.jsonPath().getInt("id"));
        assertEquals(requestBody.getUsername(), response.jsonPath().getString("username"));
        assertEquals(requestBody.getAddress(), response.jsonPath().getString("address"));

    }

    @Test
    public void deleteRoleFromUser() {

        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);

        User.DeleteOrAddRoleBody requestBody;
        while (true) {
            requestBody = new User.DeleteOrAddRoleBody(userId);
            if (!User.getUserById(userId).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id())) {
                Response response = User.addRoleToUser(requestBody);
                response.then().statusCode(200);
                break;
            }
        }

        Response response = User.deleteRoleFromUser(requestBody);
        response.then().statusCode(200);
        assertFalse(User.getUserById(userId).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id()));

    }

    @Test(description = "[POST]/auth/api/user/send-verification-request")
    public void sendEmailVerification() {
        List<Integer> ids = User.getAllUsers().jsonPath().getList("findAll{it.id>=360}.id");
        userId = ids.get(0);
        System.out.println("userId = " + userId);

        Response response = User.sendEmailVerification(userId);
        response.then().statusCode(200);
        assertNotNull(response.jsonPath().getString("response_status"));
        assertNotNull(response.jsonPath().getString("message"));


    }

    @Test(description = "[GET]/auth/api/user")
    public void getAllUsers() {

        Response response = User.getAllUsers();

        response.then().statusCode(200);
        assertTrue((response.jsonPath().getList("id")).size() > 0);


    }

    @Test(description = "[POST]/auth/api/user/cherry-pick")
    public void cherrypickUsersByProvidingListOfIds() {

        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");

        int[] requestBody = new int[3];
        requestBody[0] = ids.get(1);
        requestBody[1] = ids.get(2);
        requestBody[2] = ids.get(3);

        Response response = User.cherryPickUsers(requestBody);
        response.then().statusCode(200);
        assertEquals(3, response.jsonPath().getList("id").size());
    }

    @Test(description = "[POST]/auth/api/organization/{organizationId}/application/{appId}/role/{roleId}/user")
    public void inviteNewUser() {

        User.RegisterUserRequest requestBody = new User.RegisterUserRequest();

        Response response = User.inviteNewUser(requestBody);
        response.then().statusCode(201);
        assertEquals(requestBody.getEmail(), response.jsonPath().getString("email"));
        assertEquals(requestBody.getEmail(), response.jsonPath().getString("username"));
        assertFalse(Boolean.parseBoolean(response.jsonPath().getString("is_email_verified")));


    }

    @Test(description = "[POST]/auth/api/user/resend-organization-invitation")
    public void resendOrganizationInvitation() {

        List<Integer> ids = User.getAllUsers().jsonPath()
                .getList("id");
        userId = ids.get(0);
        User.getAllUsers().prettyPrint();
        User.ResendOrganizationInvitation requestBody = new User.ResendOrganizationInvitation(userId);

        Response response = User.resendOrganizationInvitation(requestBody);
        response.prettyPrint();
        response.then().statusCode(200);
        assertEquals("Invitation email request sent successfully", response.jsonPath().getString("message"));

    }

    @Test(description = "[GET]/auth/api/organization/{organizationId}/user")
    public void getAllUsersOfOrganization() {
        int organizationId = 181;
        Response response = User.getAllUsersOfOrganization(organizationId);
        response.then().statusCode(200);
        List<Integer> differenIdList = response.jsonPath()
                .getList("findAll { user -> user.user_groups.any { group -> group.organization_id != 1 } }");
        assertFalse(differenIdList.size() > 0);


    }


}
