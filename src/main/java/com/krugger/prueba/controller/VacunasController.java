package com.krugger.prueba.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krugger.prueba.DTO.ParametrosDTO;
import com.krugger.prueba.model.Empleado;
import com.krugger.prueba.service.ServiceEmpleado;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@SecurityRequirement(name = "seguridad")
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/vacunas")
public class VacunasController {
	
	@Autowired
	ServiceEmpleado empService;
	
	/**
	 * REGISTRAR USUARIO
	 * @param emp
	 * @return
	 */
	@PostMapping(value = {"/guardarEmpleado"} )
	public ResponseEntity <Object> guardarEmpleado(
			@RequestBody Empleado emp
			)throws InterruptedException, ExecutionException, IOException, ParseException{
		return  new ResponseEntity (empService.registrarEmpleado(emp),HttpStatus.OK);
	}
	
	
	
	
	/**
	 * LISTAR TODOS LOE EMPLEADOS
	 * @return
	 */
	@GetMapping(value = "/listar" ,produces = { "application/json", "application/json" })
	public ResponseEntity <List<Empleado>> getEmpleados(){
		return new ResponseEntity <List<Empleado>>(empService.listar(),HttpStatus.OK);
	}
	
	
	/**
	 * EXTRAER DATOS 
	 * @return
	 */
	@GetMapping(value = "/datos" ,produces = { "application/json", "application/json" })
	public ResponseEntity <Empleado> extraer(
			@RequestParam("id") Integer id){
		return ResponseEntity.ok(empService.empleadoPorId(id));
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/elimina" )
	public ResponseEntity <Empleado> eliminar(
			@RequestParam("id") Integer id){
		return new ResponseEntity <Empleado>(empService.eliminar(id),HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * @param id
	 * @param empleado
	 * @return
	 */
	@PutMapping(value = "/modificar" ,produces = { "application/json", "application/json" })
	public ResponseEntity <Empleado> modificar(
			@RequestParam("id") Integer id,
			@RequestBody Empleado empleado){
		return ResponseEntity.ok(empService.modificaEmpleado(empleado, id));
	}
	
	/**
	 * 
	 * @param dat
	 * @return
	 * @throws ParseException
	 */
	@PostMapping(value = "/filtrar" ,produces = { "application/json", "application/json" })
	public ResponseEntity <List<Empleado>> filtrarEmpleados(
			@RequestBody ParametrosDTO dat) throws ParseException{
		return new ResponseEntity <List<Empleado>>(empService.listadoAdmin(dat),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
