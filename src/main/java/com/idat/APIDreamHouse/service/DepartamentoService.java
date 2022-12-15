package com.idat.APIDreamHouse.service;

import java.util.List;

import com.idat.APIDreamHouse.dto.DepartamentoDTO;

public interface DepartamentoService{

	public List<DepartamentoDTO> listar();
	public List<DepartamentoDTO> listarDepasporEdificio(Long id);
	public DepartamentoDTO obtener(Long id);
	public void registrar(DepartamentoDTO departamentoDto);
	public void actualizar(DepartamentoDTO departamentoDto);
	public void eliminar(Long id);
}
