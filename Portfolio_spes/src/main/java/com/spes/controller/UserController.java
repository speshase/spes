package com.spes.controller;

import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//���⼭ mailSender�� root-context.xml�� Gamil���� id
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/join", method = RequestMethod.GET) //join���� home.jsp�� �̵�
	public void joinGET() throws Exception {
	}

	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public void joinPOST(@RequestBody UserVO user) throws Exception {
		logger.info("join post......");
		System.out.println("user : "+user);
		uservice.joinUser(user);
		//ȸ������ �Ϸ�
	}
	
	@RequestMapping(value="/joinend", method = RequestMethod.GET) //join���� home.jsp�� �̵�
	public void joinendGET() throws Exception {
	}
	
	// id �ߺ�üũ
	@ResponseBody
	@RequestMapping(value="/idolcheck", method=RequestMethod.GET)
	public int idolcheck(@RequestParam("uid") String uid) throws Exception {
		System.out.println("-*-*- UserController id �ߺ�üũ -*-*-");
		int cnt = uservice.idolcheck(uid);
		System.out.println("cnt : "+cnt);
		return cnt;
	}
	
	// �α���
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public String loginPost(LoginVO log, Model model,HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		System.out.println("-*-*- UserController -*-*-");
		System.out.println("controller log = "+log);
		String returnURL = "";
		
		if(session.getAttribute("uid") != null){  //uid���� null�� �ƴϸ�
			session.removeAttribute("uid"); //uid�� ���ǿ��� ����.
		}		
		UserVO user = uservice.login(log);
		System.out.println("login gogo! = "+log.getUid());
		System.out.println("UserController user��="+user);
		if(user == null) { //�α��ΰ��� null�̸�.(�α��� ����)
			model.addAttribute("msg", "�α��������� �ٽ� Ȯ���ϼ���.");
			returnURL = "main/login";
		
		} else {//�α��� ������
			//model.addAttribute("uid", user.getUid()); //uid�� ���� ȭ������ �ѱ�.
			session.setAttribute("uid", user.getUid()); //user���� session�� uid��� �̸����� ����.
			System.out.println("�α��� ����");
			returnURL = "redirect:/"; // �α��� ������ �Խñ� ����������� �ٷ� �̵��ϵ��� �ϰ�
			
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
	public String logout(HttpSession session,HttpServletRequest request, 
			HttpServletResponse response) {
		session.invalidate(); // ���� ��ü�� ��������
		System.out.println("�α׾ƿ� ����");

	return "redirect:/"; // �α׾ƿ� �� Ȩ����
	}
	
	//���̵� ��й�ȣ ã�� ����
	@RequestMapping(value="/userfind", method=RequestMethod.GET)
	public String userfind(UserVO user) throws Exception {
		logger.info("userfind get......");
		return "main/userfind";
	}
	
	//���̵� ã��
	@ResponseBody
	@RequestMapping(value="/findid", method=RequestMethod.POST)
	public String findid(@RequestBody UserVO user) throws Exception {
		logger.info("findid get......"+user.getUname()+", "+user.getUemail());
		String findid = uservice.findid(user);
		System.out.println("hohohoho : "+findid);
		return findid;
	}
	
	//��й�ȣ ã��
	@ResponseBody
	@RequestMapping(value="/findpw", method=RequestMethod.POST)
	public String findpw(@RequestBody UserVO user, Model model) throws Exception {
		logger.info("findpw POST......"+user.getUid()+", "+user.getUemail());
		String findpw = uservice.findpw(user);
		System.out.println("hahahaha : "+findpw);
		
		//��ȸ�� �ȵǸ� null���� ����.
		if(findpw == null) {
			return null;
		}
		//��ȸ�� �Ǹ� �ش� �� ����.
		return findpw;
	}
	
	//��й�ȣ ���� ����
	//@ResponseBody
	@RequestMapping(value="/pwModify", method = RequestMethod.GET) //findpw���� pwModify.jsp�� �̵�
	public void pwModify(String uid, Model model) throws Exception {
		System.out.println("uid ====== > "+ uid);
		model.addAttribute("uid", uid);
		//return uid;
	}
	
	//��й�ȣ ���� �Ϸ�
	@RequestMapping(value="/pwModify", method = RequestMethod.POST) //pwModify���� home.jsp�� �̵�
	public void pwModifyPOST(@RequestBody UserVO user) throws Exception {
		System.out.println("pwModify POST......"+user.getUid());
		uservice.pwModify(user);
	}
	
	//ȸ������ ���� ����
	@RequestMapping(value="/userModify", method = RequestMethod.GET) //userModify.jsp�� �̵�
	public void userModify(UserVO user, Model model, HttpSession session) throws Exception {
		logger.info("userModify get......");
		String userId=(String) session.getAttribute("uid");
		model.addAttribute("user", uservice.userModify(userId));
	}
		
	//ȸ������ ���� �Ϸ�
	@RequestMapping(value="/userModify", method = RequestMethod.POST) //home.jsp�� �̵�
	public String userModifyPOST(UserVO user, Model model) throws Exception {
		logger.info("userModifyEnd POST......"+user);
		uservice.userModifyEnd(user);
		//model.addAttribute("msg", "ȸ�������� �����Ǿ����ϴ�.");
		model.addAttribute("msg", "ȸ�������� �����Ǿ����ϴ�.");
		return "redirect:/";
	}
	
	//ȸ��Ż��
	@RequestMapping(value="/userleave", method = RequestMethod.GET)
	public String userleave(UserVO user, HttpSession session) throws Exception {
		System.out.println("userleave GET......"+user.getUid());
		System.out.println(session.getAttribute("uid"));
		String uid=(String)session.getAttribute("uid");
		user.setUid(uid);
		uservice.userleave(user);
		session.invalidate();
		return "redirect:/";
		
	}
	
}
