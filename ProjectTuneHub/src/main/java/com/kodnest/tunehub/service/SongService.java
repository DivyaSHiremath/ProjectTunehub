package com.kodnest.tunehub.service;


import java.util.List;

import com.kodnest.tunehub.entity.Song;

public interface SongService {

	public String addsong(Song song);

	public List<Song> fetchAllSongs();

	public boolean songExists(String name);

	
	

}
