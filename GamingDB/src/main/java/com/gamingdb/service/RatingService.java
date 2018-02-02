package com.gamingdb.service;

public interface RatingService {

	Double calcAverageRating(Long id);

	void addRating(Long id, String value);
}
