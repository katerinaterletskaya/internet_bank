package terletskayasamuseva.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AccountRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id", unique = true, nullable = false)
    private Long id;
    @Column(nullable = false, length = 20)
    private String telephone;
    @Column(nullable = false)
    private AccountType type;
    @Column(nullable = false)
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @PrimaryKeyJoinColumn
    private UserInformation user;


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

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UserInformation getUser() {
        return user;
    }

    public void setUser(UserInformation user) {
        this.user = user;
    }
}
