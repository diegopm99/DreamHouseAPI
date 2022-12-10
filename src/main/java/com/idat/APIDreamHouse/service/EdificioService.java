package com.idat.APIDreamHouse.service;

import java.util.List;

import com.idat.APIDreamHouse.dto.EdificioDTO;

public interface EdificioService {

	public List<EdificioDTO> listar();
	public EdificioDTO obtener(Long id);
	public void registrar(EdificioDTO edificioDto);
	public void actualizar(EdificioDTO edificioDto);
	public void eliminar(Long id);
}
