package com.etron.springrestful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Inscription")
public class Inscription {
	
	/** Primary key. */
    protected static final String PK = "idInscription";

	
	@Id
    @Column(unique=true, nullable=false, precision=10)
    private int idInscription;
    @Column(nullable=false, length=50)
    private String nom;
    @Column(nullable=false, length=50)
    private String prenom;
    @Column(nullable=false, length=30)
    private String email;
    @Column(nullable=false, length=10)
    private String mdp;
    @Column(nullable=false, length=150)
    private String adresse;
    
    /** Default constructor. */
    public Inscription() {
        super();
    }
    
    public Inscription(int id, String nom, String prenom, String email, String adr, String mdp) {
        super();
        this.idInscription=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.adresse=adr;
        this.mdp=mdp;
    }

    /**
     * Access method for idInscription.
     *
     * @return the current value of idInscription
     */
    public int getIdInscription() {
        return idInscription;
    }

    /**
     * Setter method for idInscription.
     *
     * @param aIdInscription the new value for idInscription
     */
    public void setIdInscription(int aIdInscription) {
        idInscription = aIdInscription;
    }

    /**
     * Access method for nom.
     *
     * @return the current value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter method for nom.
     *
     * @param aNom the new value for nom
     */
    public void setNom(String aNom) {
        nom = aNom;
    }

    /**
     * Access method for prenom.
     *
     * @return the current value of prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter method for prenom.
     *
     * @param aPrenom the new value for prenom
     */
    public void setPrenom(String aPrenom) {
        prenom = aPrenom;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for mdp.
     *
     * @return the current value of mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Setter method for mdp.
     *
     * @param aMdp the new value for mdp
     */
    public void setMdp(String aMdp) {
        mdp = aMdp;
    }

    /**
     * Access method for adresse.
     *
     * @return the current value of adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Setter method for adresse.
     *
     * @param aAdresse the new value for adresse
     */
    public void setAdresse(String aAdresse) {
        adresse = aAdresse;
    }

}
