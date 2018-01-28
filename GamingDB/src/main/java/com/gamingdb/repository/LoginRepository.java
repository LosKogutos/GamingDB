package com.gamingdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamingdb.model.UserProfile;

@Repository
public interface LoginRepository extends JpaRepository<UserProfile, String>{

}
