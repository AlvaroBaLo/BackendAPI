package com.gestion.empleados.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.empleados.modelo.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	 public User findByNombre(String nombre);

}
