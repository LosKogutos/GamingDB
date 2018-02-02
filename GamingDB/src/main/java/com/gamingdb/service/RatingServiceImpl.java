package com.gamingdb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamingdb.model.Game;
import com.gamingdb.model.Rating;
import com.gamingdb.model.UserProfile;
import com.gamingdb.repository.GamesRepository;
import com.gamingdb.repository.LoginRepository;
import com.gamingdb.repository.RatingsRepository;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingsRepository ratingsRepository;
	
	@Autowired
	private GamesRepository gamesRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Transactional
	public Double calcAverageRating(Long id) {
		List<Rating> ratings = ratingsRepository.findValuesByGameId(id);
		List<Integer> ratingValues = new ArrayList<Integer>();
		for (Rating rating : ratings) {
			ratingValues.add(rating.getValue());
		}
		if(ratingValues.isEmpty()) {
			return new Double(0);
		} else { 
			return ratingValues.stream().mapToDouble(val -> val).average().getAsDouble();
		}
		
	}

	@Transactional
	public void addRating(Long id, String value) {
		
		//bind rating with game and user
		Rating rating = new Rating();
		rating.setGame(gamesRepository.getOne(id));
		rating.setUser(getAuthenticatedUser());
		rating.setValue(Integer.parseInt(value));
		
		ratingsRepository.save(rating);
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

}
