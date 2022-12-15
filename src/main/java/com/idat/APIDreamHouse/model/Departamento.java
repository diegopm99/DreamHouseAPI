package com.idat.APIDreamHouse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	private String imagen;
	
	private String descripcion;

	private Boolean estado;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(
			name="id_edificio",
			nullable=false,
			foreignKey = @ForeignKey(name="FK_departamento_id_edificio")
	)
	private Edificio edificio;
	
	@JsonIgnore
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Contrato> contratos;
}
