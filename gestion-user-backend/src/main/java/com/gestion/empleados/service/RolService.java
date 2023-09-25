package com.gestion.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.modelo.Rol;
import com.gestion.empleados.modelo.User;
import com.gestion.empleados.repositorio.UserRespository;

@RestController
@RequestMapping("/rol")
@CrossOrigin
public class RolService {
	
	 @Autowired
	 UserRespository userRepository;
	 
	 @GetMapping(path = "/buscar")
	 public List<User> getAllRol(){
		 return userRepository.findAll();
	 }

}
