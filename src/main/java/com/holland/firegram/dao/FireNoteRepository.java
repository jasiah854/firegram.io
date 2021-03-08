package com.holland.firegram.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.holland.firegram.entities.FireNote;


@Repository
public interface FireNoteRepository extends CrudRepository< FireNote, Integer> {
	
	//get all notes associated with user
	@Query(nativeQuery=true, value = "SELECT * FROM fire_note n WHERE n.username = :username" )
	public List<FireNote> getAllNote(@Param("username") String username);
	
	@Query(nativeQuery=true, value = "SELECT * FROM fire_note n WHERE n.id = :id" )
	public FireNote getById(Integer id); 
}
