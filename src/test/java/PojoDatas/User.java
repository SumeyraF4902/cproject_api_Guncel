package PojoDatas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    int id;
    String name;
    String lastname;
    String username;
    String email;
    boolean is_email_verified;
    String phone;
    String address;
    String country_id;
    Map<String, String> country;//???????
    ArrayList<Organization> organizations;
    ArrayList<UserGroup> user_groups;
    ArrayList<Role> roles;
    ArrayList<Application> applications;

    int pic_id;
    int status_id;
    String created_at;
    String updated_at;
    int updated_by;
    UserStatus UserStatus;
    int organization_id;
    String app_id;
    int membership_type_id;
    int default_role_id;
    String subscription_id;
    boolean is_individual_membership;
    String password;

    public User(){

    }

    public User(int id, String name, String lastname, String username, String email, boolean is_email_verified, String phone, String address, String country_id, int pic_id, int status_id, String created_at, String updated_at, int updated_by, PojoDatas.UserStatus userStatus, int organization_id, int app_id, int membership_type_id, int default_role_id, String subscription_id, boolean is_individual_membership, String password, Map<String, String> country, ArrayList<Organization> organizations, ArrayList<Application> applications, ArrayList<Role> roles, ArrayList<UserGroup> user_groups) {
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

    public Map<String, String> getCountry() {
        return country;
    }

    public void setCountry(Map<String, String> country) {
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
        return UserStatus;
    }

    public void setUserStatus(UserStatus UserStatus) {
        this.UserStatus = UserStatus;
    }

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
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

    public void setSubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
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
                ", statusPOJO=" + UserStatus +
                ", organization_id=" + organization_id +
                ", app_id='" + app_id + '\'' +
                ", membership_type_id=" + membership_type_id +
                ", default_role_id=" + default_role_id +
                ", subscription_id=" + subscription_id +
                ", is_individual_membership=" + is_individual_membership +
                ", password='" + password + '\'' +
                '}';
    }
}

