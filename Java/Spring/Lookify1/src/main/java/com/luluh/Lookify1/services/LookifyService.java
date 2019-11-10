package com.luluh.Lookify1.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luluh.Lookify1.models.Lookify;
import com.luluh.Lookify1.repositories.LookifyRepository;

@Service
public class LookifyService {
	
    private final LookifyRepository lookifyRepository;
    
    public LookifyService(LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }
    
    public List<Lookify> all() {
        return lookifyRepository.findAll();
    }

    public List<Lookify> topTen(){
		ArrayList<Lookify> topSongs = (ArrayList<Lookify>) lookifyRepository.findAll();
		Collections.sort(topSongs, Comparator.comparingInt(Lookify::getRating).reversed());
		for(int t = 0; t < topSongs.size(); t++) {
			if(t > 9) {
				topSongs.remove(t);
			}
		}
		return topSongs;
	}
    
    public Lookify createLookify(Lookify b) {
        return lookifyRepository.save(b);
    }

	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}

    public Lookify findLookify(Long id) {
        Optional<Lookify> optional = lookifyRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    
    public List<Lookify> findLookifyArtist(String artist, Long id) {
        Optional<Lookify> optional = lookifyRepository.findById(id);
		List<Lookify> songs = new ArrayList<>();

        if(optional.isPresent()) {
            Lookify a = optional.get();
            if(a.getArtist() == artist) {
            	songs.add(a);
            }
        }
        
        return songs;
        
    }
    
    
}
