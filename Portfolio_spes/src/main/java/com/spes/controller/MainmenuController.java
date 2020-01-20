package com.spes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mainMenu")
public class MainmenuController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value="/new", method = RequestMethod.GET) //力老 贸澜 权(皋牢_脚惑前)
	public String newpage() throws Exception {
		logger.info("mainManu/new.jsp");
		return "/mainMenu/new";
	}
	
	@RequestMapping(value="/best", method = RequestMethod.GET) //力老 贸澜 权(皋牢)
	public String bestpage() throws Exception {
		logger.info("mainManu/best.jsp");
		return "/mainMenu/best";
	}
	
	@RequestMapping(value="/coupon", method = RequestMethod.GET) //力老 贸澜 权(皋牢)
	public String couponpage() throws Exception {
		logger.info("mainManu/coupon.jsp");
		return "/mainMenu/coupon";
	}
	
	@RequestMapping(value="/event", method = RequestMethod.GET) //力老 贸澜 权(皋牢)
	public String eventpage() throws Exception {
		logger.info("mainManu/event.jsp");
		return "/mainMenu/event";
	}

}
