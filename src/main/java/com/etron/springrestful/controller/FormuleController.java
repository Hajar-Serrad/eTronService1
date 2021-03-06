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

import com.etron.springrestful.entity.Formule;
import com.etron.springrestful.service.FormuleService;

@RestController
public class FormuleController {
	
	@Autowired
	FormuleService formuleService;
	
	
	@GetMapping("/formules")
	  public List<Formule> findAllFormules() {
	    return formuleService.getFormules();
	  }
	/*
	@GetMapping("/formules/{id}")
	  public Formule findFormuleById(@PathVariable int id) {
	    return formuleService.getFormuleById(id);
	  }*/
	/*
	@GetMapping("/formules/{email}")
	  public Formule findFormuleByEmail(@PathVariable String email) {
	    return formuleService.getFormuleByEmail(email);
	  }
	*/
	@PostMapping("/updateFormule")
	  public String updateFormule( ) {
	    return "Formule non modifiable";
	  }
	
	@DeleteMapping("/deleteFormule/{id}")
	public String deleteFormule(@PathVariable int id) {
		return "impossible de supprimer une formule";
	}
	
	


}

