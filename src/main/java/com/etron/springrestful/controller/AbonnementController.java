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


import com.etron.springrestful.entity.Abonnement;
import com.etron.springrestful.entity.Vehicule;
import com.etron.springrestful.service.AbonnementService;
import com.etron.springrestful.service.AbonnementService;

@RestController
public class AbonnementController {
	
	@Autowired
	AbonnementService abonnementService;
	
	@PostMapping("/addAbonnement")
	  public String addAbonnement(@RequestBody Abonnement abonnement) {
	    Abonnement _abonnement = abonnementService.getAbonnementById(abonnement.getIdAbonnement());
		if(_abonnement != null) {
			return  "Id déjà existant";
		}
		else {
			abonnementService.saveAbonnement(abonnement);
			return abonnement.toString();
			
		}
	  }
	/*
	@PostMapping("/effectuerAbonnement")
	  public ResponseEntity<Abonnement> effectuerAbonnement(@RequestBody Abonnement abonnement) {
	    return abonnementService.effectuerAbonnement(abonnement);
	  }*/
	
	@PostMapping("/addAbonnements")
	  public List<Abonnement> addAbonnements(@RequestBody List<Abonnement> abonnements) {
	    return abonnementService.saveAbonnements(abonnements);
	  }
	
	@GetMapping("/abonnements")
	  public ResponseEntity<List<Abonnement>> findAllAbonnements() {
	   
	    try {
	    	
	    	 if (abonnementService.getAbonnements().isEmpty()) {
	 	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 	      }

	 	      return new ResponseEntity<>(abonnementService.getAbonnements(), HttpStatus.OK);
	 	     //return new ResponseEntity<>(HttpStatus.OK);
	 	    } catch (Exception e) {
	 	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	 	    }
	  }
	
	@GetMapping("/abonnements/{id}")
	  public String findAbonnementById(@PathVariable int id) {
		if(abonnementService.getAbonnementById(id) != null) {
			return abonnementService.getAbonnementById(id).toString();
		}else{
			return  "Abonnement innexistant";
		}
	    
	  }
	
	/*
	@GetMapping("/Abonnements/{email}")
	  public Abonnement findAbonnementByEmail(@PathVariable String email) {
	    return abonnementService.getAbonnementByEmail(email);
	  }*/
	
	@PostMapping("/updateAbonnement")
	  public Abonnement updateAbonnement(@RequestBody Abonnement abonnement) {
	    return abonnementService.updateAbonnement(abonnement);
	  }
	
	@DeleteMapping("/deleteAbonnement/{id}")
	public String deleteAbonnement(@PathVariable int id) {
		if(abonnementService.getAbonnementById(id) != null) {
			return abonnementService.deleteAbonnement(id);
		}else{
			return  "Abonnement innexistant";
		}
		
	}
	

}
