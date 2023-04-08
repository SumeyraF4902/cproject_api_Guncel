package PojoDatas.UserGroup;

public class Organization {
    private int id;
    private String name;
    private int founder_id;
    private String short_name;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String fax;
    private int status_id;
    private String created_at;
    private String updated_at;


    // Getter Methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFounder_id() {
        return founder_id;
    }

    public String getShort_name() {
        return short_name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getFax() {
        return fax;
    }

    public int getStatus_id() {
        return status_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    // Setter Methods

    public void setId( int id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setFounder_id( int founder_id ) {
        this.founder_id = founder_id;
    }

    public void setShort_name( String short_name ) {
        this.short_name = short_name;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public Organization(int id, String name, int founder_id, String short_name, String address, String phone, String email, String website, String fax, int status_id, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.founder_id = founder_id;
        this.short_name = short_name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.fax = fax;
        this.status_id = status_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void setWebsite(String website ) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", founder_id=" + founder_id +
                ", short_name='" + short_name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", fax='" + fax + '\'' +
                ", status_id=" + status_id +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
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
