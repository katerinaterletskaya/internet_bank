package terletskayasamuseva.impl;

import org.springframework.stereotype.Repository;
import terletskayasamuseva.PaymentDAO;
import terletskayasamuseva.model.Payment;

@Repository
public class PaymentDAOImpl extends GenericDAOImpl<Payment, Long> implements PaymentDAO {

}