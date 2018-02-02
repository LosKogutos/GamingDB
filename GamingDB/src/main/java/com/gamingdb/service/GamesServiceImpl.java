package com.gamingdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamingdb.model.Game;
import com.gamingdb.model.UserProfile;
import com.gamingdb.repository.GamesRepository;
import com.gamingdb.repository.LoginRepository;

@Service("gamesService")
public class GamesServiceImpl implements GamesService {
	
	@Autowired
	private GamesRepository gamesRepository;
	
	@Autowired 
	private LoginRepository loginRepository;

	@Transactional
	public List<Game> fetchAll() {
		System.out.println("fetchAll called");
		return gamesRepository.findAll();
	}

	@Transactional
	public void addGame(Game game) {
		System.out.println("addGame called");
		
		// bind game with user		
		UserProfile user = getAuthenticatedUser();
		game.setUser(user);
		
		// save
		gamesRepository.save(game);
		
	}

	@Transactional
	public List<Game> fetchById() {
		String username = getAuthenticatedUser().getUsername();
		return gamesRepository.findByUser_Username(username);
	}
	
	@Transactional
	private UserProfile getAuthenticatedUser () {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Optional<UserProfile> checkUser = loginRepository.findById(username);
		if (checkUser.isPresent()) {
			return checkUser.get();
		} else {
			return null; 
		}
	}

	@Transactional
	public void deleteGameById(Long deleteGameId) {
		gamesRepository.deleteById(deleteGameId);	
	}
}
