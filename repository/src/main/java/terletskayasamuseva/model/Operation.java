package terletskayasamuseva.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Operation implements Serializable {
    private static final long serialVersionUID = 7081550263060569484L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private Date date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;
    @Column(nullable = false)
    private BigDecimal sum;
    @Column(name = "card_number", length = 16)
    private String cardNumber;
    @ManyToOne
    @JoinColumn(name = "account_id")
    @PrimaryKeyJoinColumn
    private Account account;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
