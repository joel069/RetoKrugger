package com.krugger.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.krugger.prueba.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	
	@Query(value = "select * from reto.tr_rol x "
			+ " where x.rol_nombre       = :nombre "
			, nativeQuery = true)
	public Rol findrol(String nombre);

}
