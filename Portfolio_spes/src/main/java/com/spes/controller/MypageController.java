package com.spes.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spes.model.CartVO;
import com.spes.service.MypageService;


@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private MypageService mservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 배송조회 이동
	@RequestMapping(value="/delivery", method = RequestMethod.GET)
	public String delivery() throws Exception {
		logger.info("mypage/delivery.jsp");
		return "mypage/delivery";
	}
	
	// 장바구니 이동(조회)
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String cart(CartVO cart, Model model, HttpSession session) throws Exception {
		logger.info("mypage/cart.jsp");
		String sessionid=(String)session.getAttribute("uid");
		cart.setUid(sessionid);
		model.addAttribute("cart", mservice.cartList(cart.getUid()));
		return "mypage/cart";
	}
	
	// 장바구니 담기(등록)
	@ResponseBody
	@RequestMapping(value="/cart", method = RequestMethod.POST)
	public int cartPOST(@RequestBody CartVO cart, HttpSession session) throws Exception {
		logger.info("mypage/cartPOST.jsp");
		String uid=(String)session.getAttribute("uid");
		cart.setUid(uid);
		int cnt = 0;

		System.out.println("Controller uid : " +uid);
		if(uid == null || uid.equals(null)) {
			return cnt=100;
		}
		else {
			
		cnt = mservice.cartcheck(cart);
		System.out.println("Controller cnt : "+cnt);
		
		if(cnt == 1) {
			return cnt=1;
		}
		else {
			System.out.println("cart cart cartVO : "+cart+", "+"session id : "+uid);
			mservice.cartin(cart);
			return cnt;
		}
		}
	}
	
	// 장바구니 수량 변경
	@ResponseBody
	@RequestMapping(value="/cartModify", method = RequestMethod.POST)
	public void cartModify(@RequestParam int count, int cp, int cpprice,
			CartVO cart, HttpSession session) throws Exception {
		logger.info("mypage/cartModify.jsp");
		String uid=(String)session.getAttribute("uid");
		cart.setUid(uid);
		cart.setCp(cp);
		cart.setCpprice(cpprice);
		System.out.println("count : "+count+", cp : "+cp+", cpprice : "+cpprice);
		mservice.cartModify(count, cart);
	}
	
	// 장바구니 물품 삭제
	@ResponseBody
	@RequestMapping(value="/cartDelete", method = RequestMethod.POST)
	public void cartDelete(@RequestParam int cp, 
			CartVO cart, HttpSession session) throws Exception {
		logger.info("mypage/cartDelete.jsp");
		String uid=(String)session.getAttribute("uid");
		cart.setUid(uid);
		System.out.println(cp);
		mservice.cartDelete(cp, cart);
	}
	
	// 상품후기 이동
	@RequestMapping(value="/review", method = RequestMethod.GET)
	public String review() throws Exception {
		logger.info("mypage/review.jsp");
		return "mypage/review";
	}
	
	// 쿠폰 이동
	@RequestMapping(value="/coupon2", method = RequestMethod.GET)
	public String coupon2() throws Exception {
		logger.info("mypage/coupon2.jsp");
		return "mypage/coupon2";
	}
		

}
