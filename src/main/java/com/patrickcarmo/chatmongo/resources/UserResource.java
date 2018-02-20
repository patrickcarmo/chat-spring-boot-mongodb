package com.patrickcarmo.chatmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patrickcarmo.chatmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User fulano = new User("1", "Fulano Silva", "fulano@gmail.com");
		User beltrano = new User("2", "Beltrano Pereira", "beltrano@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(fulano, beltrano));
		return ResponseEntity.ok().body(list);
	}
	
}
