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
	  public Inscription addInscription(@RequestBody Inscription inscription) {
	    return inscriptionService.saveInscription(inscription);
	  }
	
	@PostMapping("/addInscriptions")
	  public List<Inscription> addInscriptions(@RequestBody List<Inscription> inscriptions) {
	    return inscriptionService.saveInscriptions(inscriptions);
	  }
	
	@GetMapping("/inscriptions")
	  public List<Inscription> findAllInscriptions() {
	    return inscriptionService.getInscriptions();
	  }
	
	@GetMapping("/inscriptions/{id}")
	  public Inscription findInscriptionById(@PathVariable int id) {
	    return inscriptionService.getInscriptionById(id);
	  }
	
	@GetMapping("/inscriptions/{email}")
	  public Inscription findInscriptionByEmail(@PathVariable String email) {
	    return inscriptionService.getInscriptionByEmail(email);
	  }
	
	@PostMapping("/updateInscription")
	  public Inscription updateInscription(@RequestBody Inscription inscription) {
	    return inscriptionService.updateInscription(inscription);
	  }
	
	@DeleteMapping("/delete/{id}")
	public String deleteInscription(@PathVariable int id) {
		return inscriptionService.deleteInscription(id);
	}
	
	


}