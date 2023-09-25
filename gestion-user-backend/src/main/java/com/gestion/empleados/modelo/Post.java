package com.gestion.empleados.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Post {
	
	@Id 
	@GeneratedValue
	private Long id;
	private String title;
	private String slug; 
	private String content;
	private String user;
	private LocalDateTime publicadoEn;
	private LocalDateTime actualizadoEn;
	
	public Post() {}

	public Post(String title, String slug, String content, String user) {
		this.title = title;
		this.slug = slug;
		this.content = content;
		this.user = user;
		this.publicadoEn = LocalDateTime.now();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public LocalDateTime getPublicadoEn() {
		return publicadoEn;
	}

	public void setPublicadoEn(LocalDateTime publicadoEn) {
		this.publicadoEn = publicadoEn;
	}

	public LocalDateTime getActualizadoEn() {
		return actualizadoEn;
	}

	public void setActualizadoEn(LocalDateTime actualizadoEn) {
		this.actualizadoEn = actualizadoEn;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", slug=" + slug + ", content=" + content + ", user=" + user
				+ ", publicadoEn=" + publicadoEn + ", actualizadoEn=" + actualizadoEn + "]";
	}
	
	

}
