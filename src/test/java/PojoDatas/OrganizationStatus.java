package PojoDatas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class OrganizationStatus {
    public OrganizationStatus(String name, String description, int... id) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    static int team_id;
    int[] id;
    String name;
    String description;

    public int[] getId() {
        return id;
    }
    public int get_team_id() {
        return team_id;
    }
    public int set_team_id() {
        return team_id;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {

        if(id.length>0){
            return "{"+
                    "id=" + id[0] +
                    "\"name\"=" + name + '\"' +
                    ", description='" + description + '\"' +
                    '}';
        }
        else {
            return
                    "{\n" +
                            "  \"name\":  \""+name+"\",\n" +
                            "  \"description\": \""+description+"\"\n" +
                            "}";
        }

    }

}
