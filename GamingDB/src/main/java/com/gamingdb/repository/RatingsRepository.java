package com.gamingdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamingdb.model.Rating;

@Repository("ratingsRepository")
public interface RatingsRepository extends JpaRepository<Rating, Long> {

	@Query("select r from Rating r where r.game.id = :id")
	List<Rating> findValuesByGameId(@Param("id") Long id);

}
