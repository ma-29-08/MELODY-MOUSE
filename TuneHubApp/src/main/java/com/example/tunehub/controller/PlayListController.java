package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.entities.Songs;
import com.example.tunehub.services.PlayListService;
import com.example.tunehub.services.SongsService;

@Controller
public class PlayListController {
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongsService sserv;
	@GetMapping("/map-playlist")
	public String createPlayList(Model model)
	{
		
		//fetching the songs using song service 
		List<Songs> songslist= sserv.fetchAllSongs();
		
		//adding the songs in model 
		 model.addAttribute("songslist", songslist);
		 
		 //returning the html page
		 return "createplaylist";
	}
	
	//creating the playlist by adding the songs
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute PlayList playlist) {
		//adding the play list
		pserv.addPlaylist(playlist);
		
		//update song table 
		List<Songs> songsList = playlist.getSongs();
		
		
		//traversing the each songs songs to get the play list
		for(Songs song : songsList)
		{
			//getting play list of the song and adding it to the play list
			song.getPlaylist().add(playlist);
			//after adding the play list updating the songs table 
			sserv.updateSong(song);
		}
		
		return "playlistsuccess";
	}
	
	
	// method for viewing the play lists
	@GetMapping("/map-viewplaylist")
	public String viewPlaylists(Model model)
	{
		//using the service class fetching all the play lists 
		List <PlayList> plist = pserv.fetchPlaylists();
		//model is used to connect the back end with front end
		model.addAttribute("plist", plist);
		//System.out.println(plist);
		//returning the htm page with data 
		return "displayplaylist";
		
	}
	
	
	@GetMapping("/exploreplaylist")
	public String viewCustPlyalists(Model model)
	{
		List <PlayList> plist = pserv.fetchPlaylists();
		//model is used to connect the back end with front end
		model.addAttribute("plist", plist);
		//System.out.println(plist);
		//returning the htm page with data 
		return "displaycustplaylist";
		
	}

}
