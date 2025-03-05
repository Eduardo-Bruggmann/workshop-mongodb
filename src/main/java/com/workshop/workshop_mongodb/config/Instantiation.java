package com.workshop.workshop_mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.workshop_mongodb.domain.User;
import com.workshop.workshop_mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User u1 = new User(null, "Mock 1", "mock1@gmail.com");
		User u2 = new User(null, "Mock 2", "mock2@gmail.com");
		User u3 = new User(null, "Mock 3", "mock3@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}
