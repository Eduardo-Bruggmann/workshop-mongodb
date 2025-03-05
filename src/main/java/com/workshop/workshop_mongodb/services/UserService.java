package com.workshop.workshop_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.workshop_mongodb.domain.User;
import com.workshop.workshop_mongodb.repository.UserRepository;
import com.workshop.workshop_mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> u = repo.findById(id);
		return u.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
}
