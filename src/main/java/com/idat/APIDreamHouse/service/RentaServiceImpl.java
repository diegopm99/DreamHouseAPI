package com.idat.APIDreamHouse.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.APIDreamHouse.dto.RentaDTO;
import com.idat.APIDreamHouse.model.Renta;
import com.idat.APIDreamHouse.repository.RentaRepository;

@Service
public class RentaServiceImpl implements RentaService {

	@Autowired
	private RentaRepository repository;
	
	//@Autowired
	//private ContratoRepository contratoRepository;
	
	@Override
	public List<RentaDTO> listar() {
		List<RentaDTO> listadoDto = new ArrayList<>();
		RentaDTO rentaDto;
		for (Renta renta: repository.findAll()){
			rentaDto = new RentaDTO();
			rentaDto.setId(renta.getIdRenta());
			rentaDto.setFecha(renta.getFecha());
			rentaDto.setMonto(renta.getMonto());
			rentaDto.setEstado(renta.getEstado());
			rentaDto.setFechaPago(renta.getFechaPago());
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
			rentaDto.setMonto(renta.getMonto());
			rentaDto.setEstado(renta.getEstado());
			rentaDto.setFechaPago(renta.getFechaPago());
		}
		return rentaDto;
	}

	@Override
	public void registrar(Renta renta) {
		repository.save(renta);
	}

	@Override
	public void actualizar(RentaDTO rentaDto) {
		Renta renta = new Renta();
		/*Contrato contrato = contratoRepository.findById(
				rentaDto.getContrato().getIdContrato()).orElse(null);*/
		renta.setIdRenta(rentaDto.getId());
		//renta.setContrato(contrato);
		renta.setEstado(rentaDto.getEstado());
		renta.setFecha(rentaDto.getFecha());
		renta.setFechaPago(rentaDto.getFechaPago());
		renta.setMonto(rentaDto.getMonto());
		repository.saveAndFlush(renta);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void pagarRenta(Long id) {
		String fechapago = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
		Renta renta = repository.findById(id).orElse(null);
		renta.setFechaPago(fechapago);
		renta.setEstado("Pagado");
		repository.saveAndFlush(renta);
	}

	@Override
	public List<RentaDTO> listarPorUsuario(Long id) {
		List<RentaDTO> listadoDto = new ArrayList<>();
		RentaDTO rentaDto;
		String fechapago;
		for(Renta renta: repository.findByUsuario(id)) {
			if(renta.getFechaPago() != null) {
				fechapago = renta.getFechaPago();
			} else {
				fechapago = "";
			}
			rentaDto = new RentaDTO(
					renta.getIdRenta(),
					renta.getFecha(),
					renta.getMonto(),
					renta.getEstado(),
					fechapago
			);
			listadoDto.add(rentaDto);
		}
		return listadoDto;
	}
	
}
