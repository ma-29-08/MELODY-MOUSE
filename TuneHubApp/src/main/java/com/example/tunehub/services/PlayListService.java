package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entities.PlayList;

public interface PlayListService {

	//creating our own method for adding the play list
	public void addPlaylist(PlayList playlist);

	
	//creang our own method for viewing all the play lists
	public List<PlayList> fetchPlaylists();
	
}

