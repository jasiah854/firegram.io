package com.holland.firegram.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table
public class FireNote {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer id;
	
	@NotNull
	@Column(name= "username")
	private String username;
	
	@Lob
	@NotNull
	@Column(name= "textcontent")
	private String textcontent;
  
   public FireNote() {super();}
   public FireNote(Integer id, String username, String textcontent) {
 	super();
	this.id = id;
	this.username = username;
	this.textcontent = textcontent;
   }
   
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getTextcontent() {
	return textcontent;
}
public void setTextcontent(String textcontent) {
	this.textcontent = textcontent;
}

}//end 
