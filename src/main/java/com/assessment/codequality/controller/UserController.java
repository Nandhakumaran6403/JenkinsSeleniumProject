package com.assessment.codequality.controller;

import org.springframework.web.bind.annotation.*;

import com.assessment.codequality.model.User;
import com.assessment.codequality.service.UserService;

import java.util.List;

@CrossOrigin("http://localhost:3001,http://localhost:3000, http://localhost:3002,http://localhost:3003")
@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);			
	}

	@PostMapping
	public void createUser(@RequestBody User user) {
		userService.saveAddUser(user);
	}

	@PutMapping("/{id}")
	public void updateUser(@RequestBody User user) {
		userService.updateIdUser(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteIdUser(id);
	}
	
	@GetMapping("/findUser")
	public User getUser() {
		return userService.getUserFind();
	}
}
