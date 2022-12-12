package com.idat.APIDreamHouse.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.APIDreamHouse.dto.RentaDTO;
import com.idat.APIDreamHouse.model.Contrato;
import com.idat.APIDreamHouse.model.Renta;
import com.idat.APIDreamHouse.repository.ContratoRepository;
import com.idat.APIDreamHouse.repository.RentaRepository;

@Service
public class RentaServiceImpl implements RentaService {

	@Autowired
	private RentaRepository repository;
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@Override
	public List<RentaDTO> listar() {
		List<RentaDTO> listadoDto = new ArrayList<>();
		RentaDTO rentaDto;
		for (Renta renta: repository.findAll()){
			rentaDto = new RentaDTO();
			rentaDto.setId(renta.getIdRenta());
			rentaDto.setFecha(renta.getFecha());
			rentaDto.setEstado(renta.getEstado());
			rentaDto.setFechaPago(renta.getFechaPago());
			rentaDto.setContrato(renta.getContrato());
			listadoDto.add(rentaDto);
		}
		return listadoDto;
	}

	@Override
	public RentaDTO obtener(Long id) {
		Renta renta = repository.findById(id).orElse(null);
		RentaDTO rentaDto = null;
		if(renta != null) {
			rentaDto = new RentaDTO();
			rentaDto.setId(renta.getIdRenta());
			rentaDto.setFecha(renta.getFecha());
			rentaDto.setEstado(renta.getEstado());
			rentaDto.setFechaPago(renta.getFechaPago());
			rentaDto.setContrato(renta.getContrato());
		}
		return rentaDto;
	}

	@Override
	public void registrar(RentaDTO rentaDto) {
		Renta renta = new Renta();
		Contrato contrato = contratoRepository.findById(
				rentaDto.getContrato().getIdContrato()).orElse(null);
		renta.setContrato(contrato);
		renta.setEstado(rentaDto.getEstado());
		renta.setFecha(rentaDto.getFecha());
		renta.setFechaPago(rentaDto.getFechaPago());
		repository.save(renta);
	}

	@Override
	public void actualizar(RentaDTO rentaDto) {
		Renta renta = new Renta();
		Contrato contrato = contratoRepository.findById(
				rentaDto.getContrato().getIdContrato()).orElse(null);
		renta.setIdRenta(rentaDto.getId());
		renta.setContrato(contrato);
		renta.setEstado(rentaDto.getEstado());
		renta.setFecha(rentaDto.getFecha());
		renta.setFechaPago(rentaDto.getFechaPago());
		repository.saveAndFlush(renta);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void pagarRenta(Long id) {
		Renta renta = repository.findById(id).orElse(null);
		renta.setFechaPago(new Date());
		renta.setEstado("Pagado");
		repository.saveAndFlush(renta);
	}
	
}