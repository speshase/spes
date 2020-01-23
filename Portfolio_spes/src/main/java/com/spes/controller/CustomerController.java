package com.spes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	/* 자주묻는 질문 */
	
	@RequestMapping(value="/questionsList", method = RequestMethod.GET) //자주묻는 질문 + 글조회
	public String questionsList(Model model) throws Exception {
		logger.info("customer/questionsList.jsp");
		model.addAttribute("qcatogoryList", cservice.questionsList());
		return "customer/questionsList";
	}
	
	@RequestMapping(value="/questionsWrite", method = RequestMethod.GET) //자주묻는 질문 + 글쓰기
	public String questionsWrite() throws Exception {
		logger.info("customer/questionsWrite.jsp");
		return "customer/questionsWrite";
	}
	
	@RequestMapping(value="/questionsWriteEnd", method = RequestMethod.GET) //자주묻는 질문 + 글쓰기(등록)
	public String WriteEnd() throws Exception {
		logger.info("customer/WriteEnd.jsp");
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsWriteEnd", method = RequestMethod.POST) //자주묻는 질문 + 글쓰기(등록)
	public String WriteEndPOST(CategoryVO qca, Model model) throws Exception {
		System.out.println("--- 자주묻는 질문 + 글쓰기 ---");
		logger.info("customer/WriteEndPost.jsp");
		cservice.questionsWrite(qca);
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsModify", method = RequestMethod.GET) //자주묻는 질문 + 글수정 보기
	public void questionsModify(CategoryVO qca, Model model) throws Exception {
		logger.info("customer/questionsModify.jsp");
		model.addAttribute("modify",cservice.questionsModify(qca.getQno()));
		//return "customer/questionsModify";
	}
	
	@RequestMapping(value="/questionsModifyEnd", method = RequestMethod.POST) //자주묻는 질문 + 글수정 완료
	public String questionsModifyEndPOST(CategoryVO qca, RedirectAttributes rttr) throws Exception {
		System.out.println("--- 자주묻는 질문 + 글수정 ---");
		logger.info("customer/questionsModifyPost.jsp");
		logger.info("qca.getQno() = "+qca.getQno()+qca.getQsubject()+qca.getQcontent());
		cservice.questionsModifyEnd(qca);
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsDelete", method = RequestMethod.GET) //자주묻는 질문 + 글삭제
	public void questionsDelete(CategoryVO qca, Model model) throws Exception {
		System.out.println("--- 자주묻는 질문 + 글삭제 ---");
		System.out.println(qca.getQno());
		logger.info("customer/questionsDelete.jsp");
		cservice.questionsDelete(qca); 
	}
	
	/* 트라비스 소식 */
	
	@RequestMapping(value="/travisNews", method = RequestMethod.GET) //트라비스 소식 + 글조회
	public String travisNews() throws Exception {
		logger.info("customer/travisNews.jsp");
		return "customer/travisNews";
	}
	
}
