
package com.spes.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spes.model.MailVO;

@Controller
@RequestMapping("/main")
public class MailController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	//���⼭ mailSender�� root-context.xml�� Gamil���� id
	private JavaMailSender mailSender;
	
	int ranNum;
	
	@RequestMapping(value="sendMail", method=RequestMethod.POST)
	public ModelAndView sendMail(String uemail, MailVO mail, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("============ MailController sendMail ============");
		
		//�����ߴ� �̸����� tomail�� ����
		String tomail = uemail;
		
		//������ ����(���� ��ȣ )����
		Random ran = new Random();
		ranNum = ran.nextInt(157211)+48271;
		
		model.addAttribute(ranNum);
				
		//���� ���� �ۼ�
		//�޴� ��� ����
		System.out.println("�޴� �� : "+tomail);
		mail.setTomail(tomail);
				
		//���� ����
		String title ="[Ʈ���]��� ��ȣ ã�� ���� �̸����Դϴ�.";
		mail.setTitle(title);
				
		//���� ����
		String content = "��й�ȣ ã�� ������ȣ�� "+ranNum+" �Դϴ�."
				+ System.getProperty("line.separator") 
				+ "������ ������ȣ�� Ȩ�������� �Է��� �ֽø� �������� �Ѿ�ϴ�.";
		mail.setContent(content);
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			//�⺻ �����ڰ� �����Ƿ� �Ű� ���� 3���� ������ �̿�
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"utf-8");
			
			messageHelper.setTo(mail.getTomail());
			messageHelper.setSubject(mail.getTitle());
			messageHelper.setText(mail.getContent());
			
			mailSender.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/userfind");
		mv.addObject("ranNum", ranNum); //�ӽ� ��ȣ ����
		mv.addObject("email", tomail);
		
		System.out.println("mv : "+mv);
		
		/*response.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response.getWriter();
        out_email.println("<script>alert('�̸����� �߼۵Ǿ����ϴ�. ������ȣ�� �Է����ּ���.');</script>");
        out_email.flush();*/
        
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="checkNum", method=RequestMethod.POST)
	public String checkNum(int inputNum) throws Exception{
		System.out.println("============ MailController checkNum ============");
		logger.info("inputNum = "+inputNum);
		String result = null;
		//int input = Integer.parseInt(inputNum);
		if(ranNum == inputNum) {
			System.out.println("������ȣ �� �Ϸ�~! �հ�! ����ϼ���~!");
			result = "pass";
			return result;
		}else {
			return result;
		}
	}
	
	// *����* ��й�ȣ ������ UserController�� ����.
}
