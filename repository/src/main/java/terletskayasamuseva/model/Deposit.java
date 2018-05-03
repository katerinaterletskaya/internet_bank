package terletskayasamuseva.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Deposit implements Serializable {
    private static final long serialVersionUID = 8561295874381580354L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(name = "deposit_name", nullable = false, length = 30)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column
    private Currency currency;
    @Column(name = "min_sum", nullable = false)
    private BigDecimal minSum;
    @Column(nullable = false)
    private Float percent;
    @Column(nullable = false)
    private Integer period;
    @Type(type = "yes_no")
    @Column(name = "is_reversal", nullable = false)
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
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
        return "Deposit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currency=" + currency +
                ", minSum=" + minSum +
                ", percent=" + percent +
                ", period=" + period +
                ", isReversal=" + isReversal +
                '}';
    }
}
