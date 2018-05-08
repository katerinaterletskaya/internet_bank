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

import java.math.BigDecimal;
import java.util.List;


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
    public List<Account> getAccountForUser(String username, AccountType type) {
        return getSession().createQuery("from Account as a where a.accountType=:type and a.user.user.login=:username")
                .setParameter("type", type).setParameter("username", username).list();
    }

    @Override
    public List<String> getCurrentAccountForUser(String passport) {
        return (List<String>) getSession().createQuery("select a.number from Account as a where a.accountType=:type and a.user.passportNumber=:passport")
                .setParameter("type", AccountType.CURRENT).setParameter("passport", passport).list();
    }

    @Override
    public List<Account> getCurrentAccountForUserWithName(String username) {
        return (List<Account>) getSession().createQuery("from Account as a where a.accountType=:type and a.user.user.login=:username")
                .setParameter("type", AccountType.CURRENT).setParameter("username", username).list();
    }

    @Override
    public Account getCurrentAccountByNumber(String number) {
        return (Account) getSession().createQuery("from Account as a where a.number=:number")
                .setParameter("number", number).uniqueResult();
    }

    @Override
    public void updateSum(String number, BigDecimal sum) {
        Account account = (Account) getSession().createQuery("from Account as a where a.number=:number")
                .setParameter("number", number).uniqueResult();
        getSession().update(account);
        account.setSum(sum);
    }
}