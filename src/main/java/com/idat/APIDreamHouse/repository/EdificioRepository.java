package com.idat.APIDreamHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.APIDreamHouse.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}
