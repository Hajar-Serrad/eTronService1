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
import com.etron.springrestful.entity.Vehicule;
import com.etron.springrestful.service.VehiculeService;

@RestController
public class VehiculeController {
	
	@Autowired
	VehiculeService vehiculeService;
	
	@PostMapping("/addVehicule")
	  public String addVehicule(@RequestBody Vehicule vehicule) {
		Vehicule _vehicule = vehiculeService.getVehiculeById(vehicule.getIdVehicule());
		if(_vehicule != null) {
			return  "Id déjà existant";
		}
		else {
			vehiculeService.saveVehicule(vehicule);
			return vehicule.toString();
			
		}
	  }
	
	@PostMapping("/addVehicules")
	  public List<Vehicule> addVehicules(@RequestBody List<Vehicule> vehicules) {
	    return vehiculeService.saveVehicules(vehicules);
	  }
	
	@GetMapping("/vehicules")
	  public List<Vehicule> findAllVehicules() {
	    return vehiculeService.getVehicules();
	  }
	
	@GetMapping("/vehicules/{id}")
	  public Vehicule findVehiculeById(@PathVariable int id) {
	    return vehiculeService.getVehiculeById(id);
	  }
	/*
	@GetMapping("/vehicules/{email}")
	  public Vehicule findVehiculeByEmail(@PathVariable String email) {
	    return vehiculeService.getVehiculeByEmail(email);
	  }
	*/
	@PostMapping("/updateVehicule")
	  public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
	    return vehiculeService.updateVehicule(vehicule);
	  }
	
	@DeleteMapping("/deleteVehicule/{id}")
	public String deleteVehicule(@PathVariable int id) {
		return vehiculeService.deleteVehicule(id);
	}
	
	


}

