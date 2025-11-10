package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;

@Controller
public class SongController {
	@Autowired
	SongService ss;
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song) {
	String name = song.getName();
	//checking if the email as entered in the registration form is present in DB or not
	boolean status=ss.songExists(name);

	//		System.out.println(user.getUsername()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getGender()+" "+user.getRole()+" "+user.getAddress());
	if(status ==false) {
		ss.addsong(song);
		System.out.println("song added");
	}else {
		System.out.println("song already exist");
	}
	return "Adminhome";
	
	}
	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		List<Song> songlist = ss.fetchAllSongs();
		model.addAttribute("songs",songlist);
		return "displaysongs";
	
}
	@GetMapping("/playsongs")
	public String platsong(Model model) {
		boolean premium= false;
		if(premium) {
		List<Song> songlist = ss.fetchAllSongs();
		model.addAttribute("songs",songlist);
		return "displaysongs";
		} else {
		return "Subscriptionform";	
		}
	
}
}
