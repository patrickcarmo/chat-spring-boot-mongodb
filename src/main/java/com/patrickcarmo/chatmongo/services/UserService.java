package com.patrickcarmo.chatmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrickcarmo.chatmongo.domain.User;
import com.patrickcarmo.chatmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repository.delete(id);
	}
	
	public User update(User obj) {
		User newObj = repository.findOne(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}