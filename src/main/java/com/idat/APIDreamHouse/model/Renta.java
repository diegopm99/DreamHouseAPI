package com.idat.APIDreamHouse.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "renta")
public class Renta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_renta")
	private Long idRenta;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fecha;
	
	private Double monto;
	
	private String estado;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="fecha_pago")
	private Date fechaPago;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(
			name="id_contrato",
			nullable=false,
			foreignKey = @ForeignKey(name="FK_renta_id_contrato")
	)
	private Contrato contrato;
}
