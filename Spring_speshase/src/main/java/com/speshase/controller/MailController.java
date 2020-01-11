package com.speshase.controller;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.speshase.model.MailVO;

@Controller	
public class MailController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	//���⼭ mailSender�� root-context.xml�� Gamil���� id
	private JavaMailSender mailSender;
	
	@RequestMapping(value="mail", method=RequestMethod.GET)
	public void mailSendingGet() {
		logger.info("mail.jsp ����");
	}
	
	@RequestMapping(value="mail", method=RequestMethod.POST)
	public void mailSending(MailVO mail) {
		logger.info("tomail="+mail.getTomail());
		logger.info("Title="+mail.getTitle());
		logger.info("Content="+mail.getContent());
		logger.info("Frommail="+mail.getFrommail());
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setFrom(mail.getFrommail()); //������ ���(�ʼ�, �����ϸ� ���������� �۵�X)
			messageHelper.setTo(mail.getTomail());  //�޴� ���
			messageHelper.setSubject(mail.getTitle()); //����(��������)
			messageHelper.setText(mail.getContent()); //����)
			
			mailSender.send(message); //���� ��� �͵��� ���ļ� ������ ������!
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
