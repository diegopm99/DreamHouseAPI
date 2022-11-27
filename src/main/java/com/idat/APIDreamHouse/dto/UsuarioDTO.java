package com.idat.APIDreamHouse.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idUsuario;
	private String nombres;
	private String apellidos;
	private String dni;
	private String genero;
	private String telefono;
	private String correo;
	private String contrasenia;

}
