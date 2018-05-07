package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.AccountDAO;
import terletskayasamuseva.model.Account;
import terletskayasamuseva.model.AccountType;
import terletskayasamuseva.model.Currency;
import terletskayasamuseva.model.UserInformation;


@Repository
public class AccountDAOImpl extends GenericDAOImpl<Account, Long> implements AccountDAO {
    private static final Logger logger = Logger.getLogger(AccountDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public String getLastNumberCurrentAccount(AccountType type, Currency currency) {
        Long result = (Long) getSession().createQuery("select max(id) from Account where currency=:currency and accountType=:type")
                .setParameter("currency", currency)
                .setParameter("type", type).uniqueResult();
        return (String) getSession().createQuery("select number from Account where id=:id")
                .setParameter("id", result).uniqueResult();
    }

    @Override
    public void addNewAccount(Account account, String passport) {
        UserInformation info = (UserInformation) getSession().createQuery("from UserInformation where passportNumber=:passport")
                .setParameter("passport", passport).uniqueResult();
        getSession().update(info);
        info.addAccount(account);
    }
}