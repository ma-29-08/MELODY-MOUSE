package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService {

	@Autowired
	PlayListRepository plrepo;

	
	//method for adding the songs  the play list
	@Override
	public void addPlaylist(PlayList playlist) {
		plrepo.save(playlist);

	}

	//method for viewing the playlist
	@Override
	public List<PlayList> fetchPlaylists() {
		
		
		//find all method is used to view all the play lists
		List <PlayList> plist =plrepo.findAll();
		return plist;
	}

}

