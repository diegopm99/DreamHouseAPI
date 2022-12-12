package com.idat.APIDreamHouse.service;

import java.util.List;

import com.idat.APIDreamHouse.dto.ContratoDTO;
import com.idat.APIDreamHouse.model.Contrato;

public interface ContratoService {

	public List<ContratoDTO> listar();
	public ContratoDTO obtener(Long id);
	public Contrato registrar(ContratoDTO contratoDto);
	public void actualizar(ContratoDTO contratoDto);
	public void eliminar(Long id);
}
