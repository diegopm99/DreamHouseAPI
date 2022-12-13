package com.idat.APIDreamHouse.dto;

import java.util.Date;

import com.idat.APIDreamHouse.model.Contrato;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RentaDTO {

	private Long id;
	private Date fecha;
	private Double monto;
	private String estado;
	private Date fechaPago;
	private Contrato contrato;
	
	public RentaDTO(Long id, Date fecha, Double monto, String estado, Date fechaPago) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
		this.fechaPago = fechaPago;
	}

}
