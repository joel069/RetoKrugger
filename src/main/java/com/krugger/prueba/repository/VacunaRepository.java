package com.krugger.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krugger.prueba.model.Vacuna;
@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Integer> {
	
	

}
