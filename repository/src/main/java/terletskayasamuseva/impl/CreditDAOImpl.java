package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.CreditDAO;
import terletskayasamuseva.model.Credit;

@Repository
public class CreditDAOImpl extends GenericDAOImpl<Credit, Long> implements CreditDAO {
    private static final Logger logger = Logger.getLogger(CreditDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Credit getCreditByName(String name) {
        return (Credit) getSession().createQuery("from Credit where name=:name")
                .setParameter("name", name).uniqueResult();
    }
}
