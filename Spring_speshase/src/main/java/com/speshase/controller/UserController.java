package com.speshase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.speshase.model.LoginVO;
import com.speshase.model.UserVO;
import com.speshase.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET() {
		
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginVO log, Model model) throws Exception {
		System.out.println("-*-*- UserController -*-*-");
		UserVO user = uservice.login(log);
		if(user == null) {return ;}
		model.addAttribute("userVO", user);
	}
}
