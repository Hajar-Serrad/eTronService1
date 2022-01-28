package com.etron.springrestful.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.mindrot.jbcrypt.BCrypt;

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
    @Column(unique=true,nullable=false, length=30)
    private String email;
    @Column(nullable=false, length=250)
    private String mdp;
    @Column(nullable=false, length=150)
    private String adresse;
    @OneToMany(mappedBy="inscription")
    private Set<Abonnement> abonnement;
    
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


    public int getIdInscription() {
        return idInscription;
    }


    public void setIdInscription(int aIdInscription) {
        idInscription = aIdInscription;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String aNom) {
        nom = aNom;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String aPrenom) {
        prenom = aPrenom;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String aEmail) {
        email = aEmail;
    }


    public String getMdp() {
        return mdp;
    }


    public void setMdp(String aMdp) {
    	String hashed = BCrypt.hashpw(aMdp, BCrypt.gensalt());
        mdp = hashed;
    }

 
    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String aAdresse) {
        adresse = aAdresse;
    }
    @Override
    public String toString() {
        return String.format("%s(id=%d, nom='%s', prenom=%s)", 
                this.getClass().getSimpleName(), 
                this.getIdInscription(), this.getNom(), this.getPrenom());
    }
}
