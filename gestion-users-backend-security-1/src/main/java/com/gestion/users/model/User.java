package com.gestion.users.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic ( optional = false)
	@Column ( name = "mail")
	private String mail;
	
	@Column(name= "nombre", length = 30)
	private String nombre;
	
	@Column(name= "apellido", length = 30)
	private String apellido;
	
	@Column(name= "alias", length = 30)
	private String alias;
		
	@Column(name= "password", length = 30)
	private String password;
	
	@Column(name= "fecha_nac", length = 30)
	private LocalDate fecha_nac;
	
	@Column(name= "rolIdRol", length = 30)
	private Integer rolIdRol;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public User(String mail, String nombre, String apellido, String alias, String password, LocalDate fecha_nac,
			Integer rolIdRol) {
		super();
		this.mail = mail;
		this.nombre = nombre;
		this.apellido = apellido;
		this.alias = alias;
		this.password = password;
		this.fecha_nac = fecha_nac;
		this.rolIdRol = rolIdRol;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [mail=" + mail + ", nombre=" + nombre + ", apellido=" + apellido + ", alias=" + alias
				+ ", password=" + password + ", fecha_nac=" + fecha_nac + ", rolIdRol=" + rolIdRol + "]";
	}

	
	

}
