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

import com.idat.APIDreamHouse.dto.BasicResponse;
import com.idat.APIDreamHouse.dto.UsuarioDTO;
import com.idat.APIDreamHouse.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> listar() {
		return new ResponseEntity<List<UsuarioDTO>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> obtener(@PathVariable Long id) {
		UsuarioDTO usuarioDto = service.obtener(id);
		if (usuarioDto != null) {
			return new ResponseEntity<UsuarioDTO>(usuarioDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<UsuarioDTO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<Void> registrar(@RequestBody UsuarioDTO usuarioDto) {
		service.registrar(usuarioDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> editar(@RequestBody UsuarioDTO usuarioDto) {
		BasicResponse basicResponse;
		if (service.obtener(usuarioDto.getId()) != null) {
			service.actualizar(usuarioDto);
			basicResponse = new BasicResponse(true);
			return new ResponseEntity<>(basicResponse, HttpStatus.OK);
		} else {
			basicResponse = new BasicResponse(false);
			return new ResponseEntity<>(basicResponse, HttpStatus.NOT_FOUND);
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
