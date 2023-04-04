package PojoDatas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Role {

    int role_id;
    String name;
    int app_id;
    String descriptions;
    ArrayList<Permission> permissions;
    String subscription_id;
    boolean is_default;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public ArrayList<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "role_id=" + role_id +
                ", name='" + name + '\'' +
                ", app_id=" + app_id +
                ", descriptions='" + descriptions + '\'' +
                ", permissions=" + permissions +
                ", subscription_id='" + subscription_id + '\'' +
                ", is_default=" + is_default +
                '}';
    }
}
