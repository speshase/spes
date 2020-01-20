package com.spes.controller;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spes.model.UserVO;
import com.spes.service.UserService;
import com.spes.model.LoginVO;

@Controller
@RequestMapping("/main")
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	private static final Logger logger =
			LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/join", method = RequestMethod.GET) //join���� home.jsp�� �̵�
	public void joinGET() throws Exception {
		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(UserVO user) throws Exception {
		logger.info("join post......");
		uservice.joinUser(user);
		//ȸ������ �Ϸ�
		return "main/joinend";
	}
	
	// id �ߺ�üũ
	@RequestMapping(value="/idolcheck", method=RequestMethod.GET)
	@ResponseBody
	public int idolcheck(@RequestParam("uid") String uid) throws Exception {
		System.out.println("-*-*- UserController id �ߺ�üũ -*-*-");
		int cnt = uservice.idolcheck(uid);
		System.out.println("cnt : "+cnt);
		return cnt;
	}

	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public String loginPost(LoginVO log, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		System.out.println("-*-*- UserController -*-*-");
		System.out.println("controller log = "+log);
		String returnURL = "";
		
		if(session.getAttribute("uid") != null){  //uid���� null�� �ƴϸ�
			session.removeAttribute("uid"); //uid�� ���ǿ��� ����.
		}		
		UserVO user = uservice.login(log); // �α����� �����ϸ� UserVO ��ü�� ��ȯ.
		System.out.println("login gogo! = "+log.getUid());

		if(user == null) { //�α��ΰ��� null�̸�.(�α��� ����)
			System.out.println("�α��� ����");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�α��� ������ Ȯ�����ּ���.');</script>");
			returnURL = "redirect:/main/login"; // �α��� ������ �ٽ� ������ ��.
			out.flush();
		
		} else {//�α��� ������
			//model.addAttribute("uid", user.getUid()); //uid�� ���� ȭ������ �ѱ�.
			session.setAttribute("uid", user.getUid()); //user���� session�� uid��� �̸����� ����.
			returnURL = "redirect:/main/spes"; // �α��� ������ �Խñ� ����������� �ٷ� �̵��ϵ��� �ϰ�
			
			user = uservice.login(log);
			
			/* ��ŰȮ�� */
			System.out.println("��Ű��Ű ����");
			System.out.println("��Ű = "+ log.isUseCookie());
			if (log.isUseCookie() == true) {
				String cookie = (String)session.getAttribute("uid");
				Cookie savecookie = new Cookie("loginCookie", "cookie"); //���ǿ� ����� id���� ��Ű��ü�� ����.
				System.out.println("cookie�� = "+cookie);
				System.out.println("savecookie�� = "+savecookie);
				savecookie.setPath("/"); //����� ��Ű�� ã�� ���
				//��Ű�� ������ ��ΰ� "/" �� ���������ν� contextPath ������ ��� ��û�� ���ؼ� ��Ű�� ������ �� �ֵ��� ����.
				int amount = 60*60*24; //��Ű����ð�(7��) 60*60*24*7
				savecookie.setMaxAge(amount);
				response.addCookie(savecookie);
				
				// currentTimeMills()�� 1/1000�� ���������� 1000���ؼ� ���ؾ��� 
				Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
				// ���� ���� id�� ��ȿ�ð��� ����� ���̺� �����Ѵ�.
				uservice.sessionLogin(user.getUid(), session.getId(), sessionLimit);
			}
		}
		model.addAttribute("log",log.isUseCookie());
		request.setAttribute("log", log.isUseCookie());
		System.out.println(log.isUseCookie());
		return returnURL; // ������ ������ returnURL �� ��ȯ�ؼ� �̵�.
	}
		
	/* �α׾ƿ� */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
/*	Object obj = session.getAttribute("uid");
	System.out.println(session.getAttribute("uid"));
	System.out.println(obj);
	System.out.println("�α׾ƿ� ����");
	if (obj != null ){
		UserVO user = (UserVO)obj; // null�� �ƴ� ��� ����
		System.out.println("user");
		session.removeAttribute("user");*/
		session.invalidate(); // ���� ��ü�� ��������
		System.out.println("�α׾ƿ� ����");
/*		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"); //��Ű�� �����ͺ���
		
		if ( loginCookie != null ){ // null�� �ƴϸ� �����ϸ�!
			loginCookie.setPath("/"); // ��Ű�� ���� �� ��ȿ�ð��� 0���� �����ϴ� �� !!! invalidate������ ����.
			loginCookie.setMaxAge(0); // ��Ű ������ �����Ѵ�.
			response.addCookie(loginCookie);
			
			// ����� ���̺����� ��ȿ�Ⱓ�� ����ð����� �ٽ� �����������.
			Date date = new Date(System.currentTimeMillis());
			uservice.sessionLogin(user.getUid(), session.getId(), date);
		}
	}*/
	return "redirect:/main/spes"; // �α׾ƿ� �� Ȩ����
	}
}
	
	// �α׾ƿ�
	/*
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		return "redirect:/";
	}
*/

