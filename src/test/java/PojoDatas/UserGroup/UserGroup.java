package PojoDatas.UserGroup;

import PojoDatas.Role;
import PojoDatas.User2;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserGroup {

    private int id;
    private String name;
    private  String short_name;
    private String description;
    private String group_type_id;
    private  int pic_id;


    @Override
    public String toString() {
        return "{\"name\":\""+ name +"\",\"group_type_id\":"+group_type_id +",\"roles\":"+roles+"}";
    }

    public UserGroup(String name, String group_type_id, ArrayList<Role> roles) {
        this.name = name;
        this.group_type_id = group_type_id;
        this.roles = roles;
    }

    private int organization_id;
    private ArrayList<User2> users;
    private ArrayList<Role> roles;

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

    public String getGroup_type_id() {
        return group_type_id;
    }

    public void setGroup_type_id(String group_type_id) {
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
    public static class body{

        private String name;
        private  int group_type_id;
        private  ArrayList<Map<String,Integer>> roles;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGroup_type_id() {
            return group_type_id;
        }

        public void setGroup_type_id(int group_type_id) {
            this.group_type_id = group_type_id;
        }

        public ArrayList<Map<String, Integer>> getRoles() {
            return roles;
        }

        public void setRoles(ArrayList<Map<String, Integer>> roles) {
            this.roles = roles;
        }


        @Override
        public String toString() {
            return "body{" +
                    ", name='" + name + '\'' +
                    ", group_type_id=" + group_type_id +
                    ", roles=" + roles +
                    '}';
        }

        public body() {
        }

        public body( String name, int group_type_id, ArrayList<Map<String, Integer>> roles) {

            this.name = name;
            this.group_type_id = group_type_id;
            this.roles = roles;
        }
    }

}

