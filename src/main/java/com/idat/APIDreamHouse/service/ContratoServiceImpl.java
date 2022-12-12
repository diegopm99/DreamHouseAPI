package com.idat.APIDreamHouse.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.APIDreamHouse.dto.ContratoDTO;
import com.idat.APIDreamHouse.model.Cliente;
import com.idat.APIDreamHouse.model.Contrato;
import com.idat.APIDreamHouse.model.Departamento;
import com.idat.APIDreamHouse.repository.ClienteRepository;
import com.idat.APIDreamHouse.repository.ContratoRepository;
import com.idat.APIDreamHouse.repository.DepartamentoRepository;

@Service
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public List<ContratoDTO> listar() {
		List<ContratoDTO> listadoDto = new ArrayList<>();
		ContratoDTO contratoDto;
		for (Contrato contrato : contratoRepository.findAll()) {
			contratoDto = new ContratoDTO();
			contratoDto.setId(contrato.getIdContrato());
			contratoDto.setEstadia(contrato.getEstadia());
			contratoDto.setFecha(contrato.getFecha());
			contratoDto.setGarantia(contrato.getGarantia());
			contratoDto.setCliente(contrato.getCliente());
			contratoDto.setDepartamento(contrato.getDepartamento());
			listadoDto.add(contratoDto);
		}
		return listadoDto;
	}

	@Override
	public ContratoDTO obtener(Long id) {
		Contrato contrato = contratoRepository.findById(id).orElse(null);
		ContratoDTO contratoDto = null;
		if (contrato != null) {
			contratoDto = new ContratoDTO();
			contratoDto.setId(contrato.getIdContrato());
			contratoDto.setEstadia(contrato.getEstadia());
			contratoDto.setFecha(contrato.getFecha());
			contratoDto.setGarantia(contrato.getGarantia());
			contratoDto.setCliente(contrato.getCliente());
			contratoDto.setDepartamento(contrato.getDepartamento());
		}
		return contratoDto;
	}

	@Override
	public Contrato registrar(ContratoDTO contratoDto) {
		Contrato contrato = new Contrato();
		Cliente cliente = clienteRepository.findById(
				contratoDto.getCliente().getIdCliente()).orElse(null);
		Departamento departamento = departamentoRepository.findById(
				contratoDto.getDepartamento().getIdDepartamento()).orElse(null);
		Date fecha = new Date();
		contrato.setCliente(cliente);
		contrato.setDepartamento(departamento);
		contrato.setEstadia(contratoDto.getEstadia());
		contrato.setFecha(fecha);
		contrato.setGarantia(departamento.getPrecio());
		Contrato nuevoContrato = contratoRepository.save(contrato);
		return nuevoContrato;
	}

	@Override
	public void actualizar(ContratoDTO contratoDto) {
		Contrato contrato = new Contrato();
		Cliente cliente = clienteRepository.findById(
				contratoDto.getCliente().getIdCliente()).orElse(null);
		Departamento departamento = departamentoRepository.findById(
				contratoDto.getDepartamento().getIdDepartamento()).orElse(null);
		contrato.setIdContrato(contratoDto.getId());
		contrato.setCliente(cliente);
		contrato.setDepartamento(departamento);
		contrato.setEstadia(contratoDto.getEstadia());
		contrato.setFecha(contratoDto.getFecha());
		contrato.setGarantia(contratoDto.getGarantia());
		contratoRepository.saveAndFlush(contrato);
	}

	@Override
	public void eliminar(Long id) {
		contratoRepository.deleteById(id);
	}

}
