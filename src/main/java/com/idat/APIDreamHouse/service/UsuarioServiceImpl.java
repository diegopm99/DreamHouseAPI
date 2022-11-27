package com.idat.APIDreamHouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.APIDreamHouse.dto.UsuarioDTO;
import com.idat.APIDreamHouse.model.Usuario;
import com.idat.APIDreamHouse.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public List<UsuarioDTO> listar() {
		List<UsuarioDTO> listaDto = new ArrayList<>();
		UsuarioDTO usuarioDto = null;
		for (Usuario usuario : repository.findAll()) {
			usuarioDto = new UsuarioDTO();
			usuarioDto.setIdUsuario(usuario.getIdUsuario());
			usuarioDto.setNombres(usuario.getNombres());
			usuarioDto.setApellidos(usuario.getApellidos());
			usuarioDto.setDni(usuario.getDni());
			usuarioDto.setGenero(usuario.getGenero());
			usuarioDto.setTelefono(usuario.getTelefono());
			usuarioDto.setCorreo(usuario.getCorreo());
			usuarioDto.setContrasenia(usuario.getContrasenia());
			listaDto.add(usuarioDto);
		}
		return listaDto;
	}

	@Override
	public UsuarioDTO obtener(Long id) {
		Usuario usuario = repository.findById(id).orElse(null);
		UsuarioDTO usuarioDto = null;
		
		if(usuario != null) {
		usuarioDto = new UsuarioDTO();
		usuarioDto.setIdUsuario(usuario.getIdUsuario());
		usuarioDto.setNombres(usuario.getNombres());
		usuarioDto.setApellidos(usuario.getApellidos());
		usuarioDto.setDni(usuario.getDni());
		usuarioDto.setGenero(usuario.getGenero());
		usuarioDto.setTelefono(usuario.getTelefono());
		usuarioDto.setCorreo(usuario.getCorreo());
		usuarioDto.setContrasenia(usuario.getContrasenia());
		}
		return usuarioDto;
	}

	@Override
	public void registrar(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setNombres(usuarioDto.getNombres());
		usuario.setApellidos(usuarioDto.getApellidos());
		usuario.setDni(usuarioDto.getDni());
		usuario.setGenero(usuarioDto.getGenero());
		usuario.setTelefono(usuarioDto.getTelefono());
		usuario.setCorreo(usuarioDto.getCorreo());
		usuario.setContrasenia(usuarioDto.getContrasenia());
		repository.save(usuario);
	}

	@Override
	public void actualizar(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuarioDto.getIdUsuario());
		usuario.setNombres(usuarioDto.getNombres());
		usuario.setApellidos(usuarioDto.getApellidos());
		usuario.setDni(usuarioDto.getDni());
		usuario.setGenero(usuarioDto.getGenero());
		usuario.setTelefono(usuarioDto.getTelefono());
		usuario.setCorreo(usuarioDto.getCorreo());
		usuario.setContrasenia(usuarioDto.getContrasenia());
		repository.saveAndFlush(usuario);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

}
