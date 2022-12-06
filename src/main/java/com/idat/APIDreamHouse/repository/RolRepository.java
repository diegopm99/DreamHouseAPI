package com.idat.APIDreamHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.APIDreamHouse.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

	public Rol findByNombre(String rol);
}
