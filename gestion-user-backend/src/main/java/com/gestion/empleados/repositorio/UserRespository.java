package com.gestion.empleados.repositorio;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.modelo.User;
@Repository("userRepository")
public interface UserRespository extends JpaRepository<User, Serializable> {
	
	public default User findByMailAndPassword(String mail, String password) {
		return null;
		
	}
	

}
