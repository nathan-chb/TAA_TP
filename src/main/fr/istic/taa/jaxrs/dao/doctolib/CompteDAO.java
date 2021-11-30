package fr.istic.taa.jaxrs.dao.doctolib;


import fr.istic.taa.jaxrs.domain.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CompteDAO extends JpaRepository<Compte, String> {
    public Compte findOne(String mail);
    public List<Compte> findAll();
}
