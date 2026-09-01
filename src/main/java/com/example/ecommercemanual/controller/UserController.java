package com.example.ecommercemanual.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommercemanual.entity.User;
import com.example.ecommercemanual.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return ResponseEntity.ok(savedUser);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<User>  getUserByEmail(@PathVariable String email){
		return userService.getUserByEmail(email)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
}
