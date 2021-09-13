package jpa;

import DAO.CompteDAO;
import DAO.GenericDAO;
import DAO.ProfessionelDAO;
import model.Compte;
import model.Professionel;
import model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		try {
			ProfessionelDAO professionelDAO = new ProfessionelDAO(manager);
			Professionel bernard = new Professionel();
			bernard.setUtilisateurPK(new Utilisateur.UtilisateurPK("norman","bernard"));
			professionelDAO.save(bernard);

			for (Professionel i : professionelDAO.findAll()){
				System.out.println(i.getUtilisateurPK().getPrenom());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		manager.close();
		factory.close();
	}

}
