package com.idat.APIDreamHouse.dto;

import lombok.Data;

@Data
public class EdificioDTO {

	private Long id;
	private Integer pisos;
	private String direccion;
	private Boolean estado;
	private String imagen;
}
