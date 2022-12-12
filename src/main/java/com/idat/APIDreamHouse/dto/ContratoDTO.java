package com.idat.APIDreamHouse.dto;

import java.util.Date;

import com.idat.APIDreamHouse.model.Cliente;
import com.idat.APIDreamHouse.model.Departamento;

import lombok.Data;

@Data
public class ContratoDTO {

	private Long id;
	private Integer estadia;
	private Double garantia;
	private Date fecha;
	private Cliente cliente;
	private Departamento departamento;
}
