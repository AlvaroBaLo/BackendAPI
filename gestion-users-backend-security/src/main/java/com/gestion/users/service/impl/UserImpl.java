package com.gestion.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gestion.users.dto.UserDTO;
import com.gestion.users.entity.User;
import com.gestion.users.repository.UserRepository;
import com.gestion.users.service.LoginDTO;
import com.gestion.users.service.LoginMessage;
import com.gestion.users.service.UserService;

public class UserImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
//	@Override
//	public String addUser(UserDTO userDTO) {
//		
//		User user = new User(null, null, null, null, null, null, null,	this.passwordEncoder.encode(userDTO.getPassword()));
//	
//		userRepository.save(user);
//		return user.getNombre();
//	}
	@Override
	public String addUser(UserDTO userDTO) {
		
		User user = new User(
				UserDTO.getId(),
				UserDTO.getName(),
				UserDTO.getEmail(),
				UserDTO.getAlias(),
				UserDTO.getMail(),
				
				this.passwordEncoder.encode(userDTO.getPassword())
		
		);
		userRepository.save(user);
		return user.getNombre();
	}

//	@Override
//	public LoginMessage loginUser(LoginDTO loginDTO) {
//		
//		return null;
//	}

	
}
