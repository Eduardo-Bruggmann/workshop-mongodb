package com.workshop.workshop_mongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.workshop_mongodb.domain.Post;
import com.workshop.workshop_mongodb.repository.PostRepository;
import com.workshop.workshop_mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> p = repo.findById(id);
		return p.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitle(String text) {
//		return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
