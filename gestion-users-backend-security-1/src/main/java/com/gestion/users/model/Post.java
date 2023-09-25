package com.gestion.users.model;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table ( name = "post")

public class Post implements Serializable {

	private static final long serialVersionUID = 3L;

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column (name = "idpost")
	private Integer idPost;
	
	 @Column ( name = "contenido")
	 private String contenido;
	 
	 @OneToMany(mappedBy = "userIduser")
	 private Integer userIdUser;

	public Integer getUserIdUser() {
		return userIdUser;
	}

	public void setUserIdUser(Integer userIdUser) {
		this.userIdUser = userIdUser;
	}

	public Integer getIdPost() {
		return idPost;
	}

	public void setIdPost(Integer idPost) {
		this.idPost = idPost;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	 
	 
}
