package terletskayasamuseva.model;

import java.math.BigDecimal;

public class DepositDTO {
    private Long id;
    private String name;
    private String currency;
    private BigDecimal minSum;
    private Float percent;
    private Integer period;
    private Boolean isReversal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getMinSum() {
        return minSum;
    }

    public void setMinSum(BigDecimal minSum) {
        this.minSum = minSum;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Boolean getReversal() {
        return isReversal;
    }

    public void setReversal(Boolean reversal) {
        isReversal = reversal;
    }

    @Override
    public String toString() {
        return "DepositDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", minSum=" + minSum +
                ", percent=" + percent +
                ", period=" + period +
                ", isReversal=" + isReversal +
                '}';
    }
}
