package com.gestion.empleados.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.empleados.modelo.Forum;


public interface ForumRepository  extends JpaRepository<Forum, Long>{

}
