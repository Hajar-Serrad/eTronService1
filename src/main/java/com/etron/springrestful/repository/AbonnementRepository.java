package com.etron.springrestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etron.springrestful.entity.Abonnement;
import com.etron.springrestful.entity.Inscription;

public interface AbonnementRepository extends JpaRepository<Abonnement,Integer>  {
	
	
	@Query("select a from Abonnement a where a.idAbonnement = :id")
	Abonnement getById(int id);

}
