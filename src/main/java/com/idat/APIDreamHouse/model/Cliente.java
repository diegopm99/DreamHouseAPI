package com.idat.APIDreamHouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long idCliente;
	
	private Boolean estado;
	
	@OneToOne
	@JoinColumn(name = "id_usuario",
				nullable = false,
				foreignKey = @ForeignKey(name="FK_cliente_id_usuario")
	)
	private Usuario usuario;
}
