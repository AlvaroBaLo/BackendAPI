package com.gestion.empleados.modelo;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "forum")
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tema", length = 60, nullable = false)
	private String tema;

	@Column(name = "titulo", length = 60, nullable = false)
	private String titulo;

	@Column(name = "alias", length = 60, nullable = false)
	private String alias;

	@Column(name = "date", length = 60, nullable = false)
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Forum(Long id, String tema, String titulo, String alias, String date) {
		super();
		this.id = id;
		this.tema = tema;
		this.titulo = titulo;
		this.alias = alias;
		this.date = date;
	}

	public Forum() {
		super();
	}

}
