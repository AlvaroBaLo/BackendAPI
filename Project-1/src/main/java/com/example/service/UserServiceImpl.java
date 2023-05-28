package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserService {
	
	

	    @Autowired
	    private UserRepository userRepository;

	    public User getUserById(Long id) {
	        return userRepository.findById(id).orElse(null);
	    }

	    public User createUser(User user) {
	       
	        return userRepository.save(user);
	    }

	    public User updateUser(User user) {
	   
	        return userRepository.save(user);
	    }

	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }

		@Override
		public List<User> obteberTodo() {
		
			return userRepository.findAll();
		}

		
	

	
	}


