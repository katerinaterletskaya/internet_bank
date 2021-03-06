package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.DepositDAO;
import terletskayasamuseva.model.Deposit;

import java.util.Collection;
import java.util.List;


@Repository
public class DepositDAOImpl extends GenericDAOImpl<Deposit, Long> implements DepositDAO {
    private static final Logger logger = Logger.getLogger(DepositDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Deposit getDepositByParameter(Deposit deposit) {
        return (Deposit) getSession().createQuery("from Deposit where currency=:currency and period=:period and minSum<=:sum")
                .setParameter("currency", deposit.getCurrency())
                .setParameter("period", deposit.getPeriod())
                .setParameter("sum", deposit.getMinSum()).uniqueResult();
    }

    @Override
    public Deposit getDepositByName(String name) {
        return (Deposit) getSession().createQuery("from Deposit where name=:name")
                .setParameter("name", name).uniqueResult();
    }
}