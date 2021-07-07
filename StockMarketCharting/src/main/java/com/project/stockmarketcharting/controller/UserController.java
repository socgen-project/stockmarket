package com.project.stockmarketcharting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarketcharting.entity.UserEntity;
import com.project.stockmarketcharting.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) throws Exception {
		user.setUserType("NORMAL");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserEntity createUser = userService.createUser(user);
		return ResponseEntity.ok().body(createUser);

	}

	@GetMapping("/{username}")
	public ResponseEntity<UserEntity> getuser(@PathVariable("username") String username) {
		UserEntity user = userService.getUser(username);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteuser(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body("User with id: " + id + " succesfully deleted");

	}
}
