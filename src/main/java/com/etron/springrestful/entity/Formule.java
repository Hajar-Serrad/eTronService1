package com.etron.springrestful.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Formule")
public class Formule {

	@Id
    @Column(unique=true, nullable=false, precision=10)
    private int idFormule;
    @Column(nullable=false, length=50)
	private String type;
    @Column(nullable=false, length=50)
	private float base;
    @Column(nullable=false, length=50)
	private String charge22;
    @Column(nullable=false, length=50)
	private String charge50;
    @Column(nullable=false,length=50)
	private String ionity;
    @OneToMany(mappedBy="formule")
    private Set<Abonnement> abonnement;
    
	public int getIdFormule() {
		return idFormule;
	}
	
	public String getType() {
		return type;
	}
	
	public float getBase() {
		return base;
	}
	
	public String getCharge22() {
		return charge22;
	}
	
	public String getCharge50() {
		return charge50;
	}
	
	public String getIonity() {
		return ionity;
	}
    
    
}
