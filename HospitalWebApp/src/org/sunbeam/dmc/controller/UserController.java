package org.sunbeam.dmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sunbeam.dmc.dto.User;
import org.sunbeam.dmc.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/register")
	public String showNewUserPage( Model map)
	{
		User user = new User();
		map.addAttribute("command", user);
		return "NewUser";
		
	}
	

	@PostMapping("/register")
	public String registerUser( User user)
	{
		service.register(user);
		return "redirect:/user/login";
		
	}
	

	@GetMapping("/login")
	public String showLoginPage( Model map)
	{
		User user = new User();
		map.addAttribute("command", user);
		return "Login";
		
	}
	
	@PostMapping("/login")
	public String ValidateUser( User user)
	{
		User u = service.validate(user.getEmail(), user.getPassword());
		
		if( u != null )
		{
			
			return "redirect:/doctor/doc";
		}
		else
		{
			return "Login";
		}
		
	}
	
	
	
	
	

}
