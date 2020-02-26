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
	
	//여기서 mailSender는 root-context.xml의 Gamil설정 id
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/join", method = RequestMethod.GET) //join에서 home.jsp로 이동
	public void joinGET() throws Exception {
	}

	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public void joinPOST(@RequestBody UserVO user) throws Exception {
		logger.info("join post......");
		System.out.println("user : "+user);
		uservice.joinUser(user);
		//회원가입 완료
	}
	
	@RequestMapping(value="/joinend", method = RequestMethod.GET) //join에서 home.jsp로 이동
	public void joinendGET() throws Exception {
	}
	
	// id 중복체크
	@ResponseBody
	@RequestMapping(value="/idolcheck", method=RequestMethod.GET)
	public int idolcheck(@RequestParam("uid") String uid) throws Exception {
		System.out.println("-*-*- UserController id 중복체크 -*-*-");
		int cnt = uservice.idolcheck(uid);
		System.out.println("cnt : "+cnt);
		return cnt;
	}
	
	// 로그인
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public String loginPost(LoginVO log, Model model,HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		System.out.println("-*-*- UserController -*-*-");
		System.out.println("controller log = "+log);
		String returnURL = "";
		
		if(session.getAttribute("uid") != null){  //uid값이 null이 아니면
			session.removeAttribute("uid"); //uid를 세션에서 제거.
		}		
		UserVO user = uservice.login(log);
		System.out.println("login gogo! = "+log.getUid());
		System.out.println("UserController user값="+user);
		if(user == null) { //로그인값이 null이면.(로그인 실패)
			model.addAttribute("msg", "로그인정보를 다시 확인하세요.");
			returnURL = "main/login";
		
		} else {//로그인 성공시
			//model.addAttribute("uid", user.getUid()); //uid를 다음 화면으로 넘김.
			session.setAttribute("uid", user.getUid()); //user값을 session에 uid라는 이름으로 저장.
			System.out.println("로그인 성공");
			returnURL = "redirect:/"; // 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
			
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
	public String logout(HttpSession session,HttpServletRequest request, 
			HttpServletResponse response) {
		session.invalidate(); // 세션 전체를 날려버림
		System.out.println("로그아웃 성공");

	return "redirect:/"; // 로그아웃 후 홈으로
	}
	
	//아이디 비밀번호 찾기 보기
	@RequestMapping(value="/userfind", method=RequestMethod.GET)
	public String userfind(UserVO user) throws Exception {
		logger.info("userfind get......");
		return "main/userfind";
	}
	
	//아이디 찾기
	@ResponseBody
	@RequestMapping(value="/findid", method=RequestMethod.POST)
	public String findid(@RequestBody UserVO user) throws Exception {
		logger.info("findid get......"+user.getUname()+", "+user.getUemail());
		String findid = uservice.findid(user);
		System.out.println("hohohoho : "+findid);
		return findid;
	}
	
	//비밀번호 찾기
	@ResponseBody
	@RequestMapping(value="/findpw", method=RequestMethod.POST)
	public String findpw(@RequestBody UserVO user, Model model) throws Exception {
		logger.info("findpw POST......"+user.getUid()+", "+user.getUemail());
		String findpw = uservice.findpw(user);
		System.out.println("hahahaha : "+findpw);
		
		//조회가 안되면 null값을 리턴.
		if(findpw == null) {
			return null;
		}
		//조회가 되면 해당 값 리턴.
		return findpw;
	}
	
	//비밀번호 수정 보기
	//@ResponseBody
	@RequestMapping(value="/pwModify", method = RequestMethod.GET) //findpw에서 pwModify.jsp로 이동
	public void pwModify(String uid, Model model) throws Exception {
		System.out.println("uid ====== > "+ uid);
		model.addAttribute("uid", uid);
		//return uid;
	}
	
	//비밀번호 수정 완료
	@RequestMapping(value="/pwModify", method = RequestMethod.POST) //pwModify에서 home.jsp로 이동
	public void pwModifyPOST(@RequestBody UserVO user) throws Exception {
		System.out.println("pwModify POST......"+user.getUid());
		uservice.pwModify(user);
	}
	
	//회원정보 수정 보기
	@RequestMapping(value="/userModify", method = RequestMethod.GET) //userModify.jsp로 이동
	public void userModify(UserVO user, Model model, HttpSession session) throws Exception {
		logger.info("userModify get......");
		String userId=(String) session.getAttribute("uid");
		model.addAttribute("user", uservice.userModify(userId));
	}
		
	//회원정보 수정 완료
	@RequestMapping(value="/userModify", method = RequestMethod.POST) //home.jsp로 이동
	public String userModifyPOST(UserVO user, Model model) throws Exception {
		logger.info("userModifyEnd POST......"+user);
		uservice.userModifyEnd(user);
		//model.addAttribute("msg", "회원정보가 수정되었습니다.");
		model.addAttribute("msg", "회원정보가 수정되었습니다.");
		return "redirect:/";
	}
	
	//회원탈퇴
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
