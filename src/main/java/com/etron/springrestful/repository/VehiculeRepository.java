package com.etron.springrestful.repository;
import com.etron.springrestful.entity.*;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehiculeRepository extends JpaRepository<Vehicule,Integer> {

	//
	@Query("select v from Vehicule v where v.idVehicule = :id")
	Vehicule getById(int id);

}
