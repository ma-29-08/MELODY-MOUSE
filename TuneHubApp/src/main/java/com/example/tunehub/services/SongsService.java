package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entities.Songs;

public interface SongsService {
	
	//method for adding the songs
	public String addSongs(Songs song);
	
	
	//method for checking song is already present or not by using their name
	public boolean songExists(String name);
	
	
	//method for viewing the songs
	public List<Songs> fetchAllSongs();


	public void updateSong(Songs song);


	
	/*
	 //metod for updating te song when adding the play list 
	 
	public void updateSong(Songs song);
	
	*/
	
}
