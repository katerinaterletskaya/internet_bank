package terletskayasamuseva.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyKursDTO implements Serializable {
    private static final long serialVersionUID = 4294120970426617943L;

    private Long id;
    private String currency;
    private BigDecimal sale;
    private BigDecimal cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
