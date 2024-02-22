package com.example.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// we are writing this controller class for mapping purfes only
@Controller
public class NavController {
	
	//by using this annotation we are mapping this with  hiperlink in index.html 
	@GetMapping("/map-register")
	public String registerMapping()
	{
		// it will take to register.html page
		return "register";
	}
	
	
	@GetMapping("/map-login")
	public String loginMappig()
	{
		//it will take control to the login.html page
		return "login";
	}
	
	@GetMapping("/map-songs")
	public String mapSongs()
	{
		return "addsongs";
	}
	
	@GetMapping("/samplePayment")
	public String samplePayment()
	{
		return "samplePayment";
	}
	
	@GetMapping("/map-logout")
	public String mapLogout()
	{
		return "logout";
	}
	
	@GetMapping("/map-home")
	public String homeMapping()
	{
		// it will take to register.html page
		return "index";
	}
	
	@GetMapping("/map-aboutus")
	public String aboutusMapping()
	{
		// it will take to register.html page
		return "about";
	}
	
	/*
	@GetMapping("/map-update")
	public String uodateSong(){
		return "update";
	}

	*/
	
	
	
}
