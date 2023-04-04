package PojoDatas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Permission {


    int id;
    String resource;
    String action;
    int app_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", app_id=" + app_id +
                '}';
    }
}
