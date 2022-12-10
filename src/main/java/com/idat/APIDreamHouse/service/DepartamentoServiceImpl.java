package com.idat.APIDreamHouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.APIDreamHouse.dto.DepartamentoDTO;
import com.idat.APIDreamHouse.model.Departamento;
import com.idat.APIDreamHouse.model.Edificio;
import com.idat.APIDreamHouse.repository.DepartamentoRepository;
import com.idat.APIDreamHouse.repository.EdificioRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private EdificioRepository edificioRepository;

	@Override
	public List<DepartamentoDTO> listar() {
		List<DepartamentoDTO> listadoDto = new ArrayList<>();
		DepartamentoDTO departamentoDto;
		for (Departamento departamento : departamentoRepository.findAll()) {
			departamentoDto = new DepartamentoDTO();
			departamentoDto.setId(departamento.getIdDepartamento());
			departamentoDto.setEdificio(departamento.getEdificio());
			departamentoDto.setNumero(departamento.getNumero());
			departamentoDto.setPiso(departamento.getPiso());
			departamentoDto.setHabitaciones(departamento.getHabitaciones());
			departamentoDto.setBannos(departamento.getBannos());
			departamentoDto.setArea(departamento.getArea());
			departamentoDto.setPrecio(departamento.getPrecio());
			departamentoDto.setEstado(departamento.getEstado());
			listadoDto.add(departamentoDto);
		}
		return listadoDto;
	}

	@Override
	public DepartamentoDTO obtener(Long id) {
		Departamento departamento = departamentoRepository.findById(id).orElse(null);
		DepartamentoDTO departamentoDto = null;
		if (departamento != null) {
			departamentoDto = new DepartamentoDTO();
			departamentoDto.setId(departamento.getIdDepartamento());
			departamentoDto.setEdificio(departamento.getEdificio());
			departamentoDto.setNumero(departamento.getNumero());
			departamentoDto.setPiso(departamento.getPiso());
			departamentoDto.setHabitaciones(departamento.getHabitaciones());
			departamentoDto.setBannos(departamento.getBannos());
			departamentoDto.setArea(departamento.getArea());
			departamentoDto.setPrecio(departamento.getPrecio());
			departamentoDto.setEstado(departamento.getEstado());
		}
		return departamentoDto;
	}

	@Override
	public void registrar(DepartamentoDTO departamentoDto) {
		Departamento departamento = new Departamento();
		Edificio edificio = edificioRepository.findById(
				departamentoDto.getEdificio().getIdEdificio()).orElse(null);
		departamento.setEdificio(edificio);
		departamento.setNumero(departamentoDto.getNumero());
		departamento.setPiso(departamentoDto.getPiso());
		departamento.setHabitaciones(departamentoDto.getHabitaciones());
		departamento.setBannos(departamentoDto.getBannos());
		departamento.setArea(departamentoDto.getArea());
		departamento.setPrecio(departamentoDto.getPrecio());
		departamento.setEstado(departamentoDto.getEstado());
		departamentoRepository.save(departamento);
	}

	@Override
	public void actualizar(DepartamentoDTO departamentoDto) {
		Departamento departamento = new Departamento();
		Edificio edificio = edificioRepository.findById(
				departamentoDto.getEdificio().getIdEdificio()).orElse(null);
		departamento.setIdDepartamento(departamentoDto.getId());
		departamento.setEdificio(edificio);
		departamento.setNumero(departamentoDto.getNumero());
		departamento.setPiso(departamentoDto.getPiso());
		departamento.setHabitaciones(departamentoDto.getHabitaciones());
		departamento.setBannos(departamentoDto.getBannos());
		departamento.setArea(departamentoDto.getArea());
		departamento.setPrecio(departamentoDto.getPrecio());
		departamento.setEstado(departamentoDto.getEstado());
		departamentoRepository.saveAndFlush(departamento);
	}

	@Override
	public void eliminar(Long id) {
		departamentoRepository.deleteById(id);
	}

}
