package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.AccountRequestDAO;
import terletskayasamuseva.DepositDAO;
import terletskayasamuseva.model.AccountRequest;
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

}