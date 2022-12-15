package com.idat.APIDreamHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.APIDreamHouse.dto.DepartamentoDTO;
import com.idat.APIDreamHouse.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<DepartamentoDTO>> listar() {
		return new ResponseEntity<List<DepartamentoDTO>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<DepartamentoDTO>> listarDepasPorEdificio(@PathVariable Long id) {
		return new ResponseEntity<List<DepartamentoDTO>>(service.listarDepasporEdificio(id), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<DepartamentoDTO> obtener(@PathVariable Long id) {
		System.out.println(id);
		DepartamentoDTO departamentoDto = service.obtener(id);
		if (departamentoDto != null) {
			return new ResponseEntity<DepartamentoDTO>(departamentoDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<DepartamentoDTO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<Void> registrar(@RequestBody DepartamentoDTO departamentoDto) {
		service.registrar(departamentoDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody DepartamentoDTO departamentoDto) {
		if (service.obtener(departamentoDto.getId()) != null) {
			service.actualizar(departamentoDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		if (service.obtener(id) != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
