package PojoDatas.UserGroup;

public class Organization {
    private int id;
    private String name;
    private int founder_id;
    private String short_name;


    private String created_at;
    private String updated_at;


    public int getId() {
        return id;
    }


    public Organization(int id, String name, int founder_id, String short_name, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.founder_id = founder_id;
        this.short_name = short_name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", founder_id=" + founder_id +
                ", short_name='" + short_name + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
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

    public int getFounder_id() {
        return founder_id;
    }

    public void setFounder_id(int founder_id) {
        this.founder_id = founder_id;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;

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
}


    public void setFax(String fax ) {
        this.fax = fax;
    }

    public void setStatus_id( int status_id ) {
        this.status_id = status_id;
    }

    public void setCreated_at( String created_at ) {
        this.created_at = created_at;
    }

    public void setUpdated_at( String updated_at ) {
        this.updated_at = updated_at;
    }
}

