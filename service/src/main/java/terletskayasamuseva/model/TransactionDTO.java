package terletskayasamuseva.model;

import java.math.BigDecimal;
import java.sql.Date;


public class TransactionDTO {
    private Long id;
    private Date date;
    private String currency;
    private BigDecimal sum;
    private String toAccount;
    private String surname;

    public TransactionDTO() {
    }

    public TransactionDTO(String currency, BigDecimal sum, String toAccount, String surname) {
        this.currency = currency;
        this.sum = sum;
        this.toAccount = toAccount;
        this.surname = surname;
    }

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
