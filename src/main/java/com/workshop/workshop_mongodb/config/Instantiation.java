package com.workshop.workshop_mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.workshop_mongodb.domain.Post;
import com.workshop.workshop_mongodb.domain.User;
import com.workshop.workshop_mongodb.repository.PostRepository;
import com.workshop.workshop_mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User u1 = new User(null, "Mock 1", "mock1@gmail.com");
		User u2 = new User(null, "Mock 2", "mock2@gmail.com");
		User u3 = new User(null, "Mock 3", "mock3@gmail.com");
		
		Post p1 = new Post(null, sdf.parse("06/03/2025"), "Title 1", "Body 1", u1);
		Post p2 = new Post(null, sdf.parse("06/03/2025"), "Title 2", "Body 2", u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		postRepository.saveAll(Arrays.asList(p1, p2));
	}

}
