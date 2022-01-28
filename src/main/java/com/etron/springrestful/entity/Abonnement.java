package com.etron.springrestful.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Abonnement")

public class Abonnement {
	
	@GeneratedValue
	@Id
    @Column(unique=true, nullable=false, precision=10)
    private int idAbonnement;
	@ManyToOne(optional=false)
	 @JoinColumn(name="idInscription", nullable=false)
	@JsonIgnore
	private Inscription inscription;
	@ManyToOne(optional=false)
	 @JoinColumn(name="idFormule", nullable=false)
	@JsonIgnore

	private Formule formule;
	@Column(nullable=false, length=50)
	private Date dateDebut;
	@Column(nullable=false, length=50)
	private Date dateFin;
	 @ManyToOne(optional=false)
	 @JoinColumn(name="idVehicule", nullable=false)
		@JsonIgnore

	private Vehicule vehicule;
	 
	 
	public Abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Abonnement(int idAbonnement, Inscription inscription, Formule formule, Date dateDebut, Date dateFin,
			Vehicule vehicule) {
		super();
		this.idAbonnement = idAbonnement;
		this.inscription = inscription;
		this.formule = formule;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.vehicule = vehicule;
	}


	public int getIdAbonnement() {
		return idAbonnement;
	}
	public void setIdAbonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}
	public Inscription getInscription() {
		return inscription;
	}
	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
	public Formule getFormule() {
		return formule;
	}
	public void setFormule(Formule formule) {
		this.formule = formule;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDeb) {
		this.dateDebut = dateDeb;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	 
	 
    @Override
    public String toString() {
        return String.format("%s(id=%d, DEBUT='%s', FIN=%s)", 
                this.getClass().getSimpleName(), 
                this.getIdAbonnement(), this.getDateDebut(), this.getDateFin());
    }
}
