package com.gestion.empleados.controlador;

import java.security.Principal;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.excepciones.ResourceNotFoundException;
import com.gestion.empleados.modelo.User;
import com.gestion.empleados.repositorio.UserRepository;
import com.gestion.empleados.service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@CrossOrigin
	@GetMapping("/users")
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	// este metodo sirve para guardar nuevo usuario
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	 @Autowired
	    UserServiceImpl usuarioService;
	
	//sirve para encontrar un usuario por el id de la bbdd
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(("No existe el usuario con ID: "+ id)));
		return ResponseEntity.ok(user);
	}
	//actualizar usuario
	@CrossOrigin
	@PutMapping(value="/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User detailsUser){
		User user= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(("No existe el usuario con ID: "+ id)));
		user.setNombre(detailsUser.getNombre());
		user.setApellido(detailsUser.getApellido());
		user.setAlias(detailsUser.getAlias());
		user.setFecha_nac(detailsUser.getFecha_nac());
		user.setMail(detailsUser.getMail());
		user.setPassword(detailsUser.getPassword());
		
		User updatedUser = userRepository.save(user);
		
		return ResponseEntity.ok(updatedUser);
	}
	//eliminar usuario
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable Long id){
		User user = userRepository.findById(id).orElse(null);
				if(user!=null) {
					userRepository.delete(user);
				}
		return user;
		
	}
	
	  @RequestMapping("/login")
	    public boolean login(@RequestBody User user) {
	        return
	          user.getUserName().equals("user") && user.getPassword().equals("password");
	    }
		
	    @RequestMapping("/user")
	    public Principal user(HttpServletRequest request) {
	        String authToken = request.getHeader("Authorization")
	          .substring("Basic".length()).trim();
	        return () ->  new String(Base64.getDecoder()
	          .decode(authToken)).split(":")[0];
	    }
	
	
	
}
