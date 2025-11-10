package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		//email taken from registration form
		String email = user.getEmail();
		//checking if the email as entered in the registration form is present in DB or not
		boolean status=userServiceImpl.emailExists(email);

		//		System.out.println(user.getUsername()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getGender()+" "+user.getRole()+" "+user.getAddress());
		if(status ==false) {
			userServiceImpl.addUser(user);
			System.out.println("user added");
		}else {
			System.out.println("user already exist");
		}
		
		String role=userServiceImpl.getRole(email);
        if (role.equals("Admin")) {
            return "Adminhome";
        } else {
            return "Customerhome";
        }
    }
   

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,@RequestParam("password") String password ,HttpSession session) {
	    if (userServiceImpl.validateUser(email, password )== true) {
	    	String role=userServiceImpl.getRole(email);
	    	session.setAttribute("email", email);
	        if (role.equals("Admin")) {
	            return "Adminhome";
	        } else {
	            return "Customerhome";
	        }
	    } else {
	            return "Login";
	    }
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session .invalidate();
		return "login";
	}
	
}


	

