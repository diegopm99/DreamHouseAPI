package com.idat.APIDreamHouse.service;

import java.util.List;

import com.idat.APIDreamHouse.dto.UsuarioDTO;


public interface UsuarioService {

	public List<UsuarioDTO> listar();
	public UsuarioDTO obtener(Long id);
	public void registrar(UsuarioDTO usuarioDto);
	public void actualizar(UsuarioDTO usuarioDto);
	public void eliminar(Long id);
	public UsuarioDTO obtenerPorEmail(String email);
}

