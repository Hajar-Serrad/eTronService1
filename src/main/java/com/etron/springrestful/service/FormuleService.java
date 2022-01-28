package com.etron.springrestful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etron.springrestful.entity.Formule;
import com.etron.springrestful.repository.FormuleRepository;



@Service
public class FormuleService {
	
	@Autowired
	private FormuleRepository formuleRepository;
	
	public Formule saveFormule(Formule formule) {
		return formuleRepository.save(formule);
	}
	
	public List<Formule> saveFormules(List<Formule> formules) {
		return formuleRepository.saveAll(formules);
	}
	
	public List<Formule> getFormules() {
		return formuleRepository.findAll();
	}
	/*
	public Formule getFormuleById(int id) {
		return formuleRepository.findById(id).orElse(null);
	}*/
	/*
	public Formule getFormuleByEmail(String email) {
		return formuleRepository.findByEmail(email).orElse(null);
	}
	*/
	public String deleteFormule(int id) {
		formuleRepository.deleteById(id);
		return "formule removed || " +id;
	}
	
	public Formule updateFormule(Formule formule) {
		Formule _formule=formuleRepository.findById(formule.getIdFormule()).orElse(null);
		/*
		_formule.setNom(formule.getNom());
		_formule.setPrenom(formule.getPrenom());
		_formule.setEmail(formule.getEmail());
		_formule.setMdp(formule.getMdp());
		_formule.setAdresse(formule.getAdresse());*/
		
		return formuleRepository.save(_formule);

	}
	
}

