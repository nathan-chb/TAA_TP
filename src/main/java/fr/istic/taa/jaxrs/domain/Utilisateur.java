package fr.istic.taa.jaxrs.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
* @generated
*/
@Entity
public class Utilisateur {

    @Embeddable
    public static class UtilisateurPK implements Serializable {
        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        protected String nom;
        protected String prenom;

        public UtilisateurPK() {}

        public UtilisateurPK(String prenom, String nom) {
            this.prenom = prenom;
            this.nom = nom;
        }
    }

    private UtilisateurPK utilisateurPK;

    @EmbeddedId
    public UtilisateurPK getUtilisateurPK() {
        return utilisateurPK;
    }

    public void setUtilisateurPK(UtilisateurPK utilisateurPK) {
        this.utilisateurPK = utilisateurPK;
    }
    
    /**
    * @generated
    */
    private boolean loggedIn;
    
    
    /**
    * @generated
    */
    @OneToMany(mappedBy = "utilisateur")
    private Set<Rdv> rdv;
    
    /**
    * @generated
    */
    private Compte compte;
    

    /**
    * @generated
    */
    public boolean getLoggedIn() {
        return this.loggedIn;
    }
    
    /**
    * @generated
    */
    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    
    
    /**
    * @generated
    */
    @OneToMany (mappedBy = "utilisateur")
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
    
    
    /**
    * @generated
    */
    @OneToOne(mappedBy = "utilisateur")
    public Compte getCompte() {
        return this.compte;
    }
    
    /**
    * @generated
    */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public Compte creerCompte() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public boolean logIn() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    public boolean logOut() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    public boolean bookCreneaux() {
        //TODO
        return false;
    }
    
    
}
