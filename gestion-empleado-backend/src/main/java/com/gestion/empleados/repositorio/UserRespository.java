package com.gestion.empleados.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.empleados.modelo.User;

public interface UserRespository extends JpaRepository<User, Long> {

}
