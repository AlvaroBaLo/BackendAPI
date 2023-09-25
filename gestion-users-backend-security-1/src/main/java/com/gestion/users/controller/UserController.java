package com.gestion.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.users.exceptions.ResourceNotFoundException;
import com.gestion.users.model.User;
import com.gestion.users.repository.UserRespository;

@RestController
@CrossOrigin ( origins = "http://localhost/4200")
@RequestMapping("/api/v1")

public class UserController {
	
	private final UserRespository userRepo;
	
	public  UserController ( UserRespository userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping( "/users")
	public Iterable<User> findAll(){
		return userRepo.findAll();
	}
	@PostMapping ("/users")
	public User saveUser (@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(("No existe el usuario con ID: " + id)));
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser (@PathVariable Long id, @PathVariable User detailsUser){
		User user =  userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(("No existe el usuario con ID "+ id)));
				user.setNombre(detailsUser.getNombre());
				user.setApellido(detailsUser.getApellido());
				user.setAlias(detailsUser.getAlias());
				user.setMail(detailsUser.getMail());
				user.setFecha_nac(detailsUser.getFecha_nac());
				user.setPassword(detailsUser.getPassword());
				user.setRolIdRol(detailsUser.getRolIdRol());
				
				User updatedUser = userRepo.save(user);
				
				
				return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteUser (@PathVariable Long id) {
		User user = userRepo.findById(id).orElse(null);
		if (user!= null) {
			userRepo.delete(user);
		}
		return user;
		
	}
}
