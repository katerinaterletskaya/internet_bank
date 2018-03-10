package terletskayasamuseva.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Payment implements Serializable {

    private static final long serialVersionUID = 8381983683422723824L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(name = "payment_name", nullable = false, length = 100)
    private String name;
    @Column(name = "receiver_account", nullable = false, length = 34)
    private String receiverAccount;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @PrimaryKeyJoinColumn
    private PaymentCategory category;


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

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public PaymentCategory getCategory() {
        return category;
    }

    public void setCategory(PaymentCategory category) {
        this.category = category;
    }

}
