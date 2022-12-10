package com.idat.APIDreamHouse.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.idat.APIDreamHouse.dto.UsuarioDTO;
import com.idat.APIDreamHouse.model.Rol;
import com.idat.APIDreamHouse.model.Usuario;
import com.idat.APIDreamHouse.repository.RolRepository;
import com.idat.APIDreamHouse.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public List<UsuarioDTO> listar() {
		List<UsuarioDTO> listaDto = new ArrayList<>();
		UsuarioDTO usuarioDto = null;
		List<Rol> listaRoles = null;
		for (Usuario usuario : repository.findAll()) {
			usuarioDto = new UsuarioDTO();
			usuarioDto.setId(usuario.getIdUsuario());
			usuarioDto.setNombres(usuario.getNombres());
			usuarioDto.setApellidos(usuario.getApellidos());
			usuarioDto.setDni(usuario.getDni());
			usuarioDto.setGenero(usuario.getGenero());
			usuarioDto.setTelefono(usuario.getTelefono());
			usuarioDto.setCorreo(usuario.getCorreo());
			usuarioDto.setContrasenia(usuario.getContrasenia());
			listaRoles = new ArrayList<>();
			for (Rol rol : usuario.getRoles()) {
				listaRoles.add(rol);
			}
			usuarioDto.setRoles(listaRoles);
			listaDto.add(usuarioDto);
		}
		return listaDto;
	}

	@Override
	public UsuarioDTO obtener(Long id) {
		Usuario usuario = repository.findById(id).orElse(null);
		UsuarioDTO usuarioDto = null;
		List<Rol> listaRoles = null;
		if (usuario != null) {
			usuarioDto = new UsuarioDTO();
			usuarioDto.setId(usuario.getIdUsuario());
			usuarioDto.setNombres(usuario.getNombres());
			usuarioDto.setApellidos(usuario.getApellidos());
			usuarioDto.setDni(usuario.getDni());
			usuarioDto.setGenero(usuario.getGenero());
			usuarioDto.setTelefono(usuario.getTelefono());
			usuarioDto.setCorreo(usuario.getCorreo());
			usuarioDto.setContrasenia(usuario.getContrasenia());
			listaRoles = new ArrayList<>();
			for (Rol rol : usuario.getRoles()) {
				listaRoles.add(rol);
			}
			usuarioDto.setRoles(listaRoles);
		}
		return usuarioDto;
	}

	@Override
	public void registrar(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario();
		Rol rol = rolRepository.findByNombre("ROLE_USER");
		usuario.setNombres(usuarioDto.getNombres());
		usuario.setApellidos(usuarioDto.getApellidos());
		usuario.setDni(usuarioDto.getDni());
		usuario.setGenero(usuarioDto.getGenero());
		usuario.setTelefono(usuarioDto.getTelefono());
		usuario.setCorreo(usuarioDto.getCorreo());
		usuario.setContrasenia(new BCryptPasswordEncoder().encode(usuarioDto.getContrasenia()));
		usuario.setRoles(new ArrayList<>(Arrays.asList(rol)));
		repository.save(usuario);
	}

	@Override
	public void actualizar(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuarioDto.getId());
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

	@Override
	public UsuarioDTO obtenerPorEmail(String email) {
		Usuario usuario = repository.findByCorreo(email);
		UsuarioDTO usuarioDto = null;
		List<Rol> listaRoles = null;
		if (usuario != null) {
			usuarioDto = new UsuarioDTO();
			usuarioDto.setId(usuario.getIdUsuario());
			usuarioDto.setNombres(usuario.getNombres());
			usuarioDto.setApellidos(usuario.getApellidos());
			usuarioDto.setDni(usuario.getDni());
			usuarioDto.setGenero(usuario.getGenero());
			usuarioDto.setTelefono(usuario.getTelefono());
			usuarioDto.setCorreo(usuario.getCorreo());
			usuarioDto.setContrasenia(usuario.getContrasenia());
			listaRoles = new ArrayList<>();
			for (Rol rol : usuario.getRoles()) {
				listaRoles.add(rol);
			}
			usuarioDto.setRoles(listaRoles);
		}
		return usuarioDto;
	}

}
