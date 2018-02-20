package com.patrickcarmo.chatmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrickcarmo.chatmongo.domain.Post;
import com.patrickcarmo.chatmongo.repository.PostRepository;
import com.patrickcarmo.chatmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Post post = repository.findOne(id);
		if(post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		return post;
	}
	
	public List<Post> findByTitle(String text){
		//return repository.findByTitleContainingIgnoreCase(text);
		return repository.searchTitle(text);
	}
	
}