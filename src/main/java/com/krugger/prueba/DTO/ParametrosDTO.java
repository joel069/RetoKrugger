package com.krugger.prueba.DTO;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.krugger.prueba.model.TipoVacuna;

import lombok.Data;

@Data
public class ParametrosDTO {
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date inicia;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fin;
	@Enumerated(EnumType.STRING)
	private TipoVacuna tipo;
	private Boolean estado;

}
