package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.AccountDAO;
import terletskayasamuseva.OperationDAO;
import terletskayasamuseva.model.Account;
import terletskayasamuseva.model.AccountType;
import terletskayasamuseva.model.Currency;
import terletskayasamuseva.model.Operation;

import java.util.List;


@Repository
public class OperationDAOImpl extends GenericDAOImpl<Operation, Long> implements OperationDAO {
    private static final Logger logger = Logger.getLogger(OperationDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<Operation> getOperations(String number) {
        return (List<Operation>) getSession().createQuery("from Operation as o where o.account.number=:number")
                .setParameter("number", number).list();
    }
}