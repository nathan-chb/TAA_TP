package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
* @generated
*/
@Entity
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
        //TODO
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
