package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.AccountDAO;
import terletskayasamuseva.model.Account;


@Repository
public class AccountDAOImpl extends GenericDAOImpl<Account, Long> implements AccountDAO {
    private static final Logger logger = Logger.getLogger(AccountDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

}