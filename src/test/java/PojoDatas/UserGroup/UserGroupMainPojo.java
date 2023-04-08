package PojoDatas.UserGroup;

import java.util.ArrayList;
import java.util.Map;

public class UserGroupMainPojo {
    private Object id;
    private String name;
    private int group_type_id;
    Group_type Group_typeObject;
    private int organization_id;
    Organization OrganizationObject;
    static ArrayList<Object> users = new ArrayList<Object>();
    private  ArrayList<Map<String,Integer>> roles;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group_type_id=" + group_type_id +
                "," + Group_typeObject +
                ", organization_id=" + organization_id +
                ",=" + OrganizationObject +
                ", users=" + users +
                ", roles=" + roles +
                ", short_name='" + short_name + '\'' +
                '}';
    }

    private String short_name;

    public UserGroupMainPojo(Object id, String name, int group_type_id, Group_type group_typeObject, int organization_id, Organization organizationObject, ArrayList<Object> users, ArrayList<Map<String,Integer>> roles, String short_name) {
        this.id = id;
        this.name = name;
        this.group_type_id = group_type_id;
        Group_typeObject = group_typeObject;
        this.organization_id = organization_id;
        OrganizationObject = organizationObject;
        this.users = users;
        this.roles = roles;
        this.short_name = short_name;
    }

// Getter Methods

    public Object getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGroup_type_id() {
        return group_type_id;
    }

    public Group_type getGroup_type() {
        return Group_typeObject;
    }

    public int getOrganization_id() {
        return organization_id;
    }

    public Organization getOrganization() {
        return OrganizationObject;
    }

    public String getShort_name() {
        return short_name;
    }

    // Setter Methods

    public void setId( int id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setGroup_type_id( int group_type_id ) {
        this.group_type_id = group_type_id;
    }

    public void setGroup_type( Group_type group_typeObject ) {
        this.Group_typeObject = group_typeObject;
    }

    public void setOrganization_id( int organization_id ) {
        this.organization_id = organization_id;
    }

    public void setOrganization( Organization organizationObject ) {
        this.OrganizationObject = organizationObject;
    }

    public void setShort_name( String short_name ) {
        this.short_name = short_name;
    }

}
