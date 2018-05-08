package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.CurrencyDAO;
import terletskayasamuseva.model.Currency;
import terletskayasamuseva.model.CurrencyKurs;

import java.math.BigDecimal;

@Repository
public class CurrencyDAOImpl extends GenericDAOImpl<CurrencyKurs, Long> implements CurrencyDAO {
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void changeCurrency(Currency currency, BigDecimal cost, BigDecimal sale) {
        CurrencyKurs currencyKurs = (CurrencyKurs) getSession().createQuery("from CurrencyKurs where currency=:currency")
                .setParameter("currency", currency).uniqueResult();
        getSession().update(currencyKurs);
        currencyKurs.setCost(cost);
        currencyKurs.setSale(sale);
    }
}
