package com.krugger.prueba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TR_USUARIOS" , schema= "reto")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Integer id;

	@Column(name = "usu_usuario")
	private String usuario;

	@Column(name = "usu_clave")
	private String clave;

	@OneToOne
	@JoinColumn(name = "usu_rol_id", referencedColumnName = "rol_id")
	private Rol rol;

	
	
	
	
	
	
}
