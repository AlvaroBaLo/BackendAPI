package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserServiceImpl;
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@PostMapping("/register")
	public User register(@ModelAttribute User user) {
		return userRepository.save(user);
	}

	@GetMapping("/hola")
	public ResponseEntity<String> index() {
			
		System.out.println("HOLA");
	 return ResponseEntity.ok("HolaMundo"); 
		
	}
	 public static final String FORM_VIEW = "Formulario";
	 @RequestMapping("/Formulario")
	    public String showForm(Model model){
	        model.addAttribute("user", new User());
	        return FORM_VIEW;
	 }

	@PostMapping("/login")
	public String userLogin() {
		return "login";
	}

	@GetMapping("/validado")
	public String validado() {
		return "validado";
	}

	@GetMapping("/clube")
	public String clube() {
		return "clube";
	}


	@Autowired
	private UserServiceImpl userService;

//	@GetMapping("/signup")
//	public ResponseEntity<String> showSignupForm(Model model) {
//		
//		model.addAttribute("user", new User());
//		return ResponseEntity<String>("Formulario");
//	}

	@PostMapping("/signup")
	public String saveUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Formulario";
		}

		userService.createUser(user);
		model.addAttribute("message", "Se ha creado el usuario correctamente!");
		return "redirect:/login";

	}
	@GetMapping("/users")
	public String getAllUsers(Model model) {
	    List<User> userList = userService.obteberTodo();
	    model.addAttribute("users", userList);
	    return "user-list";
	}

}
