package com.holland.firegram.dao;


import org.springframework.data.repository.CrudRepository;

import com.holland.firegram.entities.User;

public interface UserRepository extends CrudRepository<User, String> {
	User findByUsername(String username);
 
}  

