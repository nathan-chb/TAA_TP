package DAO;

import java.io.Serializable;
import java.util.List;

public interface Dao<K, T extends Serializable> {
    T findOne(final K id);

    List<T> findAll();

    T update(final T entity);

    void save(final T entity);

    void delete(final T entity);
}
