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

import com.idat.APIDreamHouse.dto.EdificioDTO;
import com.idat.APIDreamHouse.service.EdificioService;

@RestController
@RequestMapping("/edificio")
public class EdificioController {

	@Autowired
	private EdificioService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<EdificioDTO>> listar() {
		return new ResponseEntity<List<EdificioDTO>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<EdificioDTO> obtener(@PathVariable Long id) {
		EdificioDTO edificioDto = service.obtener(id);
		if (edificioDto != null) {
			return new ResponseEntity<EdificioDTO>(edificioDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<EdificioDTO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<Void> registrar(@RequestBody EdificioDTO edificioDto) {
		service.registrar(edificioDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody EdificioDTO edificioDto) {
		if (service.obtener(edificioDto.getId()) != null) {
			service.actualizar(edificioDto);
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
