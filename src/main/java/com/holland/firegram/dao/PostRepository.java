package com.holland.firegram.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.holland.firegram.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
	
   @Query(nativeQuery=true, value = "SELECT * FROM POST p Where p.username = :username ORDER BY p.id DESC" )
	public List<Post> getAllPost(@Param("username") String username);
	
	//get post by id 
	@Query(nativeQuery=true, value = "SELECT * FROM POST p Where p.id = :id " )
	public Post getById(@Param("id") Integer id);
		
	
	
}// end
