package com.etron.springrestful.repository;
import com.etron.springrestful.entity.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Integer> {

	Optional<Inscription> findByEmail(String email);

}
