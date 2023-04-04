package PojoDatas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserGroup {

    int id;
    String name;
    String short_name;
    String description;
    int group_type_id;
    int pic_id;
    int organization_id;
    ArrayList<User2> users;
    ArrayList<Role> roles;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGroup_type_id() {
        return group_type_id;
    }

    public void setGroup_type_id(int group_type_id) {
        this.group_type_id = group_type_id;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public ArrayList<User2> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User2> users) {
        this.users = users;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserGroups{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", description='" + description + '\'' +
                ", group_type_id=" + group_type_id +
                ", pic_id=" + pic_id +
                ", organization_id=" + organization_id +
                ", users=" + users +
                ", roles=" + roles +
                '}';
    }
}
