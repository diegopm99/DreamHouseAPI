package com.idat.APIDreamHouse.service;

import java.util.List;

import com.idat.APIDreamHouse.dto.ClienteDTO;

public interface ClienteService {

	public List<ClienteDTO> listar();
	public ClienteDTO obtener(Long id);
	public void registrar(ClienteDTO clienteDto);
	public void actualizar(ClienteDTO clienteDto);
	public void eliminar(Long id);
}
