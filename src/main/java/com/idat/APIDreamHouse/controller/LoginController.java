package com.idat.APIDreamHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.APIDreamHouse.dto.JwtRequest;
import com.idat.APIDreamHouse.dto.JwtResponse;
import com.idat.APIDreamHouse.dto.UsuarioDTO;
import com.idat.APIDreamHouse.security.TokenUtil;
import com.idat.APIDreamHouse.security.UserDetailService;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtil util;

	@Autowired
	private UserDetailService service;

	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest request) throws Exception {
		JwtResponse jwtResponse;
		if(authenticate(request.getUsername(), request.getPassword())) {
			UserDetails user = service.loadUserByUsername(request.getUsername());
			jwtResponse = new JwtResponse(true, util.generateToken(user.getUsername()));
		} else {
			jwtResponse = new JwtResponse(false, null);
		}
		return ResponseEntity.ok(jwtResponse);
	}

	private Boolean authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping(path = "/usuario-logeado", method = RequestMethod.GET)
	public UsuarioDTO obtenerUsuarioLogeado() {
		return service.obtenerUsuarioLogueado();
	}

}
