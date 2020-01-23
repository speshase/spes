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
	
	@RequestMapping(value="/questionsWrite", method = RequestMethod.GET) //���ֹ��� ���� + �۾���
	public String questionsWrite() throws Exception {
		logger.info("customer/questionsWrite.jsp");
		return "customer/questionsWrite";
	}
	
	@RequestMapping(value="/questionsWriteEnd", method = RequestMethod.GET) //���ֹ��� ���� + �۾���(���)
	public String WriteEnd() throws Exception {
		logger.info("customer/WriteEnd.jsp");
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsWriteEnd", method = RequestMethod.POST) //���ֹ��� ���� + �۾���(���)
	public String WriteEndPOST(CategoryVO qca, Model model) throws Exception {
		System.out.println("--- ���ֹ��� ���� + �۾��� ---");
		logger.info("customer/WriteEndPost.jsp");
		cservice.qestionsWrite(qca);
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsModify", method = RequestMethod.GET) //���ֹ��� ���� + �ۼ��� ����
	public String questionsModify(CategoryVO qca, Model model) throws Exception {
		logger.info("customer/questionsModify.jsp");
		model.addAttribute("modify",cservice.questionsModify(qca.getQno()));
		return "customer/questionsModify";
	}
	
	@RequestMapping(value="/questionsModify", method = RequestMethod.POST) //���ֹ��� ���� + �ۼ��� �Ϸ�
	public void questionsModifyPost(CategoryVO qca, Model model) throws Exception {
		logger.info("customer/questionsModifyPost.jsp");
		model.addAttribute("modifyPost",cservice.questionsModify(qca.getQno()));
	}
	
	@RequestMapping(value="/questionsDelete", method = RequestMethod.GET) //���ֹ��� ���� + �ۻ���
	public String questionsDelete(CategoryVO qca, Model model) throws Exception {
		logger.info("customer/questionsDelete.jsp");
		cservice.questionsDelete(qca);
		return "redirect:questionsList";
	}
}*/
