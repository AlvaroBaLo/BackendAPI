package com.gestion.users.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = " users_security")
public class User {
	@Id
	@Column(name = "user_id", length = 60, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 60, nullable = false)
	private String apellido;

	@Column(name = "alias", length = 60, nullable = false, unique = true)
	private String alias;

	@Column(name = "mail", length = 60, nullable = false, unique = true)
	private String mail;

	@Column(name = "password")
	private String password;

	@Column(name = "fecha_nac")
	private LocalDate fecha_nac;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public User(Long id, String nombre, String apellido, String alias, String mail, String password,
			LocalDate fecha_nac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.alias = alias;
		this.mail = mail;
		this.password = password;
		this.fecha_nac = fecha_nac;
	}

	public User() {
		super();
	}

}
