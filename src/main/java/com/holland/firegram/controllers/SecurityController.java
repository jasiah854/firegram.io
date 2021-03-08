package com.holland.firegram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.holland.firegram.entities.User;
import com.holland.firegram.services.UserService;

@Controller
public class SecurityController {
	
	private UserService userService; 
	@Autowired
	public SecurityController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
	return "security/login";
	}
	
	@GetMapping("/logout")
	public String showLogout() {
	return "security/login";
	}
	
	//create new user page
	 @GetMapping("/register")
	public String showRegisterPage(Model model) {
	model.addAttribute("newUser", new User());
	return "security/register";
	}	
		
		
	
	// save new user 
	@PostMapping("/register-new-user") 
	public String saveBook(@Validated @RequestParam("file") MultipartFile file,
    		@RequestParam("username") String username,
    		@RequestParam("email") String email,
    		@RequestParam("password") String password){

 	userService.save(file, username, email , password );
	return "redirect:/login";
	} 
	
		
}

