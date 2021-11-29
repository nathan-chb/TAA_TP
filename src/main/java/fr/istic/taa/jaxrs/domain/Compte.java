package fr.istic.taa.jaxrs.domain;


/**
* @generated
*/

import javax.persistence.*;

@Entity
public
class Compte {

    private String addresseMail;

    @Id
    public String getAddresseMail() {
        return addresseMail;
    }

    public void setAddresseMail(String addresseMail) {
        this.addresseMail = addresseMail;
    }

    /**
    * @generated
    */
    private String login;
    
    /**
    * @generated
    */
    private String password;
    
    
    /**
    * @generated
    */
    private Utilisateur utilisateur;

    /**
    * @generated
    */
    public String getLogin() {
        return this.login;
    }
    
    /**
    * @generated
    */
    public void setLogin(String login) {
        this.login = login;
    }
    
    
    /**
    * @generated
    */
    public String getPassword() {
        return this.password;
    }
    
    /**
    * @generated
    */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    /**
    * @generated
    */
    @OneToOne
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }
    
    /**
    * @generated
    */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
    
}
