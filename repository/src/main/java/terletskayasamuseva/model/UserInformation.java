package terletskayasamuseva.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="user_information")
public class UserInformation implements Serializable {

    private static final long serialVersionUID = -4742145304571241489L;

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(nullable = false, length = 30)
    private String surname;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30)
    private String patronymic;
    @Column(name = "passport_number", nullable = false, length = 20)
    private String passportNumber;
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<Account> accounts;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<AccountRequest> requests;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private Collection<AccountRequest> requests;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private Collection<Credit> credits;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private Collection<Deposit> deposits;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }

//    public Collection<Payment> getPayments() {
//        return payments;
//    }
//
//    public void setPayments(Collection<Payment> payments) {
//        this.payments = payments;
//    }
//
//    public Collection<Credit> getCredits() {
//        return credits;
//    }
//
//    public void setCredits(Collection<Credit> credits) {
//        this.credits = credits;
//    }
//
//    public Collection<Deposit> getDeposits() {
//        return deposits;
//    }
//
//    public void setDeposits(Collection<Deposit> deposits) {
//        this.deposits = deposits;
//    }

    @Override
    public String toString() {
        return "UserInformation{" +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
