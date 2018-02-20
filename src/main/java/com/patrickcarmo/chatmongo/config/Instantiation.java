package com.patrickcarmo.chatmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.patrickcarmo.chatmongo.domain.Post;
import com.patrickcarmo.chatmongo.domain.User;
import com.patrickcarmo.chatmongo.dto.AuthorDTO;
import com.patrickcarmo.chatmongo.repository.PostRepository;
import com.patrickcarmo.chatmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private PostRepository postRepository; 
	
	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.save(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("20/02/2018"), "Partiu cama", "Vou ir dormir, boa noite!", new AuthorDTO(alex));
		Post post2 = new Post(null, sdf.parse("21/02/2018"), "Bom dia", "Hoje eu acordei para sorrir mostrar os dentes!", new AuthorDTO(alex));
		
		postRepository.save(Arrays.asList(post1, post2));
	}

}
