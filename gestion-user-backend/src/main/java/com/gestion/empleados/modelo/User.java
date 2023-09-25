package com.gestion.empleados.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_security")
public class User implements Serializable{
	

	
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 60)
	private String nombre;

	@Column(name = "apellido", length = 60)
	private String apellido;

	@Column(name = "alias", length = 60)
	private String alias;

	@Column(name = "mail", length = 60, unique = true)
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

	public Integer getRolIdRol() {
		return rolIdRol;
	}

	public void setRolIdRol(Integer rolIdRol) {
		this.rolIdRol = rolIdRol;
	}


	@Column(name = "RolIdRol")
	private Integer rolIdRol;

	
	
	public User() {}

	public User(Long id, String nombre, String apellido, String alias, String mail, String password,
			LocalDate fecha_nac, Integer rolIdRol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.alias = alias;
		this.mail = mail;
		this.password = password;
		this.fecha_nac = fecha_nac;
		this.rolIdRol = rolIdRol;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", alias=" + alias + ", mail="
				+ mail + ", password=" + password + ", fecha_nac=" + fecha_nac + ", rolIdRol=" + rolIdRol + "]";
	}

	
	

	

}
