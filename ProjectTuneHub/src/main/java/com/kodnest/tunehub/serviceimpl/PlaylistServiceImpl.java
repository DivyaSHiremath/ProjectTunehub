package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.repository.PlayListRepository;
import com.kodnest.tunehub.service.PlaylistService;
@Service
public class PlaylistServiceImpl implements PlaylistService {
	@Autowired
	PlayListRepository playlistRepository;

	@Override
	public void addplaylist(Playlist playlist) {
		playlistRepository.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchAllPlaylist() {
		List<Playlist> playlists=playlistRepository.findAll();
		return playlists;
	}


}
