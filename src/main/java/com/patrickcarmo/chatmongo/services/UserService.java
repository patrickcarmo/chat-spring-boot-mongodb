package com.patrickcarmo.chatmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrickcarmo.chatmongo.domain.User;
import com.patrickcarmo.chatmongo.repository.UserRepository;
import com.patrickcarmo.chatmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		User user = repository.findOne(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		return user;
	}
	
}