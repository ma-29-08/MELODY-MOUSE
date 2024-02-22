package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.Songs;
import com.example.tunehub.repositories.SongsRepository;

@Service
public class SongsServiceImplementation implements SongsService
{
	@Autowired
	SongsRepository sgrepo;

	//providing the body for unimplemented addsongs method 
	@Override
	public String addSongs(Songs song) {
		
		//adding the songs by using save() method present in jpa repository
		sgrepo.save(song);
		return "song is adedd";
	}

	
	//method body for song exists methods 
	@Override
	public boolean songExists(String name) {
		//if  song name is null returning false 
		if(sgrepo.findByName(name) == null)
		{
			return false;
		}
		//if song is already exists returning true
		else
		{
			return true;
		}
}
	
	//method body for fetching all the songs 

	@Override
	public List<Songs> fetchAllSongs() {
		//finding all the songs by using findAll() method
		List<Songs> songslist = sgrepo.findAll();
		//returning the song list
		return songslist;
	}


	
	//method body for updating the songs after creating the playlist
	@Override
	public void updateSong(Songs song) {
		sgrepo.save(song);
		
	}


	

	
}
