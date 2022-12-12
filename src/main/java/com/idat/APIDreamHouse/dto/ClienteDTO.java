package com.idat.APIDreamHouse.dto;


import com.idat.APIDreamHouse.model.Usuario;

import lombok.Data;

@Data
public class ClienteDTO {

	private Long id;
	private Boolean estado;
	private Usuario usuario;
}
