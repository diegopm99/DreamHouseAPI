package com.idat.APIDreamHouse.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BasicResponse implements Serializable {

	private static final long serialVersionUID = 4917499301520055944L;
	private Boolean respuesta;
}
