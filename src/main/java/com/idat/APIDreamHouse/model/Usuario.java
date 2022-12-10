package com.idat.APIDreamHouse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7822966245086639524L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	private String nombres;
	private String apellidos;
	private String dni;
	private String genero;
	private String telefono;
	private String correo;
	private String contrasenia;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Trabajador trabajador;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Cliente cliente;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name="usuario_rol",
			joinColumns = @JoinColumn(
					name="id_usuario",
					nullable = false,
					foreignKey = @ForeignKey(name="FK_usuario_rol_id_usuario")
			),
			inverseJoinColumns = @JoinColumn(
					name="id_rol",
					nullable = false,
					foreignKey = @ForeignKey(name="FK_usuario_rol_id_rol")
			)
	)
	private List<Rol> roles = new ArrayList<>();
}
