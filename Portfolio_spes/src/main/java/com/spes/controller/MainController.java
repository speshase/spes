package com.spes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spes.service.MainmenuService;

@Controller
public class MainController {
	
	@Autowired		
	private MainmenuService newService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET) //���� ó�� Ȩ(����)
	public String home(Model model) throws Exception {
		logger.info("home.jsp");
		model.addAttribute("allmenu", newService.allmenu());
		return "home";
	}
}
