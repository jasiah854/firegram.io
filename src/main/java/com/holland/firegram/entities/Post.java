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
public class Post{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer id;
	
	@NotNull
	@Column(name= "username")
	private String username;
	
	@NotNull
	@Column(name= "posttitle")
	private String posttitle;
	
	@Lob
	@Column(name= "caption")
	private String caption;
	@Lob
	@Column(name = "image", columnDefinition = "MEDIUMBLOB", nullable = false)
	private String image; 
	
	
	public Post() { super();}
	public Post(Integer id, String username, String posttitle, String caption, String image) {
		super();
		this.id = id;
		this.username = username;
		this.posttitle = posttitle;
		this.caption = caption;
		this.image = image;
	}


	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}


	public void setCaption(String caption) {
		this.caption = caption;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
}// end of entity 
