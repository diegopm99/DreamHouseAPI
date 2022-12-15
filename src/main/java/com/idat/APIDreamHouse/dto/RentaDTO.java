package com.idat.APIDreamHouse.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentaDTO {

	private Long id;
	private Date fecha;
	private Double monto;
	private String estado;
	private String fechaPago;

}
