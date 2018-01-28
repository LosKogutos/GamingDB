package com.gamingdb.service;

import java.util.List;

import com.gamingdb.model.Game;

public interface GamesService {

	List<Game> fetchAll();

	void addGame(Game game);

	List<Game> fetchById();

	void deleteGameById(Long deleteGameId);

}
