package com.gestion.users.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.users.model.Rol;
import com.gestion.users.repository.RolRepository;

@RestController
@RequestMapping("/rol")
@CrossOrigin
public class RolService {
	

	RolRepository rolRepository;
	
	@GetMapping("/buscar")
	public List<Rol> getAllRol(){
		return rolRepository.findAll();
	}
	
	@GetMapping("/guardar")
	public Rol saveRol (@RequestBody Rol rol) {
		return rolRepository.save(rol);
	}
	
	

}
