package com.example.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entities.Users;

//this repository helps us to connect with database 
//creating one interface and extending it from the jpa so that we can use all the methods present inside the jpa repository
public interface UsersRepository extends JpaRepository<Users,Integer>
{
	public Users findByEmail(String email);


	
}
