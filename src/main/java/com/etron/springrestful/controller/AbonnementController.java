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
import com.etron.springrestful.service.AbonnementService;
import com.etron.springrestful.service.AbonnementService;

@RestController
public class AbonnementController {
	
	@Autowired
	AbonnementService abonnementService;
	
	@PostMapping("/addAbonnement")
	  public Abonnement addAbonnement(@RequestBody Abonnement abonnement) {
	    return abonnementService.saveAbonnement(abonnement);
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

	 	      //return new ResponseEntity<>(abonnementService.getAbonnements(), HttpStatus.OK);
	 	     return new ResponseEntity<>(HttpStatus.OK);
	 	    } catch (Exception e) {
	 	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	 	    }
	  }
	/*
	@GetMapping("/Abonnements/{id}")
	  public Abonnement findAbonnementById(@PathVariable int id) {
	    return abonnementService.getAbonnementById(id);
	  }*/
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
		return abonnementService.deleteAbonnement(id);
	}
	

}
