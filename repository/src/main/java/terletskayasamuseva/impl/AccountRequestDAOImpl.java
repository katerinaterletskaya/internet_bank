package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.AccountRequestDAO;
import terletskayasamuseva.DepositDAO;
import terletskayasamuseva.model.AccountRequest;
import terletskayasamuseva.model.AccountType;
import terletskayasamuseva.model.Deposit;

import java.util.List;


@Repository
public class AccountRequestDAOImpl extends GenericDAOImpl<AccountRequest, Long> implements AccountRequestDAO {
    private static final Logger logger = Logger.getLogger(AccountRequestDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<AccountRequest> getRequestForAccount() {
        List<AccountRequest> orders = getSession().createQuery("from AccountRequest as a where a.type=:type")
                .setParameter("type", AccountType.CURRENT).list();
        return orders;
    }

    @Override
    public List<AccountRequest> getRequestForDeposit() {
        List<AccountRequest> orders = getSession().createQuery("from AccountRequest as a where a.type=:type")
                .setParameter("type", AccountType.DEPOSIT).list();
        return orders;
    }

    @Override
    public List<AccountRequest> getRequestForCredit() {
        List<AccountRequest> orders = getSession().createQuery("from AccountRequest as a where a.type=:type")
                .setParameter("type", AccountType.CREDIT).list();
        return orders;
    }

    @Override
    public void changeAccountRequestStatus(AccountRequest accountRequest) {
        AccountRequest newAccountRequest = (AccountRequest) getSession().createQuery("from AccountRequest as a " +
                "where a.type=:type and a.telephone=:telephone and a.status=:status")
                .setParameter("type", accountRequest.getType())
                .setParameter("telephone", accountRequest.getTelephone())
                .setParameter("status", accountRequest.getStatus())
                .uniqueResult();
        getSession().update(newAccountRequest);
        newAccountRequest.setStatus(true);
    }

    @Override
    public void changeAccountRequestStatusFromCurrentAccount(AccountRequest accountRequest) {
        AccountRequest newAccountRequest = (AccountRequest) getSession().createQuery("from AccountRequest as a " +
                "where a.type=:type and a.currency=:currency and a.status=:status")
                .setParameter("type", accountRequest.getType())
                .setParameter("currency", accountRequest.getCurrency())
                .setParameter("status", accountRequest.getStatus())
                .uniqueResult();
        getSession().update(newAccountRequest);
        newAccountRequest.setStatus(true);
    }
}