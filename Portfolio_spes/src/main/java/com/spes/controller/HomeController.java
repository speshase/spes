package com.spes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spes.service.UserService;

@Controller
@RequestMapping("/main")
public class HomeController {
	
	@Autowired
	private UserService uservice;
	
	private static final Logger logger =
			LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value="/spes", method = RequestMethod.GET) //제일 처음 홈(메인)
	public String home() throws Exception {
		logger.info("main/home.jsp");
		return "main/home";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET) //홈(메인)에서 login.jsp로 이동
	public String login() throws Exception {
		logger.info("main/login.jsp");
		return "main/login";
	}
	
	@RequestMapping(value="/agree", method = RequestMethod.GET) //홈(메인)에서 agree.jsp로 이동
	public void agree() throws Exception {
		logger.info("main/agree.jsp");
	}

}
