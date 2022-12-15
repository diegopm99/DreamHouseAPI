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

import com.idat.APIDreamHouse.dto.BasicRequest;
import com.idat.APIDreamHouse.dto.BasicResponse;
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

	@RequestMapping(path = "/obtener", method = RequestMethod.POST)
	public ResponseEntity<RentaDTO> obtener(@RequestBody BasicRequest request) {
		RentaDTO rentaDto = service.obtener(request.getId());
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
	
	@RequestMapping(path = "/pagar", method = RequestMethod.POST)
	public ResponseEntity<?> pagarRenta(@RequestBody BasicRequest request) {
		service.pagarRenta(request.getId());
		return new ResponseEntity<>(new BasicResponse(true), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/rentas-usuario", method = RequestMethod.POST)
	public ResponseEntity<List<RentaDTO>> rentasPorUsuario(@RequestBody BasicRequest request) {
		return new ResponseEntity<List<RentaDTO>>(service.listarPorUsuario(request.getId()), HttpStatus.OK);
	}
}
