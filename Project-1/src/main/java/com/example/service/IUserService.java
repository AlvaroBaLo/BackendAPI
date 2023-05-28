package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface IUserService {

	public List<User> obteberTodo();

	public User getUserById(Long id);

	public User createUser(User user);

	public User updateUser(User user);

	public void deleteUser(Long id);
}
