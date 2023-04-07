package PojoDatas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserBuilder {

    int id;
    String name;
    String lastname;
    String username;
    String email;
    boolean is_email_verified;
    String phone;
    String address;
    String country_id;
    int pic_id;
    int status_id;
    String created_at;
    String updated_at;
    int updated_by;
    UserStatus UserStatus;
    int organization_id;
    int app_id;
    int membership_type_id;
    int default_role_id;
    String subscription_id;
    boolean is_individual_membership;
    String password;
    Map<String, String> country;
    ArrayList<Application> applications;
    ArrayList<Organization> organizations;
    ArrayList<Role> roles;
    ArrayList<UserGroup> user_groups;






    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }


    public UserBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }


    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }



    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }


    public UserBuilder setIs_email_verified(boolean is_email_verified) {
        this.is_email_verified = is_email_verified;
        return this;
    }


    public UserBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }


    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    public UserBuilder setCountry_id(String country_id) {
        this.country_id = country_id;
        return this;
    }


    public UserBuilder setPic_id(int pic_id) {
        this.pic_id = pic_id;
        return this;
    }


    public UserBuilder setStatus_id(int status_id) {
        this.status_id = status_id;
        return this;
    }


    public UserBuilder setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }


    public UserBuilder setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }


    public UserBuilder setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
        return this;
    }


    public UserBuilder setStatus(UserStatus UserStatus) {
        this.UserStatus = UserStatus;
        return this;
    }



    public UserBuilder setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
        return this;
    }



    public UserBuilder setApp_id(int app_id) {
        this.app_id = app_id;
        return this;
    }



    public UserBuilder setMembership_type_id(int membership_type_id) {
        this.membership_type_id = membership_type_id;
        return this;
    }

    public UserBuilder setDefault_role_id(int default_role_id) {
        this.default_role_id = default_role_id;
        return this;
    }


    public UserBuilder setSubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
        return this;
    }



    public UserBuilder setIs_individual_membership(boolean is_individual_membership) {
        this.is_individual_membership = is_individual_membership;
        return this;
    }


    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }




    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }





    public UserBuilder setCountry(Map<String, String> country) {
        this.country = country;
        return this;
    }



    public UserBuilder setOrganizations(ArrayList<Organization> organizations) {
        this.organizations = organizations;
        return this;
    }



    public UserBuilder setUser_groups(ArrayList<UserGroup> user_groups) {
        this.user_groups = user_groups;
        return this;
    }



    public UserBuilder setRoles(ArrayList<Role> roles) {
        this.roles = roles;
        return this;
    }



    public UserBuilder setApplications(ArrayList<Application> applications) {
        this.applications = applications;
        return this;
    }



    public UserBuilder setUserStatus(UserStatus UserStatus) {
        this.UserStatus = UserStatus;
        return this;
    }




public User build(){
    return new User(id, name,lastname,username,email,is_email_verified,phone,address,country_id,pic_id,status_id,created_at,updated_at
            ,updated_by, UserStatus,organization_id,app_id,membership_type_id,default_role_id,subscription_id,is_individual_membership
            ,password, country,organizations,applications,roles,user_groups);

}


}

