package com.etron.springrestful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etron.springrestful.entity.Inscription;
import com.etron.springrestful.repository.InscriptionRepository;



@Service
public class InscriptionService {
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	public Inscription saveInscription(Inscription inscription) {
		return inscriptionRepository.save(inscription);
	}
	
	public List<Inscription> saveInscriptions(List<Inscription> inscriptions) {
		return inscriptionRepository.saveAll(inscriptions);
	}
	
	public List<Inscription> getInscriptions() {
		return inscriptionRepository.findAll();
	}
	/*
	public Inscription getInscriptionById(int id) {
		return inscriptionRepository.findById(id).orElse(null);
	}
	
	public Inscription getInscriptionByEmail(String email) {
		return inscriptionRepository.findByEmail(email).orElse(null);
	}
	*/
	public String deleteInscription(int id) {
		inscriptionRepository.deleteById(id);
		return "inscription removed || " +id;
	}
	
	public Inscription updateInscription(Inscription inscription) {
		Inscription _inscription=inscriptionRepository.findById(inscription.getIdInscription()).orElse(null);
		_inscription.setNom(inscription.getNom());
		_inscription.setPrenom(inscription.getPrenom());
		_inscription.setEmail(inscription.getEmail());
		_inscription.setMdp(inscription.getMdp());
		_inscription.setAdresse(inscription.getAdresse());
		
		return inscriptionRepository.save(_inscription);

	}
	
}
