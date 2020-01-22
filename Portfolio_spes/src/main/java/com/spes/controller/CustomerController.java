package com.spes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spes.model.CategoryVO;
import com.spes.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cservice;
	
	private static final Logger logger =
			LoggerFactory.getLogger(HomeController.class);
	
	// 이동
	@RequestMapping(value="/delivery", method = RequestMethod.GET) //배송조회
	public String delivery() throws Exception {
		logger.info("customer/delivery.jsp");
		return "customer/delivery";
	}
	
	@RequestMapping(value="/customerService", method = RequestMethod.GET) //고객센터
	public String customerService() throws Exception {
		logger.info("customer/customerService.jsp");
		return "customer/customerService";
	}

	@RequestMapping(value="/questionsList", method = RequestMethod.GET) //자주묻는 질문 + 조회
	public String questionsList(Model model) throws Exception {
		logger.info("customer/questionsList.jsp");
		model.addAttribute("qcatogoryList", cservice.qcategoryList());
		return "customer/questionsList";
	}
	
	@RequestMapping(value="/travisNews", method = RequestMethod.GET) //트라비스 소식
	public String travisNews() throws Exception {
		logger.info("customer/travisNews.jsp");
		return "customer/travisNews";
	}
	
	@RequestMapping(value="/questionsWrite", method = RequestMethod.GET) //자주묻는 질문 + 글쓰기
	public String questionsWrite() throws Exception {
		logger.info("customer/questionsWrite.jsp");
		return "customer/questionsWrite";
	}
	
}
