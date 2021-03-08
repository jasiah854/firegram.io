package com.holland.firegram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.holland.firegram.entities.Post;
import com.holland.firegram.services.PostService;
import com.holland.firegram.services.UserService;

@Controller
public class ProfileController {
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public String showHomePage( Model model, Authentication authentication) {
	model.addAttribute("currentUser", userService.findByUsername(authentication.getName()));		
	List<Post> post = postService.getAllPost(authentication.getName());
	model.addAttribute("post", post);
 
	return "authenticated/profile";
	}
	
	@GetMapping("/addpost/{username}")
	public String addPost(Model model, Authentication authentication, Post post) {
	model.addAttribute("currentUser", userService.findByUsername(authentication.getName()));	
	return "authenticated/add-post";
	}
	
	@PostMapping("/addpost/{username}")
	public String savepost(@RequestParam("file") MultipartFile file,
    @PathVariable("username") String username, @RequestParam String posttitle,  @RequestParam String caption) {
	postService.saveNew(username, posttitle, caption, file);	
	return "redirect:/";	
	}
	
	
	
	@GetMapping("/editpost/{id}")  
	public String editPost(@PathVariable(name = "id") Integer id, Model model) {
	Post post = postService.getById(id);
	System.out.println(post.equals(null));
	model.addAttribute("post", post);	
			
	return "authenticated/edit-post";       
	}
	
	@PostMapping("/editpost")  
	public String editUpdatePost(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id, 
	@RequestParam ("username") String username, @RequestParam String posttitle,  @RequestParam String caption) {
			
	postService.saveUpdate(id, username, posttitle, caption, file);
				
	return "redirect:/";       
	} 
		
	
	 
		@GetMapping("/deletepost/{id}")  
		public String deletePost(@PathVariable(name = "id") Integer id) {
			postService.deleteById(id);
		    return "redirect:/";       
		}  
	
		
		
		@GetMapping("/about")  
		public String about() {
		return "authenticated/about";
		}

	
}
