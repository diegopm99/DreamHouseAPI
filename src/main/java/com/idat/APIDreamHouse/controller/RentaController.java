package com.idat.APIDreamHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.APIDreamHouse.dto.RentaDTO;
import com.idat.APIDreamHouse.service.RentaService;

@RestController
@RequestMapping("/renta")
public class RentaController {

	@Autowired
	private RentaService service;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<RentaDTO>> listar() {
		return new ResponseEntity<List<RentaDTO>>(service.listar(), HttpStatus.OK);
	}

	@RequestMapping(path = "/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<RentaDTO> obtener(@PathVariable Long id) {
		RentaDTO rentaDto = service.obtener(id);
		if (rentaDto != null) {
			return new ResponseEntity<RentaDTO>(rentaDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<RentaDTO>(HttpStatus.NOT_FOUND);
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
	
	@RequestMapping(path = "/pagar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> pagarRenta(@PathVariable Long id) {
		service.pagarRenta(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
