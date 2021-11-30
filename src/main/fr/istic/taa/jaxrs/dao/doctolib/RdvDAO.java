package fr.istic.taa.jaxrs.dao.doctolib;


import fr.istic.taa.jaxrs.domain.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RdvDAO extends JpaRepository<Rdv, Long> {
    Rdv findOne(Long id);
    List<Rdv> findAll() ;
}
