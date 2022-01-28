package com.etron.springrestful.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etron.springrestful.entity.Inscription;
import com.etron.springrestful.repository.InscriptionRepository;



@Service
public class InscriptionService {
	
	private EntityManager entityManager;

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
	
	public Inscription getInscriptionById(int id) {
		/*CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Inscription> cQuery = builder.createQuery(Inscription.class);
	    Root<Inscription> root = cQuery.from(Inscription.class);
	    cQuery
	      .select(root)
	      .where(builder.equal(root.get("idinscription"), id));
	    TypedQuery<Inscription> query = entityManager.createQuery(cQuery);
	    return query.getResultList();*/
		return inscriptionRepository.getById(id);

	}
	
	public Inscription getInscriptionByEmail(String email) {
		return inscriptionRepository.findByEmail(email).orElse(null);
	}
	
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
