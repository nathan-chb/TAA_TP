package DAO;

import jpa.EntityManagerHelper;
import model.Professionel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProfessionelDAO {

    protected EntityManager entityManager;

    public ProfessionelDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Professionel findOne(Object id) {
        return entityManager.find(Professionel.class, id);
    }

    public List<Professionel> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Professionel> q = cb.createQuery(Professionel.class);
        return entityManager.createQuery("select e from " + Professionel.class.getName() + " as e",Professionel.class).getResultList();
    }

    public void save(Professionel entity){
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        t.commit();
    }

    public Professionel update(final Professionel entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        Professionel res = entityManager.merge(entity);
        t.commit();
        return res;
    }

    public void delete(Professionel entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();
    }
}
