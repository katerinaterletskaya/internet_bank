package terletskayasamuseva.model;

import java.math.BigDecimal;
import java.sql.Date;

public class OperationDTO {

    private Long id;
    private Date date;
    private String currency;
    private BigDecimal sum;
    private String account;
    private String paymentCategory;
    private Long payment;
    private String paymentName;


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

    public String  getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    @Override
    public String toString() {
        return "OperationDTO{" +
                "id=" + id +
                ", date=" + date +
                ", currency='" + currency + '\'' +
                ", sum=" + sum +
                ", account='" + account + '\'' +
                ", paymentCategory='" + paymentCategory + '\'' +
                ", payment=" + payment +
                '}';
    }
}
