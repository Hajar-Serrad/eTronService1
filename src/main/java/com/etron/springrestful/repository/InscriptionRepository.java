package com.etron.springrestful.repository;
import com.etron.springrestful.entity.*;

import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface InscriptionRepository extends JpaRepository<Inscription,Integer> {

	
	Optional<Inscription> findByEmail(String email);

	@Query("select i from Inscription i where i.idInscription = :id")
	Inscription getById(int id);

}
