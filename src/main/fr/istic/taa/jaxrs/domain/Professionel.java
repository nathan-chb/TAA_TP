package fr.istic.taa.jaxrs.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
* @generated
*/
@Entity
@Data
@NamedQuery(name = "Professionel.findOne", query = "FROM Professionel u WHERE u.utilisateurPK = ?1")
@NamedQuery(name = "Professionel.findAll", query = "SELECT e FROM Professionel e")
public class Professionel extends Utilisateur {

    
    /**
    * @generated
    */
    private Set<Rdv> rdv;
    
    /**
    * @generated
    */
    @OneToMany(mappedBy = "professionel")
    public Set<Rdv> getRdv() {
        if (this.rdv == null) {
            this.rdv = new HashSet<Rdv>();
        }
        return this.rdv;
    }
    
    /**
    * @generated
    */
    public void setRdv(Set<Rdv> rdv) {
        this.rdv = rdv;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public String giveCreneaux() {
        Rdv creneau = new Rdv();
        return "";
    }
    
    /**
    * @generated
    */
    public boolean defineDuration() {
        //TODO
        return false;
    }
    
    
}
