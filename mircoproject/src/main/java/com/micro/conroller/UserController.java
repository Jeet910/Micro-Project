package com.micro.conroller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.micro.dao.UserRepository;
import com.micro.entities.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@ModelAttribute
	public void addCommonData(Model model ,Principal principal) {
		String userName = principal.getName();
	    User user = this.userRepository.getUserbyUserName(userName);
	    model.addAttribute("user", user);
	}
		
	@GetMapping("/index")
	public ModelAndView dashboard () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("user_dashboard");
	    return modelAndView;
	}
	
	@PostMapping("/update-form")
	public ModelAndView updateUser () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("update_form");
	    return modelAndView;
	}
	
	@PostMapping("/process-update")
	public ModelAndView updateUserSucess (@ModelAttribute User user) {
	    ModelAndView modelAndView = new ModelAndView();
	    this.userRepository.save(user);
	    modelAndView.setViewName("user_dashboard");
	    return modelAndView;
	}
}
