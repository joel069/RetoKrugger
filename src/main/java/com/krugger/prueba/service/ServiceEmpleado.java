package com.krugger.prueba.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.krugger.prueba.DTO.ParametrosDTO;
import com.krugger.prueba.model.Empleado;
import com.krugger.prueba.model.Usuario;
import com.krugger.prueba.model.Vacuna;
import com.krugger.prueba.repository.EmpleadoRepository;
import com.krugger.prueba.repository.RolRepository;


@Service
public class ServiceEmpleado {
	
	private static final Logger LOG = 
			LoggerFactory.getLogger(ServiceEmpleado.class);
	
	
	@Autowired
	private PasswordEncoder encoder;
	

	@Autowired
	private RolRepository reporol;

	@Autowired
	private EmpleadoRepository repoempleado;
	
	
	public Empleado empleadoPorId(Integer id) {
		return  repoempleado.buscarid(id);
	}
	
	public Empleado registrarEmpleado(Empleado data) {
		Usuario empusu = new Usuario();
		int a1 = Calendar.getInstance().get(Calendar.YEAR);
		//Cedula
		String usuario = data.getCedula().trim();
		//Anio mas nombre
		String clave = data.getNombre().trim().toUpperCase() + a1;
		empusu.setUsuario(usuario);
		empusu.setClave(encoder.encode(clave));
		empusu.setRol(reporol.findrol("user"));
		data.setUsuario(empusu);
		
		System.out.println(data);
		
		return repoempleado.save(data); 
		
	}
	
	public Empleado eliminar (Integer idempleado) {
		Optional<Empleado> emp = repoempleado.findById(idempleado);
		repoempleado.delete(emp.get());
		return emp.get();
		
	}
	
	
	public List<Empleado> listar() {
		return repoempleado.findAll();
	}
	
	public List<Empleado>listadoAdmin(ParametrosDTO datos) throws ParseException {
		List <Empleado> emp = new ArrayList<>();
		if (datos.getInicia() !=null && datos.getFin() != null) {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String Inicio = simpleDateFormat.format(datos.getInicia());
			String Final = simpleDateFormat.format(datos.getFin());
			System.out.println(Inicio);
			emp = repoempleado.findDatosporfechasdesdehasta(Inicio,Final);
			return emp;
		}else if (datos.getTipo() != null) {
			emp = repoempleado.findByVacuna(datos.getTipo());
			return emp;
		}else if (datos.getEstado() != null) {
			return repoempleado.estadobuscar(datos.getEstado());
		}else {
			LOG.error("POR FAVOR INGRESE UN AL MENOS UN CAMPO DE BUSQUEDA...!!");
		}
		return emp;
	}
	
	public Empleado modificaEmpleado(Empleado datos,Integer id) {
		
		Optional<Empleado> e = repoempleado.findById(id);
		
		if(e.get() != null) {
			
			if(!datos.getEstado() == false && datos.getVacuna() != null ) {
				
				
				e.get().setApellido(datos.getApellido() != null ?  datos.getApellido() : e.get().getApellido());
				e.get().setNombre(datos.getNombre()     != null ? datos.getApellido() : e.get().getApellido());
				e.get().setCorreo(datos.getCorreo()     != null ? datos.getCorreo() : e.get().getCorreo());
				e.get().setDireccion(datos.getDireccion() != null ? datos.getCorreo() : e.get().getCorreo());
				e.get().setCedula(datos.getCedula()     != null ? datos.getCedula() : e.get().getCedula());
				e.get().setTelefono(datos.getTelefono() != null ? datos.getTelefono() : e.get().getTelefono());
				e.get().setEstado(datos.getEstado()     != null ? datos.getEstado() : e.get().getEstado());
				
				if (datos.getVacuna() != null) {
					for (Vacuna vac : datos.getVacuna()) {
						vac.setEmpleado(e.get());
						e.get().getVacuna().add(vac);
					}
				}
				
				repoempleado.save(e.get());
				return e.get();
				
				
			}else {
				LOG.error("DEBE INGRESAR DATOS DE VACUNACION...!!!!");
			}
			
		}else {
			LOG.error("EL EMPLEADO NO EXISTE, POR FAVOR CREARLO..!!");
		}
		
		
		return null;
		
		
	}
	
	
	
	
	
	


}
