package terletskayasamuseva.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyKursDTO implements Serializable {
    private static final long serialVersionUID = 4294120970426617943L;

    private Long id;
    private String currency;
    private Float sale;
    private Float cost;

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

    public Float getSale() {
        return sale;
    }

    public void setSale(Float sale) {
        this.sale = sale;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
