package com.spes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spes.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private UserService uservice;
	
	private static final Logger logger =
			LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/delivery", method = RequestMethod.GET) //홈(메인)에서 agree.jsp로 이동
	public String delivery() throws Exception {
		logger.info("customer/delivery.jsp");
		return "customer/delivery";
	}
	
	@RequestMapping(value="/customerService", method = RequestMethod.GET) //홈(메인)에서 agree.jsp로 이동
	public String customerService() throws Exception {
		logger.info("customer/customerService.jsp");
		return "customer/customerService";
	}

}
