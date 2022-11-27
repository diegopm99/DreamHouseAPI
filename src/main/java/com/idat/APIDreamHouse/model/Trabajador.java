package com.idat.APIDreamHouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="trabajador")
public class Trabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_trabajador")
	private Long idTrabajador;
	
	private String cargo;
	
	private Double sueldo;
	
	private Boolean estado;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
}
