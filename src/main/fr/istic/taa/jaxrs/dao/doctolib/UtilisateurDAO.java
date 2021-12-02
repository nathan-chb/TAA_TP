package fr.istic.taa.jaxrs.dao.doctolib;

import fr.istic.taa.jaxrs.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UtilisateurDAO extends JpaRepository<Utilisateur, Utilisateur.UtilisateurPK> {
    public Utilisateur findOne(Utilisateur.UtilisateurPK userPK);
    public List<Utilisateur> findAll();
}
