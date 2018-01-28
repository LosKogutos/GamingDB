package com.gamingdb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gamingdb.model.UserProfile;
import com.gamingdb.service.LoginService;

@Controller("loginController")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLogin (ModelMap model) { 
		System.out.println("getLogin method called");
		return "login";
	}
	
	@RequestMapping(value="/loginFailed", method=RequestMethod.GET)
	public String getLoginFailed (ModelMap model) { 
		System.out.print("getLoginFailed method called");
		model.addAttribute("error", "true");
		return "login";
	}
	
	@RequestMapping(value="/createAccount", method=RequestMethod.GET)
	public String getCreateAccount (@ModelAttribute ("userProfile") UserProfile userProfile) {
		System.out.println("getCreateAccount method called");
		return "createAccount";
	}
	
	@RequestMapping(value="/createAccount", method=RequestMethod.POST)
	public String postCreateAccount (@Valid @ModelAttribute ("userProfile") UserProfile userProfile, 
			BindingResult result, ModelMap model) { 
		System.out.println("postCreateAccount method called");
		System.out.println("   username: " + userProfile.getUsername() +
				" has errors? : " + result.hasErrors());		
		if (result.hasErrors()) {
			return "createAccount";
		} else {
			if (loginService.createAccount(userProfile)) {
				model.addAttribute("accCreated","true");
				return "redirect:login.html";
			} else {
				model.addAttribute("accNotCreated","true");
				return "redirect:login.html";
			}
			
		}
	}
	
}
