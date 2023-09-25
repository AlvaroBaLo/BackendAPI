package com.gestion.users.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.users.model.User;
@Repository ("userRepository")
public interface UserRespository extends JpaRepository<User, Serializable> {
	
 public List<User> findByMailAndUser(String mail, String password);
}
