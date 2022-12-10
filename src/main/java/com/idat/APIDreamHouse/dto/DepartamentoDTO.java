package com.idat.APIDreamHouse.dto;

import com.idat.APIDreamHouse.model.Edificio;

import lombok.Data;

@Data
public class DepartamentoDTO {

	private Long id;
	private Integer piso;
	private Integer numero;
	private Integer habitaciones;
	private Integer bannos;
	private Double area;
	private Double precio;
	private Boolean estado;
	private Edificio edificio;
}
