package com.spes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/detailpage")
public class DetailpageController {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/vegefruit", method = RequestMethod.GET) // 과일/채소
	public String vegefruit() throws Exception {
		logger.info("detailpage/vegefruit.jsp");
		return "detailpage/vegefruit";
	}
	
	@RequestMapping(value="/meatmilk", method = RequestMethod.GET) // 정육/유제품
	public String meatmilk() throws Exception {
		logger.info("detailpage/meatmilk.jsp");
		return "detailpage/meatmilk";
	}
	
	@RequestMapping(value="/seafood", method = RequestMethod.GET) // 수산/건어물
	public String seafood() throws Exception {
		logger.info("detailpage/seafood.jsp");
		return "detailpage/seafood";
	}
	
	@RequestMapping(value="/mealkit", method = RequestMethod.GET) // 밀키트/간편식
	public String mealkit() throws Exception {
		logger.info("detailpage/mealkit.jsp");
		return "detailpage/mealkit";
	}
	
	@RequestMapping(value="/bakery", method = RequestMethod.GET) // 베이커리
	public String bakery() throws Exception {
		logger.info("detailpage/bakery.jsp");
		return "detailpage/bakery";
	}
	
	@RequestMapping(value="/dessert", method = RequestMethod.GET) // 디저트/음료
	public String dessert() throws Exception {
		logger.info("detailpage/dessert.jsp");
		return "detailpage/dessert";
	}

}
