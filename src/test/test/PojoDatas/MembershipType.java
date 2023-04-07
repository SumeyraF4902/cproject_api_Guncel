package PojoDatas;

import java.util.ArrayList;

public class MembershipType {


    int id;
    String name;
    String short_name;
    boolean is_enabled;
    boolean is_individual_plan;
    int default_role_id;
    int subscription_type_id;
    int app_id;
    ArrayList<Role> roles;
    String created_at;
    int created_by;
    String updated_at;
    int updated_by;

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

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public boolean isIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean is_enabled) {
        this.is_enabled = is_enabled;
    }

    public boolean isIs_individual_plan() {
        return is_individual_plan;
    }

    public void setIs_individual_plan(boolean is_individual_plan) {
        this.is_individual_plan = is_individual_plan;
    }

    public int getDefault_role_id() {
        return default_role_id;
    }

    public void setDefault_role_id(int default_role_id) {
        this.default_role_id = default_role_id;
    }

    public int getSubscription_type_id() {
        return subscription_type_id;
    }

    public void setSubscription_type_id(int subscription_type_id) {
        this.subscription_type_id = subscription_type_id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
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

    @Override
    public String toString() {
        return "MembershipType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", is_enabled=" + is_enabled +
                ", is_individual_plan=" + is_individual_plan +
                ", default_role_id=" + default_role_id +
                ", subscription_type_id=" + subscription_type_id +
                ", app_id=" + app_id +
                ", roles=" + roles +
                ", created_at='" + created_at + '\'' +
                ", created_by=" + created_by +
                ", updated_at='" + updated_at + '\'' +
                ", updated_by=" + updated_by +
                '}';
    }
}
