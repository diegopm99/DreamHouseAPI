package com.idat.APIDreamHouse.service;

import java.util.List;

import com.idat.APIDreamHouse.dto.RentaDTO;

public interface RentaService {

	public List<RentaDTO> listar();
	public RentaDTO obtener(Long id);
	public void registrar(RentaDTO rentaDto);
	public void actualizar(RentaDTO rentaDto);
	public void eliminar(Long id);
	public void pagarRenta(Long id);
	public List<RentaDTO> listarPorCliente(Long id);
}
