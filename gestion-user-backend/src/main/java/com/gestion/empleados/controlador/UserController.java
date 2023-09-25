 package com.gestion.empleados.controlador;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.excepciones.ResourceNotFoundException;
import com.gestion.empleados.modelo.User;
import com.gestion.empleados.repositorio.UserRespository;

@RestController
@CrossOrigin( origins="http://localhost:4200")
@RequestMapping("/api/v1")

public class UserController {

	
	private final UserRespository userRepository;

	public UserController(UserRespository userRespository) {
		this.userRepository = userRespository;
	}

	// este metodo vuelca todos los datos de los usuarios
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/users")
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	// este metodo sirve para guardar nuevo usuario
	@CrossOrigin("*")
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	// sirve para encontrar un usuario por el id de la bbdd
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(("No existe el usuario con ID: " + id)));
		return ResponseEntity.ok(user);
	}

	// actualizar usuario
	@CrossOrigin("http://localhost:4200/update-user/{id}")
	@PutMapping("users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User detailsUser) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(("No existe el usuario con ID: " + id)));
		user.setNombre(detailsUser.getNombre());
		user.setApellido(detailsUser.getApellido());
		user.setAlias(detailsUser.getAlias());
		user.setFecha_nac(detailsUser.getFecha_nac());
		user.setMail(detailsUser.getMail());
		user.setPassword(detailsUser.getPassword());

		User updatedUser = userRepository.save(user);

		return ResponseEntity.ok(updatedUser);
	}

	// eliminar usuario
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable Long id) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null) {
			userRepository.delete(user);
		}
		return user;

	}

	// login usuario
	@PutMapping("/users/login/{mail}/{password}")
	public ResponseEntity<User> loginUser(@PathVariable("mail") String mail,@PathVariable("password") String password){
		User user = userRepository.findByMailAndPassword(mail, password);
		if (user.)
	}

}
