package com.gamingdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamingdb.model.Game;

@Repository("gamesRepository")
public interface GamesRepository extends JpaRepository<Game, Long> {

	List<Game> findByUser_Username(String username);

}
