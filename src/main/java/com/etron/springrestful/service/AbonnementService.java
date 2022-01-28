package com.etron.springrestful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.etron.springrestful.entity.Abonnement;
import com.etron.springrestful.repository.AbonnementRepository;

@Service
public class AbonnementService {
	
	@Autowired
	private AbonnementRepository abonnementRepository;
	
	public Abonnement saveAbonnement(Abonnement abonnement) {
		return abonnementRepository.save(abonnement);
	}
	
	 
	public ResponseEntity<Abonnement> effectuerAbonnement(Abonnement abonnement) {
		//return abonnementRepository.save(abonnement);
		 try {
		      return new ResponseEntity<>(abonnementRepository.save(abonnement), HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	public List<Abonnement> saveAbonnements(List<Abonnement> abonnements) {
		return abonnementRepository.saveAll(abonnements);
	}
	
	public List<Abonnement> getAbonnements() {
		return abonnementRepository.findAll();
	}
	
	public Abonnement getAbonnementById(int id) {
		return abonnementRepository.getById(id);
	}
	/*
	public Abonnement getAbonnementByEmail(String email) {
		return abonnementRepository.findByEmail(email).orElse(null);
	}*/
	
	public String deleteAbonnement(int id) {
		abonnementRepository.deleteById(id);
		return "abonnement removed || " +id;
	}
	
	public Abonnement updateAbonnement(Abonnement abonnement) {
		Abonnement _abonnement=abonnementRepository.findById(abonnement.getIdAbonnement()).orElse(null);
		//_abonnement.setNom(inscription.getNom());
		
		return abonnementRepository.save(_abonnement);

	}


	
	

}
