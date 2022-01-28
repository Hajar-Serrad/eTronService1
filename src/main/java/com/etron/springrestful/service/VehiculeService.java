package com.etron.springrestful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etron.springrestful.entity.Vehicule;
import com.etron.springrestful.repository.VehiculeRepository;



@Service
public class VehiculeService {
	
	@Autowired
	private VehiculeRepository vehiculeRepository;
	
	public Vehicule saveVehicule(Vehicule vehicule) {
		return vehiculeRepository.save(vehicule);
	}
	
	public List<Vehicule> saveVehicules(List<Vehicule> vehicules) {
		return vehiculeRepository.saveAll(vehicules);
	}
	
	public List<Vehicule> getVehicules() {
		return vehiculeRepository.findAll();
	}
	/*
	public Vehicule getVehiculeById(int id) {
		return vehiculeRepository.findById(id).orElse(null);
	}*/
	/*
	public Vehicule getVehiculeByEmail(String email) {
		return vehiculeRepository.findByEmail(email).orElse(null);
	}
	*/
	public String deleteVehicule(int id) {
		vehiculeRepository.deleteById(id);
		return "vehicule removed || " +id;
	}
	
	public Vehicule updateVehicule(Vehicule vehicule) {
		Vehicule _vehicule=vehiculeRepository.findById(vehicule.getIdVehicule()).orElse(null);
		/*_vehicule.setNom(vehicule.getNom());
		_vehicule.setPrenom(vehicule.getPrenom());
		_vehicule.setEmail(vehicule.getEmail());
		_vehicule.setMdp(vehicule.getMdp());
		_vehicule.setAdresse(vehicule.getAdresse());*/
		
		return vehiculeRepository.save(_vehicule);

	}
	
}