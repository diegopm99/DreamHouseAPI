package com.idat.APIDreamHouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idat.APIDreamHouse.model.Renta;

public interface RentaRepository extends JpaRepository<Renta, Long>{
	
	@Query(value="select r from Renta r where r.contrato.cliente.idCliente = :id")
	List<Renta> findByCliente(Long id);
}
