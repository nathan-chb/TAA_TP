package DAO;

import jpa.EntityManagerHelper;
import model.Professionel;
import model.Rdv;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class RdvDAO {

    protected EntityManager entityManager;

    public RdvDAO(){
        this.entityManager = EntityManagerHelper.getEntityManager();
    }

    public Rdv findOne(Object id) {
        return entityManager.find(Rdv.class, id);
    }

    public List<Rdv> findAll() {
        return entityManager.createQuery("select e from " + Rdv.class.getName() + " as e",Rdv.class).getResultList();
    }

    public void save(Rdv entity){
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        t.commit();
    }

    public Rdv update(final Rdv entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        Rdv res = entityManager.merge(entity);
        t.commit();
        return res;
    }

    public void delete(Rdv entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();
    }
}
