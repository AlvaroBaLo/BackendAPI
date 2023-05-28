package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String constrasena;
	private String nombre;
	private String apellido;
	private String sexo;
	private LocalDate fecha_nac;

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return username;
	}

	public void setAlias(String alias) {
		this.username = alias;
	}

	public String getConstrasena() {
		return constrasena;
	}

	public void setConstrasena(String constrasena) {
		this.constrasena = constrasena;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public User(Long id, String alias, String constrasena, String nombre, String apellido, String sexo,
			LocalDate fecha_nac) {
		super();
		this.id = id;
		this.username = alias;
		this.constrasena = constrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fecha_nac = fecha_nac;
	}

}
