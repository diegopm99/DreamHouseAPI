package com.idat.APIDreamHouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.APIDreamHouse.dto.ClienteDTO;
import com.idat.APIDreamHouse.model.Cliente;
import com.idat.APIDreamHouse.model.Usuario;
import com.idat.APIDreamHouse.repository.ClienteRepository;
import com.idat.APIDreamHouse.repository.UsuarioRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<ClienteDTO> listar() {
		List<ClienteDTO> listaDto = new ArrayList<>();
		ClienteDTO clienteDTO;
		for (Cliente cliente : clienteRepository.findAll()) {
			clienteDTO = new ClienteDTO();
			clienteDTO.setId(cliente.getIdCliente());
			clienteDTO.setEstado(cliente.getEstado());
			clienteDTO.setUsuario(cliente.getUsuario());
			listaDto.add(clienteDTO);
		}
		return listaDto;
	}

	@Override
	public ClienteDTO obtener(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		ClienteDTO clienteDto = null;
		if (cliente != null) {
			clienteDto = new ClienteDTO();
			clienteDto.setId(cliente.getIdCliente());
			clienteDto.setEstado(cliente.getEstado());
			clienteDto.setUsuario(cliente.getUsuario());
		}
		return clienteDto;
	}

	@Override
	public void registrar(ClienteDTO clienteDto) {
		Cliente cliente = new Cliente();
		Usuario usuario = usuarioRepository.findById(
				clienteDto.getUsuario().getIdUsuario()).orElse(null);
		cliente.setEstado(clienteDto.getEstado());
		cliente.setUsuario(usuario);
		clienteRepository.save(cliente);
	}

	@Override
	public void actualizar(ClienteDTO clienteDto) {
		Cliente cliente = new Cliente();
		Usuario usuario = usuarioRepository.findById(
				clienteDto.getUsuario().getIdUsuario()).orElse(null);
		cliente.setIdCliente(clienteDto.getId());
		cliente.setEstado(clienteDto.getEstado());
		cliente.setUsuario(usuario);
		clienteRepository.saveAndFlush(cliente);
	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		clienteRepository.eliminarPorId(id);
	}

}
