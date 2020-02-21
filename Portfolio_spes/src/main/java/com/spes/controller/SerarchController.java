package com.spes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spes.model.Criteria;
import com.spes.service.SearchService;

@Controller
public class SerarchController {
	
	@Autowired	
	private SearchService sService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//검색기능
	@RequestMapping(value="main/searchResult", method = RequestMethod.GET)
	public String home(String keyword, Model model) throws Exception {
		logger.info("searchResult Controller *-*-*");
		logger.info("keyword="+keyword);
		
		model.addAttribute("keyword", sService.searchList(keyword));
		return "main/searchResult";
	}

}