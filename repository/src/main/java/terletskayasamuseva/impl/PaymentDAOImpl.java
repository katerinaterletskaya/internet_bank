package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.PaymentDAO;
import terletskayasamuseva.model.Payment;
import terletskayasamuseva.model.PaymentCategory;

import java.util.List;

@Repository
public class PaymentDAOImpl extends GenericDAOImpl<Payment, Long> implements PaymentDAO {

    private static final Logger logger = Logger.getLogger(PaymentDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<PaymentCategory> getAll() {
        return (List<PaymentCategory>) getSession().createQuery("from PaymentCategory").list();
    }
}