package PojoDatas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.*;

import static Page.userServices.testcases.specification;
import static io.restassured.RestAssured.given;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private int id;
    private static final int organization_id = 1;
    private static final String subscription_id = "ba361a19-5fbb-4366-b425-50230f1d7918";
    private static final int app_id = 2;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private boolean is_email_verified;
    private String phone;
    private String address;
    private String country_id;
    private Country country;
    private ArrayList<Organization> organizations;
    private ArrayList<UserGroup> user_groups;
    private ArrayList<Role> roles;
    private ArrayList<Application> applications;
    private int pic_id;
    private int status_id;
    private String created_at;
    private String updated_at;
    private int updated_by;
    private UserStatus status;
    private int membership_type_id;
    private int default_role_id;
    private boolean is_individual_membership;
    private String password;
    private static final ArrayList<Integer> roleIdList = new ArrayList<>(Arrays.asList(23, 5, 30, 26, 27, 21, 22, 29, 28, 19, 20, 18, 24, 25));
    private final Map<Integer, String> roleList = new HashMap<>(Map.ofEntries(
            Map.entry(23, "Accountant"), Map.entry(5, "Business Owner"), Map.entry(30, "Customer"),
            Map.entry(26, "Logistics Manager"), Map.entry(27, "Logistics Personnel"), Map.entry(21, "Purchase Manager"), Map.entry(22, "Purchase Personnel"),
            Map.entry(29, "Quality Controller"),
            Map.entry(28, "Quality Manager"), Map.entry(19, "Sales Manager"), Map.entry(20, "Sales Personnel"),
            Map.entry(18, "Store Manager"), Map.entry(24, "Warehouse Manager"), Map.entry(25, "Warehouse Personnel")));

    public User() {

    }

    public static Response registerNewUser(RegisterUserRequest body) {

        return given()
                .spec(specification)
                .when()
                .body(body)
                .post("/user/register");
    }

    public static Response inviteNewUser(RegisterUserRequest body) {

        return given()
                .spec(specification)
                .when()
                .body(body)
                .post("/organization/" + body.organization_id + "/application/" + body.app_id + "/role/" + body.default_role_id + "/user");

    }

    public static Response updateUser(UpdateUser requestBody){
        return given()
                .spec(specification)
                .when()
                .body(requestBody)
                .put("/user");
    }

    public static Response resendOrganizationInvitation(ResendOrganizationInvitation requestBody) {


        return given()
                .spec(specification)
                .when()
                .body(requestBody)
                .post("/user/resend-organization-invitation");
    }

    public static Response resetUserCredentials(ResetUserCredentials body) {

        return given()
                .spec(specification)
                .body(body)
                .when()
                .post("/user/reset-credentials");
    }

    public static Response sendEmailVerification(int id) throws IOException {

        return given()
                .spec(specification)
                .when()
                .body(sendId(id))
                .post("/user/send-verification-request");

    }

    public static String sendId(int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Integer> requestBody = new HashMap<>();
        requestBody.put("id", id);
        return mapper.writeValueAsString(requestBody);

    }

    public static Response getAllUsers() {

        return given()
                .spec(specification)
                .when()
                .get("/user");

    }

    public static Response getUserById(int id) {
        return given()
                .spec(specification)
                .when()
                .get("/user/" + id);
    }

    public static Response deleteUser(int id) {
        return given()
                .spec(specification)
                .when()
                .delete("/user/" + id);

    }


    public static Response addRoleToUser(DeleteOrAddRoleBody requestBody) {
        return given()
                .spec(specification)
                .when()
                .body(requestBody)
                .put("/membership/role");
    }

    public static Response deleteRoleFromUser(DeleteOrAddRoleBody requestBody) {

        return given()
                .spec(specification)
                .when()
                .body(requestBody)
                .delete("/membership/role");
    }

    public static Response cherryPickUsers(int[] cherrylist) {

        return given()
                .spec(specification)
                .when()
                .body(cherrylist)
                .post("/user/cherry-pick");
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_email_verified() {
        return is_email_verified;
    }

    public void setIs_email_verified(boolean is_email_verified) {
        this.is_email_verified = is_email_verified;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ArrayList<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(ArrayList<Organization> organizations) {
        this.organizations = organizations;
    }

    public ArrayList<UserGroup> getUser_groups() {
        return user_groups;
    }

    public void setUser_groups(ArrayList<UserGroup> user_groups) {
        this.user_groups = user_groups;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public void setApplications(ArrayList<Application> applications) {
        this.applications = applications;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public UserStatus getUserStatus() {
        return status;
    }

    public void setUserStatus(UserStatus status) {
        this.status = status;
    }

    public int getOrganization_id() {
        return organization_id;
    }


    public int getApp_id() {
        return app_id;
    }

    public int getMembership_type_id() {
        return membership_type_id;
    }

    public void setMembership_type_id(int membership_type_id) {
        this.membership_type_id = membership_type_id;
    }

    public int getDefault_role_id() {
        return default_role_id;
    }

    public void setDefault_role_id(int default_role_id) {
        this.default_role_id = default_role_id;
    }

    public String getSubscription_id() {
        return subscription_id;
    }


    public boolean isIs_individual_membership() {
        return is_individual_membership;
    }

    public void setIs_individual_membership(boolean is_individual_membership) {
        this.is_individual_membership = is_individual_membership;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }






    @Override
    public String toString() {
        return "userServicePOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", is_email_verified=" + is_email_verified +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", country_id='" + country_id + '\'' +
                ", country=" + country +
                ", organizations=" + organizations +
                ", user_groups=" + user_groups +
                ", roles=" + roles +
                ", applications=" + applications +
                ", pic_id=" + pic_id +
                ", status_id=" + status_id +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", updated_by=" + updated_by +
                ", statusPOJO=" + status +
                ", organization_id=" + organization_id +
                ", app_id='" + app_id + '\'' +
                ", membership_type_id=" + membership_type_id +
                ", default_role_id=" + default_role_id +
                ", subscription_id=" + subscription_id +
                ", is_individual_membership=" + is_individual_membership +
                ", password='" + password + '\'' +
                '}';
    }

    public static class RegisterUserRequest {

        private String email;
        private final int organization_id;
        private final int app_id;
        private int default_role_id;
        Faker faker = new Faker();

        public RegisterUserRequest() {
            this.email = faker.internet().emailAddress();
            organization_id = User.organization_id;
            app_id = User.app_id;
            this.default_role_id = roleIdList.get(new Random().nextInt(roleIdList.size() - 1));
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getOrganization_id() {
            return organization_id;
        }

        public int getApp_id() {
            return app_id;
        }

        public int getDefault_role_id() {
            return default_role_id;
        }

        public void setDefault_role_id(int default_role_id) {

            this.default_role_id = default_role_id;
        }

        @Override
        public String toString() {
            return "{" +
                    "email='" + email + '\'' +
                    ", organization_id=" + organization_id +
                    ", app_id=" + app_id +
                    ", default_role_id=" + default_role_id +
                    '}';
        }


    }

    public static class DeleteOrAddRoleBody {

        private final int user_id;
        private final String subscription_id;
        private final int role_id;

        public DeleteOrAddRoleBody(int user_id) {
            this.user_id = user_id;
            this.role_id = roleIdList.get(new Random().nextInt(roleIdList.size() - 1));
            this.subscription_id = User.subscription_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public String getSubscription_id() {
            return subscription_id;
        }

        public int getRole_id() {
            return role_id;
        }

        @Override
        public String toString() {
            return "{" +
                    "user_id=" + user_id +
                    ", subscription_id='" + subscription_id + '\'' +
                    ", role_id=" + role_id +
                    '}';
        }
    }

    public static class ResendOrganizationInvitation {
        private int id;
        private int organization_id;
        private int app_id;


        public ResendOrganizationInvitation(int id) {
            this.id = id;
            this.organization_id = User.organization_id;
            this.app_id = User.app_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    '}';
        }
    }


    public static class UpdateUser {
        private int id;
        private String name;
        private String lastname;
        private String username;
        private String phone;
        private String address;
        private String country_id;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCountry_id() {
            return country_id;
        }

        public void setCountry_id(String country_id) {
            this.country_id = country_id;
        }

        public UpdateUser(int id) {
            Faker faker = new Faker();
            this.id = id;
            this.name = faker.name().firstName();
            this.lastname = faker.name().lastName();
            this.username = faker.name().username();
            this.phone = faker.phoneNumber().phoneNumber();
            this.address = faker.address().streetAddress();
            this.country_id = faker.address().countryCode();
        }

        @Override
        public String toString() {
            return "{" +
                    "id:" + id +
                    ", name:'" + name + '\'' +
                    ", lastname:'" + lastname + '\'' +
                    ", username:'" + username + '\'' +
                    ", phone:'" + phone + '\'' +
                    ", address:'" + address + '\'' +
                    ", country_id:'" + country_id + '\'' +
                    '}';
        }
    }

    public static class ResetUserCredentials {
        private int id;
        private int organization_id;

        public ResetUserCredentials(int id) {
            this.id = id;
            this.organization_id = User.organization_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrganization_id() {
            return organization_id;
        }

        public void setOrganization_id(int organization_id) {
            this.organization_id = organization_id;
        }

        @Override
        public String toString() {
            return "{" +
                    "id:" + id +
                    ", organization_id:" + organization_id +
                    '}';
        }
    }

}


