package com.micro.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.micro.dao.UserRepository;
import com.micro.entities.User;

@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void getUserbyUserName() {
		User user=new User();
		user.setFirstName("akash");
		user.setLastName("singh");
		user.setEmail("mks@gmail.com");
		user.setNumber("1234567890");
		user.setPassword("87654321");
		user.setRole("ROLE_USER");
		userRepository.save(user);
		
		String expected = "singh";
		
		User user1 = userRepository.getUserbyUserName("mks@gmail.com");
		String actual = user1.getLastName();
		
		assertThat(actual).isEqualTo(expected);
	}
}
