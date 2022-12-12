package com.idat.APIDreamHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.APIDreamHouse.model.Cliente;
import com.idat.APIDreamHouse.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long>{

	Contrato findByCliente(Cliente cliente);
}
