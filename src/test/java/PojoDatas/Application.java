package PojoDatas;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

    int id;
    String name;
    String short_name;
    String description;
    String base_uri;
    String domain_name;
    String environment;
    int default_membership_type_id;
    boolean is_enabled;
    boolean is_subscription_required;
    boolean is_self_registration_enabled;
    boolean is_password_recovery_enabled;
    boolean is_external_idp_login_enabled;
    boolean is_mfa_enabled;
    String subscription_path;
    String login_path;
    int logo_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBase_uri() {
        return base_uri;
    }

    public void setBase_uri(String base_uri) {
        this.base_uri = base_uri;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getDefault_membership_type_id() {
        return default_membership_type_id;
    }

    public void setDefault_membership_type_id(int default_membership_type_id) {
        this.default_membership_type_id = default_membership_type_id;
    }

    public boolean isIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean is_enabled) {
        this.is_enabled = is_enabled;
    }

    public boolean isIs_subscription_required() {
        return is_subscription_required;
    }

    public void setIs_subscription_required(boolean is_subscription_required) {
        this.is_subscription_required = is_subscription_required;
    }

    public boolean isIs_self_registration_enabled() {
        return is_self_registration_enabled;
    }

    public void setIs_self_registration_enabled(boolean is_self_registration_enabled) {
        this.is_self_registration_enabled = is_self_registration_enabled;
    }

    public boolean isIs_password_recovery_enabled() {
        return is_password_recovery_enabled;
    }

    public void setIs_password_recovery_enabled(boolean is_password_recovery_enabled) {
        this.is_password_recovery_enabled = is_password_recovery_enabled;
    }

    public boolean isIs_external_idp_login_enabled() {
        return is_external_idp_login_enabled;
    }

    public void setIs_external_idp_login_enabled(boolean is_external_idp_login_enabled) {
        this.is_external_idp_login_enabled = is_external_idp_login_enabled;
    }

    public boolean isIs_mfa_enabled() {
        return is_mfa_enabled;
    }

    public void setIs_mfa_enabled(boolean is_mfa_enabled) {
        this.is_mfa_enabled = is_mfa_enabled;
    }

    public String getSubscription_path() {
        return subscription_path;
    }

    public void setSubscription_path(String subscription_path) {
        this.subscription_path = subscription_path;
    }

    public String getLogin_path() {
        return login_path;
    }

    public void setLogin_path(String login_path) {
        this.login_path = login_path;
    }

    public int getLogo_id() {
        return logo_id;
    }

    public void setLogo_id(int logo_id) {
        this.logo_id = logo_id;
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
        return "Applications{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", description='" + description + '\'' +
                ", base_uri='" + base_uri + '\'' +
                ", domain_name='" + domain_name + '\'' +
                ", environment='" + environment + '\'' +
                ", default_membership_type_id=" + default_membership_type_id +
                ", is_enabled=" + is_enabled +
                ", is_subscription_required=" + is_subscription_required +
                ", is_self_registration_enabled=" + is_self_registration_enabled +
                ", is_password_recovery_enabled=" + is_password_recovery_enabled +
                ", is_external_idp_login_enabled=" + is_external_idp_login_enabled +
                ", is_mfa_enabled=" + is_mfa_enabled +
                ", subscription_path='" + subscription_path + '\'' +
                ", login_path='" + login_path + '\'' +
                ", logo_id=" + logo_id +
                ", created_at='" + created_at + '\'' +
                ", created_by=" + created_by +
                ", updated_at='" + updated_at + '\'' +
                ", updated_by=" + updated_by +
                '}';
    }
}
