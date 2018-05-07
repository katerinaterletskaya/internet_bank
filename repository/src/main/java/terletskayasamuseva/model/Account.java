package terletskayasamuseva.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = -3723896551814857153L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", unique = true, nullable = false)
    private Long id;
    @Column(name = "account_number", nullable = false, length = 28)
    private String number;
    @Column(name = "data_open")
    private Date dataOpen;
    @Column(name = "data_close")
    private Date dataClose;
    @Column
    private BigDecimal sum;
    @Enumerated(EnumType.STRING)
    @Column
    private Currency currency;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDataOpen() {
        return dataOpen;
    }

    public void setDataOpen(Date dataOpen) {
        this.dataOpen = dataOpen;
    }

    public Date getDataClose() {
        return dataClose;
    }

    public void setDataClose(Date dataClose) {
        this.dataClose = dataClose;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public UserInformation getUser() {
        return user;
    }

    public void setUser(UserInformation user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", dataOpen=" + dataOpen +
                ", dataClose=" + dataClose +
                ", sum=" + sum +
                ", currency=" + currency +
                ", accountType=" + accountType +
                '}';
    }
}
