package com.idat.APIDreamHouse.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "contrato")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contrato")
	private Long idContrato;
	
	private Integer estadia;
	
	private Double garantia;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(
			name="id_cliente",
			nullable=false,
			foreignKey = @ForeignKey(name="FK_contrato_id_cliente")
	)
	private Cliente cliente;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(
			name="id_departamento",
			nullable=false,
			foreignKey = @ForeignKey(name="FK_contrato_id_departamento")
	)
	private Departamento departamento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL)
	private List<Renta> rentas;
	
}
