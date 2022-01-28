package com.etron.springrestful.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etron.springrestful.entity.Inscription;
import com.etron.springrestful.service.InscriptionService;

@RestController
public class InscriptionController {
	
	@Autowired
	InscriptionService inscriptionService;
	
	@PostMapping("/addInscription")
	  public String addInscription(@RequestBody Inscription inscription) {
		Inscription _inscription = inscriptionService.getInscriptionById(inscription.getIdInscription());
		if(_inscription != null) {
			return  "Id déjà existant";
		}
		else {
			inscriptionService.saveInscription(inscription);
			return inscription.toString();
			
		}
	  }
	
	@PostMapping("/addInscriptions")
	  public List<Inscription> addInscriptions(@RequestBody List<Inscription> inscriptions) {
	    return inscriptionService.saveInscriptions(inscriptions);
	  }
	
	@GetMapping("/inscriptions")
	  public ResponseEntity<List<Inscription>>  findAllInscriptions() {
	    try {
	    	return new ResponseEntity<>(inscriptionService.getInscriptions(), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	
	@GetMapping("/inscriptions/{id}")
    public String findInscriptionById(@PathVariable int id) {
		if(inscriptionService.getInscriptionById(id) != null) {
			return inscriptionService.getInscriptionById(id).toString();
		}else{
			return  "Inscription innexistante";
		}
	    

	  }
	/*
	@GetMapping("/inscriptions/{email}")
	  public Inscription findInscriptionByEmail(@PathVariable String email) {
	    return inscriptionService.getInscriptionByEmail(email);
	  }
	*/
	@PostMapping("/updateInscription")
	  public Inscription updateInscription(@RequestBody Inscription inscription) {
	    return inscriptionService.updateInscription(inscription);
	  }
	
	@DeleteMapping("/deleteInscription/{id}")
	public String deleteInscription(@PathVariable int id) {
		return inscriptionService.deleteInscription(id);
	}
	
	


}
