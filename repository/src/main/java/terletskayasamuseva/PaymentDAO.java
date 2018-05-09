package terletskayasamuseva;

import terletskayasamuseva.model.Payment;
import terletskayasamuseva.model.PaymentCategory;

import java.util.List;

public interface PaymentDAO extends GenericDAO<Payment, Long>{
    List<PaymentCategory> getAll();
}
