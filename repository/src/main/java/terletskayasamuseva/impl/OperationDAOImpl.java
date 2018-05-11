package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.AccountDAO;
import terletskayasamuseva.OperationDAO;
import terletskayasamuseva.model.*;

import java.sql.Date;
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

    @Override
    public Long saveTransaction(Transaction entity) {
        return (Long) getSession().save(entity);
    }

    @Override
    public List<Operation> getOperationWithParameter(Date firstDate, Date secondDate, String numberAccount) {
        return (List<Operation>) getSession().createQuery("from Operation as o where o.account.number=:number and o.date>=:firstDate and o.date<=:secondDate")
                .setParameter("number", numberAccount)
                .setParameter("firstDate", firstDate)
                .setParameter("secondDate", secondDate).list();
    }

    @Override
    public List<Operation> getOperationForThisDay(Date date, String numberAccount) {
        return (List<Operation>) getSession().createQuery("from Operation as o where o.account.number=:number and o.date=:date")
                .setParameter("number", numberAccount)
                .setParameter("date", date).list();
    }

    @Override
    public List<Operation> getOperationAfterDay(Date date, String numberAccount) {
        return (List<Operation>) getSession().createQuery("from Operation as o where o.account.number=:number and o.date>=:date")
                .setParameter("number", numberAccount)
                .setParameter("date", date).list();
    }

    @Override
    public List<Operation> getOperationUtilDay(Date date, String numberAccount) {
        return (List<Operation>) getSession().createQuery("from Operation as o where o.account.number=:number and o.date<=:date")
                .setParameter("number", numberAccount)
                .setParameter("date", date).list();
    }

    @Override
    public List<Transaction> getTransactionWithParameter(Date firstDate, Date secondDate, String numberAccount) {
        return (List<Transaction>) getSession().createQuery("from Transaction as t where t.account.number=:number and o.date>=:firstDate and t.date<=:secondDate")
                .setParameter("number", numberAccount)
                .setParameter("firstDate", firstDate)
                .setParameter("secondDate", secondDate).list();
    }

    @Override
    public List<Transaction> getTransactionForThisDay(Date date, String numberAccount) {
        return (List<Transaction>) getSession().createQuery("from Transaction as t where t.account.number=:number and t.date=:date")
                .setParameter("number", numberAccount)
                .setParameter("date", date).list();
    }

    @Override
    public List<Transaction> getTransactionAfterDay(Date date, String numberAccount) {
        return (List<Transaction>) getSession().createQuery("from Transaction as t where t.account.number=:number and t.date>=:date")
                .setParameter("number", numberAccount)
                .setParameter("date", date).list();
    }

    @Override
    public List<Transaction> getTransactionUtilDay(Date date, String numberAccount) {
        return (List<Transaction>) getSession().createQuery("from Transaction as t where t.account.number=:number and t.date<=:date")
                .setParameter("number", numberAccount)
                .setParameter("date", date).list();
    }

    @Override
    public List<Transaction> getAllTransaction(String numberAccount) {
        return (List<Transaction>) getSession().createQuery("from Transaction as t where t.account.number=:number")
                .setParameter("number", numberAccount).list();
    }
}