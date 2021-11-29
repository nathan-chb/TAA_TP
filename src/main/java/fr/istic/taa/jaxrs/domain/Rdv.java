package fr.istic.taa.jaxrs.domain;


import javax.persistence.*;
import java.util.Date;

/**
* @generated
*/
@Entity
public class Rdv {

    private Long id;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /**
    * @generated
    */
    private String nom;
    
    /**
    * @generated
    */
    private Date heureDebut;
    
    /**
    * @generated
    */
    private Date heureFin;
    
    
    /**
    * @generated
    */
    private Professionel professionel;
    
    /**
    * @generated
    */
    private Utilisateur utilisateur;
    
    

    /**
    * @generated
    */
    public String getNom() {
        return this.nom;
    }
    
    /**
    * @generated
    */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    /**
    * @generated
    */
    public Date getHeureDebut() {
        return this.heureDebut;
    }
    
    /**
    * @generated
    */
    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }
    
    
    /**
    * @generated
    */
    public Date getHeureFin() {
        return this.heureFin;
    }
    
    /**
    * @generated
    */
    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }
    
    
    
    /**
    * @generated
    */
    @ManyToOne
    public Professionel getProfessionel() {
        return this.professionel;
    }
    
    /**
    * @generated
    */
    public void setProfessionel(Professionel professionel) {
        this.professionel = professionel;
    }
    
    
    /**
    * @generated
    */
    @ManyToOne
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
