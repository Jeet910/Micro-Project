
  package com.micro.config;
  
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
  import org.springframework.security.core.userdetails.UserDetailsService; 
  import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.micro.dao.UserRepository;
import com.micro.entities.User;
  
  public class UserDetailsServiceImpl implements UserDetailsService {
	
	  @Autowired
	  private UserRepository userRepository;  
	  
	  @Override 
	  public UserDetails loadUserByUsername(String username) throws
	  UsernameNotFoundException { 
		 
		  //fetching user from database
		  //username is email here
		  
		  User user= userRepository.getUserbyUserName(username);
		  if (user==null)
		  {
			  throw new UsernameNotFoundException("Could not found user!!");
		  }
		  CustomUserDetails customUserDetails = new CustomUserDetails(user);
		  return customUserDetails;
		  }
	  }
 