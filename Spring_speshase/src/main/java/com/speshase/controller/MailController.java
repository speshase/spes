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
	//여기서 mailSender는 root-context.xml의 Gamil설정 id
	private JavaMailSender mailSender;
	
	@RequestMapping(value="mail", method=RequestMethod.GET)
	public void mailSendingGet() {
		logger.info("mail.jsp 실행");
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
			messageHelper.setFrom(mail.getFrommail()); //보내는 사람(필수, 생략하면 정상적으로 작동X)
			messageHelper.setTo(mail.getTomail());  //받는 사람
			messageHelper.setSubject(mail.getTitle()); //제목(생략가능)
			messageHelper.setText(mail.getContent()); //내용)
			
			mailSender.send(message); //위의 모든 것들을 합쳐서 메일을 보내라!
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
