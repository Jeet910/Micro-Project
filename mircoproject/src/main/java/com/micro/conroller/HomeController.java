package com.micro.conroller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.micro.dao.UserRepository;
import com.micro.entities.User;





@RestController
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public ModelAndView index () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("home");
	    return modelAndView;
	}
	
	@GetMapping("/signup")
	public ModelAndView register () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("user",new User());
	    modelAndView.setViewName("signup");
	    return modelAndView;
	}
	
	
	@PostMapping("/do_register")
	public ModelAndView registerSucess (@Valid @ModelAttribute("user") User user, Model model) {
	    ModelAndView modelAndView = new ModelAndView();
	    user.setRole("ROLE_USER");
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    this.userRepository.save(user);
	    modelAndView.setViewName("sucess_register");
	    return modelAndView;
	}
	
	@GetMapping("/signin")
	public ModelAndView customLogin () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("login");
	    return modelAndView;
	}
}
