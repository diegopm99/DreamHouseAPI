package com.idat.APIDreamHouse.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.APIDreamHouse.dto.ContratoDTO;
import com.idat.APIDreamHouse.dto.DepartamentoDTO;
import com.idat.APIDreamHouse.dto.RentaDTO;
import com.idat.APIDreamHouse.model.Contrato;
import com.idat.APIDreamHouse.service.ContratoService;
import com.idat.APIDreamHouse.service.DepartamentoService;
import com.idat.APIDreamHouse.service.RentaService;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	private ContratoService service;

	@Autowired
	private RentaService rentaService;
	
	@Autowired
	private DepartamentoService departamentoService;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ContratoDTO>> listar() {
		return new ResponseEntity<List<ContratoDTO>>(service.listar(), HttpStatus.OK);
	}

	@RequestMapping(path = "/obtener/{id}", method = RequestMethod.GET)
	public ResponseEntity<ContratoDTO> obtener(@PathVariable Long id) {
		ContratoDTO contratoDto = service.obtener(id);
		if (contratoDto != null) {
			return new ResponseEntity<ContratoDTO>(contratoDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<ContratoDTO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<Void> registrar(@RequestBody ContratoDTO contratoDto) {
		try {
			Contrato contrato = service.registrar(contratoDto);
			if (contrato != null) {
				DepartamentoDTO departamentoDto = departamentoService.obtener(contratoDto.getDepartamento().getIdDepartamento());
				crearRentas(contrato, departamentoDto);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ContratoDTO contratoDto) {
		if (service.obtener(contratoDto.getId()) != null) {
			service.actualizar(contratoDto);
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

	private void crearRentas(Contrato contrato, DepartamentoDTO departamentoDTO) {
		RentaDTO rentaDto;
        Date fechaRenta = contrato.getFecha();
        Integer estadia = contrato.getEstadia();
        Calendar c = Calendar.getInstance();

        for (int i = 0; i < estadia; i++) {
            c.setTime(fechaRenta);
            c.add(Calendar.MONTH, 1);
            fechaRenta = c.getTime();
            
            rentaDto = new RentaDTO();
            rentaDto.setContrato(contrato);
            rentaDto.setFecha(fechaRenta);
            rentaDto.setEstado("Pendiente");
            rentaDto.setMonto(departamentoDTO.getPrecio());
            
            rentaService.registrar(rentaDto);
        }
	}
}
