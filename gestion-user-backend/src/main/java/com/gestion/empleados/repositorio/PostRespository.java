package com.gestion.empleados.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.gestion.empleados.modelo.Post;

public interface PostRespository extends CrudRepository<Post, Long> {

}
