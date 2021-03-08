package com.holland.firegram.services;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import com.holland.firegram.dao.UserRepository;
import com.holland.firegram.entities.User;

@Service
@Transactional   
public class UserService {
		
		
		private UserRepository userRepository;
		private PasswordEncoder pswdEncoder;
		
		@Autowired
		public UserService(UserRepository userRepository, PasswordEncoder pswdEncoder) {
			this.userRepository = userRepository;
			this.pswdEncoder = pswdEncoder;
		}
		
		public void save(MultipartFile file, String username,String email ,String password)
		{
			User newUser = new User();
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if(fileName.contains(".."))
			{
				System.out.println("not a a valid file");
			}
			try {
				//set profile picture
				newUser.setProfileImage(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//set user name, email, and password
	        newUser.setUsername(username);
	        newUser.setEmail(email);
	        newUser.setPassword(pswdEncoder.encode(password));
			//userRepository.save(newUser);
		    userRepository.save(newUser);
		}
		
		public User findByUsername(String username) {
			return userRepository.findByUsername(username);
		}
	
}

