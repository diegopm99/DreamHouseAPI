package com.idat.APIDreamHouse.dto;

import java.util.Date;

import com.idat.APIDreamHouse.model.Contrato;

import lombok.Data;

@Data
public class RentaDTO {

	private Long id;
	private Date fecha;
	private String estado;
	private Date fechaPago;
	private Contrato contrato;
}
