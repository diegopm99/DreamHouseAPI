package com.idat.APIDreamHouse.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoDTO {

	private Long id;
	private Integer piso;
	private Integer numero;
	private Integer habitaciones;
	private Integer bannos;
	private Double area;
	private Double precio;
	private Boolean estado;
	private String imagen;
	private String descripcion;
}
