package com.etron.springrestful.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Vehicule")
public class Vehicule {
	
	@Id
    @Column(unique=true, nullable=false, precision=10)
    private int idVehicule;
	@Column(nullable=false)
	private Date dateAchat;
	@Column(nullable=false, length=20)
	private String pointAchat;
    @OneToMany(mappedBy="vehicule")
    @JsonIgnore
    private Set<Abonnement> abonnement;
    
    public Vehicule() {
        super();
    }

	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getPointAchat() {
		return pointAchat;
	}

	public void setPointAchat(String pointAchat) {
		this.pointAchat = pointAchat;
	}

	public Set<Abonnement> getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Set<Abonnement> abonnement) {
		this.abonnement = abonnement;
	}
    
    
}
