package terletskayasamuseva;

import java.io.Serializable;
import java.util.Collection;

public interface GenericDAO<T extends Serializable, ID extends Serializable> {
    ID add(T entity);
    void saveOrUpdate(T entity);
    void delete(T entity);
    void deleteAll();
    Collection<T> findAll();
    T findById(ID id);
}
