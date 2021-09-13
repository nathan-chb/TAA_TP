package DAO;

import jpa.EntityManagerHelper;
import model.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public class CompteDAO {

    protected EntityManager entityManager;

    public CompteDAO(){
        this.entityManager = EntityManagerHelper.getEntityManager();
    }

    public Compte findOne(Object id) {
        return entityManager.find(Compte.class, id);
    }

    public List<Compte> findAll() {
        return entityManager.createQuery("select e from " + Compte.class.getName() + " as e",Compte.class).getResultList();
    }

    public void save(Compte entity){
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        t.commit();
    }

    public Compte update(final Compte entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        Compte res = entityManager.merge(entity);
        t.commit();
        return res;
    }

    public void delete(Compte entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();
    }
}
