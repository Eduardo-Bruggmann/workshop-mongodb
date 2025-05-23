package com.workshop.workshop_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.workshop_mongodb.domain.User;
import com.workshop.workshop_mongodb.dto.UserDTO;
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
	
	public User insert(User u) {
		return repo.insert(u);
	}
	
	public User update(User u) {
		User newUser = findById(u.getId());
		updateData(newUser, u);
		return repo.save(newUser);
	}
	
	private void updateData(User newUser, User u) {
		newUser.setName(u.getName());
		newUser.setEmail(u.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO u) {
		return new User(u.getId(), u.getName(), u.getEmail());
	}
}
