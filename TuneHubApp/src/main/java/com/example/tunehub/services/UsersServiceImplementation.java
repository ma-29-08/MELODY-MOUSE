package com.example.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.tunehub.entities.Users;
import com.example.tunehub.repositories.UsersRepository;


//in this class we will provide body to the abstract methods which are present inside the service class
//this annotation represents that this is a service class
@Service
public class UsersServiceImplementation implements UsersService
{
	//getting connected with the repository
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		//creating and adding the user to the database
		repo.save(user);
		return "user is created and saved";
	}

	@Override
	//checking the email is exists are not
	public boolean emailExists(String email) {

		if (repo.findByEmail(email)== null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	//entered email and password are passed inside the parameters
	public boolean validateUser(String email, String password) {
		//getting the user usig the method
		Users user=repo.findByEmail(email);
		//storing password of the user inside the db 
		String db_password =user.getPassword();
		//checking the entered password with db password
		if (db_password.equals(password)){
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getRole(String email) {

		//here we r 1st getting user by using the findByEmail and then we r getting the role of that user n finally returning it
		return (repo.findByEmail(email).getRole());
		
	}

	
	
	//overriding the method of service class 
	
	@Override
	public Users getUser(String email) {
				//getting the user object by findbyemail method 
		return repo.findByEmail(email);
	}

	
	//method for updating the user as premium customer
	@Override
	public void updateUser(Users user) {
		repo.save(user);		
	}

		
	

	
		
		
	




}
