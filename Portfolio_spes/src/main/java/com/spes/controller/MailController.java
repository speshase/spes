
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
	//여기서 mailSender는 root-context.xml의 Gamil설정 id
	private JavaMailSender mailSender;
	
	int ranNum;
	
	@RequestMapping(value="sendMail", method=RequestMethod.POST)
	public ModelAndView sendMail(String uemail, MailVO mail, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("============ MailController sendMail ============");
		
		//인증했던 이메일을 tomail에 저장
		String tomail = uemail;
		
		//랜덤한 난수(인증 번호 )생성
		Random ran = new Random();
		ranNum = ran.nextInt(157211)+48271;
		
		model.addAttribute(ranNum);
				
		//메일 정보 작성
		//받는 사람 정보
		System.out.println("받는 분 : "+tomail);
		mail.setTomail(tomail);
				
		//제목 설정
		String title ="[트라비스]비밀 번호 찾기 인증 이메일입니다.";
		mail.setTitle(title);
				
		//내용 설정
		String content = "비밀번호 찾기 인증번호는 "+ranNum+" 입니다."
				+ System.getProperty("line.separator") 
				+ "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다.";
		mail.setContent(content);
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			//기본 생성자가 없으므로 매개 변수 3개의 생성자 이용
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
		mv.addObject("ranNum", ranNum); //임시 번호 저장
		mv.addObject("email", tomail);
		
		System.out.println("mv : "+mv);
		
		/*response.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response.getWriter();
        out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
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
			System.out.println("인증번호 비교 완료~! 합격! 통과하세요~!");
			result = "pass";
			return result;
		}else {
			return result;
		}
	}
	
	// *참고* 비밀번호 수정은 UserController에 있음.
}
