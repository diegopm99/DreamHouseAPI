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

import com.idat.APIDreamHouse.dto.ClienteDTO;
import com.idat.APIDreamHouse.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> listar() {
		return new ResponseEntity<List<ClienteDTO>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTO> obtener(@PathVariable Long id) {
		ClienteDTO clienteDto = service.obtener(id);
		if (clienteDto != null) {
			return new ResponseEntity<ClienteDTO>(clienteDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteDTO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<Void> registrar(@RequestBody ClienteDTO clienteDto) {
		service.registrar(clienteDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ClienteDTO clienteDto) {
		if (service.obtener(clienteDto.getId()) != null) {
			service.actualizar(clienteDto);
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
