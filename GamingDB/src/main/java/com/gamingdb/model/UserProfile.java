package com.gamingdb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users")
public class UserProfile  {

	@Id 
	@NotEmpty(message = "Username can not be empty")
	private String username;
	@NotEmpty(message = "Password can not be empty")
	private String password;
	@NotEmpty
	@Email(message = "Email can not be empty")
	private String email;
	@NotEmpty(message = "Name can not be empty")
	private String name;
	@NotEmpty(message = "Surname can not be empty")
	private String surname;
	private boolean enabled;
	
	@OneToMany(mappedBy="user" , cascade=CascadeType.REMOVE)
	private List<Game> games;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
	private List<Authority> authorities;
	
	@OneToMany(mappedBy= "user", cascade=CascadeType.REMOVE)
	private List<Rating> ratings;

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}



	
}
