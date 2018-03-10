package terletskayasamuseva.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import terletskayasamuseva.GenericDAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAOImpl<T extends Serializable, ID extends Serializable> implements GenericDAO<T, ID> {
    private final Class<T> entityClass;

    public GenericDAOImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public ID add(T entity) {
        return (ID) getSession().save(entity);
    }

    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void deleteAll() {
        List<T> entities = findAll();
        for (T entity : entities) {
            getSession().delete(entity);
        }
    }


    public List<T> findAll() {
        return getSession().createQuery("from " + this.entityClass.getName()).list();
    }

    public T findById(final ID id) {
        return (T) getSession().get(this.entityClass, id);
    }
}

