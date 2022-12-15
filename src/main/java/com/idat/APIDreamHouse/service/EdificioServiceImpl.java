package com.idat.APIDreamHouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.APIDreamHouse.dto.EdificioDTO;
import com.idat.APIDreamHouse.model.Edificio;
import com.idat.APIDreamHouse.repository.EdificioRepository;

@Service
public class EdificioServiceImpl implements EdificioService {

	@Autowired
	private EdificioRepository repository;
	
	
	private String RutaAbsoluta = "http://192.168.1.53:8090/api/imagesEdificio/";
	@Override
	public List<EdificioDTO> listar() {
		List<EdificioDTO> listaDto = new ArrayList<>();
		EdificioDTO edificioDto = null;
		for(Edificio edificio : repository.findAll()) {
			edificioDto = new EdificioDTO();
			edificioDto.setId(edificio.getIdEdificio());
			edificioDto.setPisos(edificio.getPisos());
			edificioDto.setDireccion(edificio.getDireccion());
			edificioDto.setImagen(RutaAbsoluta+edificio.getImagen());
			if (edificioDto.getEstado()!= null) {
				edificioDto.setEstado(edificio.getEstado());
			}else {
				edificio.setEstado(true);
			}
			listaDto.add(edificioDto);
		}
		return listaDto;
	}

	@Override
	public EdificioDTO obtener(Long id) {
		Edificio edificio = repository.findById(id).orElse(null);
		EdificioDTO edificioDto = null;
		if(edificio != null) {
			edificioDto = new EdificioDTO();
			edificioDto.setId(edificio.getIdEdificio());
			edificioDto.setPisos(edificio.getPisos());
			edificioDto.setDireccion(edificio.getDireccion());
			edificioDto.setEstado(edificio.getEstado());
		}
		return edificioDto;
	}

	@Override
	public void registrar(EdificioDTO edificioDto) {
		Edificio edificio = new Edificio();
		edificio.setPisos(edificioDto.getPisos());
		edificio.setDireccion(edificioDto.getDireccion());
		edificio.setEstado(edificioDto.getEstado());
		repository.save(edificio);
	}

	@Override
	public void actualizar(EdificioDTO edificioDto) {
		Edificio edificio = new Edificio();
		edificio.setIdEdificio(edificioDto.getId());
		edificio.setPisos(edificioDto.getPisos());
		edificio.setDireccion(edificioDto.getDireccion());
		edificio.setEstado(edificioDto.getEstado());
		repository.saveAndFlush(edificio);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

}
