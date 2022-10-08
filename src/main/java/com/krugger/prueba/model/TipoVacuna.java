package com.krugger.prueba.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoVacuna {
	
	PFIZER("PFIZER"),
	SINOVAC("SINOVAC"),
	AZTRAZENECA("AZTRAZENECA"),
	JHONSON("JHONSON");
	
	private String tipovacuna;

	 TipoVacuna(String tipovac) {
		this.tipovacuna = tipovac;
	}

	public String getTipovacuna() {
		return tipovacuna;
	}

	public void setTipovacuna(String tipovacuna) {
		this.tipovacuna = tipovacuna;
	}
	 
}



