package com.example.tunehub.services;

import com.example.tunehub.entities.Users;

public interface UsersService {
	
	// creating one abstract method for add user in which using this method we will add the users to the database
	public String addUser(Users user);
	
	// method to check email exists are not 
	public boolean emailExists(String email);
	
	//method to validate user in which user is already present are not 
	public boolean validateUser(String email,String password);
	
	//method to check role of the user
	public String getRole(String email);
	
	//method for getting the user for exploring songs by their email
	public Users getUser(String email);

	//creating the method for updating the user as premium user in the database
	public void updateUser(Users user);

	

}
