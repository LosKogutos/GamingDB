package com.gamingdb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamingdb.model.Authority;
import com.gamingdb.model.UserProfile;
import com.gamingdb.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Transactional
	public boolean createAccount(UserProfile up) {
		System.out.println("LoginService.createAccount method called\n");

		//check if username is already taken
		Optional<UserProfile> user = loginRepository.findById(up.getUsername());
		if(user.isPresent()) { 
			return false;
		}
		
		//encode the password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		up.setPassword(encoder.encode(up.getPassword()));

		//bind authority with user
		Authority authority = new Authority();
		authority.setAuthority(Authority.ROLE_USER);
		authority.setUser(up);
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(authority);
		
		up.setAuthorities(authorities);
		up.setEnabled(true);
		
		//save
		if (loginRepository.save(up)!=null) {
			return true;
		} else { 
			return false;
		}
	}
}

