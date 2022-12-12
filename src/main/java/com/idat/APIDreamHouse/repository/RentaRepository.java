package com.idat.APIDreamHouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.APIDreamHouse.model.Contrato;
import com.idat.APIDreamHouse.model.Renta;

public interface RentaRepository extends JpaRepository<Renta, Long>{
	
	List<Renta> findByContrato(Contrato contrato);
}
