package com.example.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entities.Songs;

//repo is extending from the jpa repo so that we can use inbuilt methods
public interface SongsRepository extends JpaRepository<Songs,Integer>
{
	
	//method for finding the songs exists or not using the name
	public Songs findByName(String name);

	 }
