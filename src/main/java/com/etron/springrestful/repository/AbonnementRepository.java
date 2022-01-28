package com.etron.springrestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etron.springrestful.entity.Abonnement;
import com.etron.springrestful.entity.Inscription;

public interface AbonnementRepository extends JpaRepository<Abonnement,Integer>  {
	
	


}
