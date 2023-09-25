package com.gestion.empleados.controlador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.modelo.Post;
import com.gestion.empleados.repositorio.PostRespository;

@RestController
@CrossOrigin
@RequestMapping("/api/posts")
public class PostController {

	private final PostRespository posts;

	public PostController(PostRespository posts) {
		this.posts = posts;
	}

	@GetMapping
	public Iterable<Post> findAll() {
		return posts.findAll();

	}

	@GetMapping("/{id}")
	public Post findById(@PathVariable("id") Post post) {
		return post;
	}

}
