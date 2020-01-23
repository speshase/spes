/*package com.spes.controller;

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
public class QuestionsController {
	
	@Autowired
	private CustomerService cservice;
	
	private static final Logger logger =
			LoggerFactory.getLogger(QuestionsController.class);
	
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
		cservice.qestionsWrite(qca);
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsModify", method = RequestMethod.GET) //자주묻는 질문 + 글수정 보기
	public String questionsModify(CategoryVO qca, Model model) throws Exception {
		logger.info("customer/questionsModify.jsp");
		model.addAttribute("modify",cservice.questionsModify(qca.getQno()));
		return "customer/questionsModify";
	}
	
	@RequestMapping(value="/questionsModify", method = RequestMethod.POST) //자주묻는 질문 + 글수정 완료
	public void questionsModifyPost(CategoryVO qca, Model model) throws Exception {
		logger.info("customer/questionsModifyPost.jsp");
		model.addAttribute("modifyPost",cservice.questionsModify(qca.getQno()));
	}
	
	@RequestMapping(value="/questionsDelete", method = RequestMethod.GET) //자주묻는 질문 + 글삭제
	public String questionsDelete(CategoryVO qca, Model model) throws Exception {
		logger.info("customer/questionsDelete.jsp");
		cservice.questionsDelete(qca);
		return "redirect:questionsList";
	}
}*/
