package com.krugger.prueba.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "TR_VACUNA", schema="reto")
public class Vacuna {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vac_id")
	private Integer id;
	
	@Column(name = "vac_dosis")
	private Integer dosis;
	
	@Column(name = "vac_tipo")
	@Enumerated(EnumType.STRING)
	private TipoVacuna tipo;
	
	@Column(name = "vac_fecha")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Empleado.class)
	@JoinColumn(name = "vac_emp_id", referencedColumnName = "emp_id")
	private Empleado empleado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDosis() {
		return dosis;
	}

	public void setDosis(Integer dosis) {
		this.dosis = dosis;
	}

	public TipoVacuna getTipo() {
		return tipo;
	}

	public void setTipo(TipoVacuna tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
