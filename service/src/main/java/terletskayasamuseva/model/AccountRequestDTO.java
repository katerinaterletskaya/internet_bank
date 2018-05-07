package terletskayasamuseva.model;

public class AccountRequestDTO {
    private Long id;
    private String telephone;
    private String type;
    private String currency;
    private Boolean status;
    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AccountRequestDTO{" +
                "id=" + id +
                ", telephone='" + telephone + '\'' +
                ", type='" + type + '\'' +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
