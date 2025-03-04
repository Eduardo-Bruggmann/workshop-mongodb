package com.workshop.workshop_mongodb.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.workshop_mongodb.domain.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User u1 = new User("1", "Mock User", "mock@gmail.com");
		User u2 = new User("2", "Mock User 2", "mock2@gmail.com");
		List<User> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		return ResponseEntity.ok(list);
	}
}
