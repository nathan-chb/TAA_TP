package DAO;

import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<K, T extends Serializable> implements Dao<K,T>{

    protected Class<T> clazz;

    protected EntityManager entityManager;

    public GenericDAO(Class<T> clazzToSet){
        this.entityManager = EntityManagerHelper.getEntityManager();
        this.clazz = clazzToSet;
    }

    @Override
    public Serializable findOne(Object id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("select e from " + clazz.getName() + " as e",clazz).getResultList();
    }


    @Override
    public void save(T entity){
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        t.commit();
    }

    @Override
    public T update(final T entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        T res = entityManager.merge(entity);
        t.commit();
        return res;
    }

    @Override
    public void delete(Serializable entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();
    }
}
