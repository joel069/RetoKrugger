package com.krugger.prueba.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.krugger.prueba.model.TipoVacuna;
import com.krugger.prueba.model.Usuario;
import com.krugger.prueba.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
	
	public List<Empleado>  findByVacuna(TipoVacuna tipo);
	
	
	@Query(value = " SELECT * FROM reto.TR_EMPLEADOS \r\n "
			      + " where emp_id = :id  "
			, nativeQuery = true)
	public Empleado buscarid(Integer id);
	
	
	
	@Query(value = " SELECT * FROM reto.TR_EMPLEADOS \r\n "
			+ " where emp_estado = ':estado' "
			, nativeQuery = true)
	public List<Empleado> estadobuscar(Boolean estado);
	
	@Query(value = " SELECT * FROM reto.TR_EMPLEADOS \r\n "
			+ " where  EMP_FECHA   >= to_date(:fechaInicio,'yyyy-MM-dd') \r\n "
			+ " and    EMP_FECHA   <= to_date(:fechaFinal ,'yyyy-MM-dd') ", nativeQuery = true)

	public List<Empleado> findDatosporfechasdesdehasta(String fechaInicio,String fechaFinal);
	
}
