package com.holland.firegram.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.holland.firegram.dao.PostRepository;
import com.holland.firegram.entities.Post;

@Service
public class PostService {

	@Autowired
	PostRepository postRepo;
	
    public void saveNew(String username, String posttitle, String caption, MultipartFile file ){
		Post post = new Post();	
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{		
			System.out.println("not a a valid file");
			}
			try {
				//set image
				post.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//set user name, title, and caption
			post.setPosttitle(posttitle);
	        post.setUsername(username);
	        post.setCaption(caption);
	       
		   postRepo.save(post);
		}// end
	
    
    public List<Post> getAllPost(String username) {
		return postRepo.getAllPost(username);
	}


	public void deleteById(Integer id) {
	   postRepo.deleteById(id);
	}


	public Post getById(Integer id) {
	
		return 	postRepo.getById(id);
	}


public void saveUpdate (Integer id, String username, String posttitle, String caption, MultipartFile file ){
	Post post = postRepo.getById(id);	
	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	if(fileName.contains(".."))
		{		
		System.out.println("not a a valid file");
		}
	try {
		//set image
		post.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
	} catch (IOException e) {
		e.printStackTrace();
		}
		//set user name, title, and caption
	post.setPosttitle(posttitle);
    post.setUsername(username);
    post.setCaption(caption);
			       
    postRepo.save(post);
	}// end
	
	
}//end of class


