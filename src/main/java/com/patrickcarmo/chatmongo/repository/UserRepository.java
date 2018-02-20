package com.patrickcarmo.chatmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.patrickcarmo.chatmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
