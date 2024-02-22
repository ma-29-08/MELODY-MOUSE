package com.example.tunehub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.tunehub.entities.Songs;
import com.example.tunehub.services.SongsService;


@Controller
public class SongsController {

	@Autowired
	SongsService sgserv;


	//this method is for adding the unique songs  by checking their name
	@PostMapping("/songs")
	public String addSongs(@ModelAttribute Songs song) {

		//checking for the name of the song
		boolean songstatus = sgserv.songExists(song.getName());
		//if name is null then add the song 
		if(songstatus == false)
		{
			sgserv.addSongs(song);
			//after success control will go to song success html file
			return "songsuccess";
		}
		else
		{
			//is song already exists control will go to the song fail html fail
			return "songfail";
		}


	}


	//this method is for viewing the songs
	@GetMapping("/map-viewsongs")
	public String viewAdminSongs(Model model)
	{

		//we are calling the method which is present in servicempl class and storing in list type reference
		List<Songs> songslist= sgserv.fetchAllSongs();
		//printing all the song list in console
		//System.out.println(songs list objects);

		model.addAttribute("songslist", songslist);
		//it sends controle to display songs html page
		return "displaysongs";
	}

	@GetMapping("/map-viewsongscust")
	public String viewCustomerSongs(Model model){
		boolean primeStatus =false;
		if(primeStatus == true) {
			List<Songs> songslist= sgserv.fetchAllSongs();

			model.addAttribute("songslist", songslist);
			//it sends controle to display songs html page
			return "displaysongs";
		}
		else {
			return "makepayment";
		}
	}
	
	/*
	@PutMapping("/update")
	public String updateSong(@ModelAttribute Songs song) {
	
	//checking for the name of the song
			boolean songstatus = sgserv.songExists(song.getName());
			//if name is null then add the song 
			if(songstatus == false)
			{
				
				//after success control will go to song success html file
				return "songsuccess";
			}
			else
			{
				//is song already exists control will go to the song fail html fail
				return "songfail";
			}

	}
	*/
}






