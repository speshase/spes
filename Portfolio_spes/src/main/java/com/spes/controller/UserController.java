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
	
	@RequestMapping(value="/join", method = RequestMethod.GET) //join에서 home.jsp로 이동
	public void joinGET() throws Exception {
		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(UserVO user) throws Exception {
		logger.info("join post......");
		uservice.joinUser(user);
		//회원가입 완료
		return "main/joinend";
	}
	
	// id 중복체크
	@RequestMapping(value="/idolcheck", method=RequestMethod.GET)
	@ResponseBody
	public int idolcheck(@RequestParam("uid") String uid) throws Exception {
		System.out.println("-*-*- UserController id 중복체크 -*-*-");
		int cnt = uservice.idolcheck(uid);
		System.out.println("cnt : "+cnt);
		return cnt;
	}

	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public String loginPost(LoginVO log, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		System.out.println("-*-*- UserController -*-*-");
		System.out.println("controller log = "+log);
		String returnURL = "";
		
		if(session.getAttribute("uid") != null){  //uid값이 null이 아니면
			session.removeAttribute("uid"); //uid를 세션에서 제거.
		}		
		UserVO user = uservice.login(log); // 로그인이 성공하면 UserVO 객체를 반환.
		System.out.println("login gogo! = "+log.getUid());

		if(user == null) { //로그인값이 null이면.(로그인 실패)
			System.out.println("로그인 실패");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 정보를 확인해주세요.');</script>");
			returnURL = "redirect:/main/login"; // 로그인 폼으로 다시 가도록 함.
			out.flush();
		
		} else {//로그인 성공시
			//model.addAttribute("uid", user.getUid()); //uid를 다음 화면으로 넘김.
			session.setAttribute("uid", user.getUid()); //user값을 session에 uid라는 이름으로 저장.
			returnURL = "redirect:/main/spes"; // 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
			
			user = uservice.login(log);
			
			/* 쿠키확인 */
			System.out.println("쿠키쿠키 진입");
			System.out.println("쿠키 = "+ log.isUseCookie());
			if (log.isUseCookie() == true) {
				String cookie = (String)session.getAttribute("uid");
				Cookie savecookie = new Cookie("loginCookie", "cookie"); //세션에 저장된 id값을 쿠키객체에 저장.
				System.out.println("cookie값 = "+cookie);
				System.out.println("savecookie값 = "+savecookie);
				savecookie.setPath("/"); //저장된 쿠키를 찾을 경로
				//쿠키를 보내는 경로가 "/" 로 설정함으로써 contextPath 이하의 모든 요청에 대해서 쿠키를 전송할 수 있도록 설정.
				int amount = 60*60*24; //쿠키저장시간(7일) 60*60*24*7
				savecookie.setMaxAge(amount);
				response.addCookie(savecookie);
				
				// currentTimeMills()가 1/1000초 단위임으로 1000곱해서 더해야함 
				Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
				// 현재 세션 id와 유효시간을 사용자 테이블에 저장한다.
				uservice.sessionLogin(user.getUid(), session.getId(), sessionLimit);
			}
		}
		model.addAttribute("log",log.isUseCookie());
		request.setAttribute("log", log.isUseCookie());
		System.out.println(log.isUseCookie());
		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동.
	}
		
	/* 로그아웃 */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
/*	Object obj = session.getAttribute("uid");
	System.out.println(session.getAttribute("uid"));
	System.out.println(obj);
	System.out.println("로그아웃 진입");
	if (obj != null ){
		UserVO user = (UserVO)obj; // null이 아닐 경우 제거
		System.out.println("user");
		session.removeAttribute("user");*/
		session.invalidate(); // 세션 전체를 날려버림
		System.out.println("로그아웃 성공");
/*		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"); //쿠키를 가져와보고
		
		if ( loginCookie != null ){ // null이 아니면 존재하면!
			loginCookie.setPath("/"); // 쿠키는 없앨 때 유효시간을 0으로 설정하는 것 !!! invalidate같은거 없음.
			loginCookie.setMaxAge(0); // 쿠키 설정을 적용한다.
			response.addCookie(loginCookie);
			
			// 사용자 테이블에서도 유효기간을 현재시간으로 다시 세팅해줘야함.
			Date date = new Date(System.currentTimeMillis());
			uservice.sessionLogin(user.getUid(), session.getId(), date);
		}
	}*/
	return "redirect:/main/spes"; // 로그아웃 후 홈으로
	}
}
	
	// 로그아웃
	/*
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		return "redirect:/";
	}
*/

