package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tunehub.entities.Songs;
import com.example.tunehub.entities.Users;
import com.example.tunehub.services.SongsService;
import com.example.tunehub.services.UsersService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
public class UsersController
{
	// we are performing 
	@Autowired
	UsersService userv;
	
	@Autowired
	SongsService songserv;


	//mapping with register 
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)
	{
		//checking the user is exists or not by using email 
		boolean userstatus = userv.emailExists(user.getEmail());
//if the user not exists it will return the register page
		if(userstatus== false)
		{
			userv.addUser(user);
			return "registersuccess";
		}
		//if the user is already exists it will direct to the login page
		else {
			return "registerfail";
		}


	}
	
	//method for getting the role of the user 
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session) {
		boolean loginstatus = userv.validateUser(email, password);
		if(loginstatus == true)
		{
			session.setAttribute("email", email);
			//if the user is admin displaying the  admin page otherwise displaying the customer page
			if(userv.getRole(email).equals("admin"))
			{
				return "adminhome";
			}
			else
			{
				return "customerhome";
			}
		}
		//if the user id not logined correctly redirecting to the login page for again login
			else
			{
				return "loginfail";
			}
		}
	
	
	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false); 
		if (session != null) {
            session.invalidate(); // Invalidate the session
        }
		return "login";
	}
	
	// method for exploring the songs for customer 
	@GetMapping("/exploresongs")
	public String exploreSongs(HttpSession session , Model model) {
		//getting the users by their email id
		
		String email = (String) session.getAttribute("email");
		Users user = userv.getUser(email);
		
		//checking the premium status of the user 
		boolean userStatus = user.isPremium();
		
		//if it is true displaying the songs otherwise displaying the payment page
		if(userStatus == true ) {
			List<Songs> songslist = songserv.fetchAllSongs();
			model.addAttribute("songslist", songslist);
			return "displaysongs";
		}
		else
		{
			return "payment";
		}
	}

	}
