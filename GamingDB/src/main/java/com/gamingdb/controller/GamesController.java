package com.gamingdb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamingdb.model.Game;
import com.gamingdb.service.GamesService;

@Controller("gamesController")
public class GamesController {
	
	@Autowired
	private GamesService gamesService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getIndex (@ModelAttribute ("game") Game game, Model model) { 
		System.out.println("games controller!");
		List<Game> games = gamesService.fetchAll();
		model.addAttribute("games", games);
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String postIndex (@Valid @ModelAttribute ("game") Game game,
			BindingResult result, Model model) {
		System.out.println("Game title: " + game.getTitle());
		System.out.println("has results: " + result.hasErrors());
		if (result.hasErrors()) {
			model.addAttribute("error", "true");
			return "redirect:/";
		} else {
			gamesService.addGame(game);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/deleteGame", method=RequestMethod.GET)
	public String getDeleteGame (ModelMap model) {
		System.out.println("deleteGames called");
		List<Game> myGames = gamesService.fetchById();
		//myGames.get(1).getId();
		model.addAttribute("games", myGames);
		return "deleteGame";
	}
	
	@RequestMapping(value="/deleteGame", method=RequestMethod.POST)
	public String postDeleteGame (ModelMap model,
			@RequestParam(value="delete") Long deleteGameId) {
		System.out.println("deleteGame called");
		System.out.println("pobrane id: " + deleteGameId);
		
		gamesService.deleteGameById(deleteGameId);
		return "redirect:/deleteGame.html";
	}
	
}
