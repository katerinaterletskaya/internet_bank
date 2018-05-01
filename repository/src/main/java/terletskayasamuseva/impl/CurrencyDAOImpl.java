package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.CurrencyDAO;
import terletskayasamuseva.model.CurrencyKurs;

@Repository
public class CurrencyDAOImpl extends GenericDAOImpl<CurrencyKurs, Long> implements CurrencyDAO {
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
