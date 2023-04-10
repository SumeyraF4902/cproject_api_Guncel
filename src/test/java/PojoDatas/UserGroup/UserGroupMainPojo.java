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




    public UserGroupMainPojo(Object id, String name, int group_type_id, Group_type group_typeObject, int organization_id, Organization organizationObject, ArrayList<Map<String,Integer>> roles, String short_name) {

        this.id = id;
        this.name = name;
        this.group_type_id = group_type_id;
        Group_typeObject = group_typeObject;
        this.organization_id = organization_id;
        OrganizationObject = organizationObject;



}
