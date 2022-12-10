package com.idat.APIDreamHouse.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.APIDreamHouse.dto.UsuarioDTO;
import com.idat.APIDreamHouse.model.Rol;
import com.idat.APIDreamHouse.model.Usuario;
import com.idat.APIDreamHouse.repository.UsuarioRepository;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByCorreo(username);
		if (usuario != null) {
			List<GrantedAuthority> listaRoles = obtenerAuthorities(usuario.getRoles());
			return new User(usuario.getCorreo(), usuario.getContrasenia(), listaRoles);
		} else {
			throw new UsernameNotFoundException("El usuario ingresado no existe");
		}
	}

	private List<GrantedAuthority> obtenerAuthorities(List<Rol> roles) {
		List<GrantedAuthority> listaAuthorities = new ArrayList<>();
		GrantedAuthority authority;
		for (Rol rol : roles) {
			authority = new SimpleGrantedAuthority(rol.getNombre());
			listaAuthorities.add(authority);
		}
		return listaAuthorities;
	}

	public UsuarioDTO obtenerUsuarioLogueado() {
        Usuario usuario;
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        usuario = repository.findByCorreo(userDetail.getUsername());
        UsuarioDTO usuarioDto = new UsuarioDTO();
        List<Rol> listaRoles = null;
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
        return usuarioDto;
    }
	
}
