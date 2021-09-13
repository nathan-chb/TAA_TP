package DAO;

import jpa.EntityManagerHelper;
import model.Rdv;
import model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UtilisateurDAO {

    protected EntityManager entityManager;

    public UtilisateurDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Utilisateur findOne(Object id) {
        return entityManager.find(Utilisateur.class, id);
    }

    public List<Utilisateur> findAll() {
        return entityManager.createQuery("select e from " + Utilisateur.class.getName() + " as e",Utilisateur.class).getResultList();
    }

    public void save(Utilisateur entity){
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        t.commit();
    }

    public Utilisateur update(final Utilisateur entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        Utilisateur res = entityManager.merge(entity);
        t.commit();
        return res;
    }

    public void delete(Utilisateur entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();
    }

}
