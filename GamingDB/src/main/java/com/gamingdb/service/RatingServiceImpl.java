package com.gamingdb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamingdb.model.Rating;
import com.gamingdb.repository.RatingsRepository;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingsRepository ratingsRepository;
	
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

}
