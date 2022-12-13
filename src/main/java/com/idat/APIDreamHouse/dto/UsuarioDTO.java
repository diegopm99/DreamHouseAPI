package com.idat.APIDreamHouse.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 3603879817458333179L;
	private Long id;
	private String nombres;
	private String apellidos;
	private String dni;
	private String genero;
	private String telefono;
	private String correo;
	private String contrasenna;
	private String escliente;
	
	public UsuarioDTO(Long id, String nombres, String apellidos, String dni, String genero, String telefono,
			String correo, String contrasenna) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.genero = genero;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasenna = contrasenna;
	}

	public UsuarioDTO(Long id, String nombres, String apellidos, String dni, String genero, String telefono,
			String correo, String contrasenna, String escliente) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.genero = genero;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasenna = contrasenna;
		this.escliente = escliente;
	}
	
	
}
