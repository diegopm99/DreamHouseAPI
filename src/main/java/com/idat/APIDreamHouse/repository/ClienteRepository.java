package com.idat.APIDreamHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idat.APIDreamHouse.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Modifying
	@Query(value="delete from Cliente c where c.idCliente = :id")
	public void eliminarPorId(@Param("id") Long id);
}
