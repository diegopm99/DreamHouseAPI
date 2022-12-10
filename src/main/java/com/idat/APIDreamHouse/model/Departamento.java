package com.idat.APIDreamHouse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_departamento")
	private Long idDepartamento;
	
	private Integer piso;
	
	private Integer numero;
	
	private Integer habitaciones;
	
	private Integer bannos;
	
	private Double area;
	
	private Double precio;
	
	private Boolean estado;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(
			name="id_edificio",
			nullable=false,
			foreignKey = @ForeignKey(name="FK_departamento_id_edificio")
	)
	private Edificio edificio;
}
