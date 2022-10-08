package com.krugger.prueba.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "TR_EMPLEADOS", schema="reto")
public class Empleado {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer id;
	
	@Size(min = 10, max = 10, message = "")
	@NotNull(message = "Campo requerido")
	@Column(name = "emp_cedula", length = 10, unique = true)
	private String cedula;
	
	@NotNull(message = "Campo requerido")
	@Column(name = "emp_apellido")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Debe ingresar solo letras")
	private String apellido;
	
	@NotNull(message = "Campo requerido")
	@Column(name = "emp_correo")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Correo invalido")
	private String correo;
	
	@Column(name = "emp_fecha")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@Column(name = "emp_telefono")
	@Pattern(regexp = "^[0-9]{10}$", message = "Longitud permitida 10 digitos")
	private String telefono;
	
	@Column(name = "emp_direccion")
	private String direccion;
	
	@Column(name = "emp_estado")
	private Boolean estado;
	
	@NotNull(message = "Campo requerido")
	@Column(name = "emp_nombre	")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Debe ingresar solo letras")
	private String nombre;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Vacuna> vacuna;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_usu_id", referencedColumnName = "usu_id")
	private Usuario usuario;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Vacuna> getVacuna() {
		return vacuna;
	}


	public void setVacuna(List<Vacuna> vacuna) {
		this.vacuna = vacuna;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	


}
