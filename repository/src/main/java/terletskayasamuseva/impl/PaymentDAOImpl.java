package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.PaymentDAO;
import terletskayasamuseva.UserDAO;
import terletskayasamuseva.model.Payment;
import terletskayasamuseva.model.User;
import terletskayasamuseva.model.UserInformation;


@Repository
public class PaymentDAOImpl extends GenericDAOImpl<Payment, Long> implements PaymentDAO {

}
