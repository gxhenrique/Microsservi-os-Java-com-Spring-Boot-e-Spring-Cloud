package com.example.hroauth.services;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hroauth.entities.User;
import com.example.hroauth.userFeingClients.UserFeingClient;

@Service
public class UserServiceClient implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceClient.class);
	
	
	@Autowired
	private UserFeingClient userFeingClient;
	
	public User findByEmail(String email) {
		
		User user = userFeingClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		
		logger.info("Email: " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userFeingClient.findByEmail(username).getBody();
		if(user == null) {
			logger.error("Email not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		
		logger.info("Email: " + username);
		return user;
	}
}
