package com.idat.APIDreamHouse.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.idat.APIDreamHouse.model.Rol;

import lombok.Data;

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
	private String contrasenia;
	private List<Rol> roles = new ArrayList<>();
}
