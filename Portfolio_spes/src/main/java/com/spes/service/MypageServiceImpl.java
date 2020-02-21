package com.spes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spes.mapper.MypageMapper;
import com.spes.model.CartVO;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	MypageMapper ct;
	
	//장바구니 조회
	@Override
	public List<CartVO> cartList(String uid) throws Exception {
		System.out.println("장바구니 조회 Service uid : "+uid);
		return ct.cartList(uid);
	}
	
	//장바구니 중복조회
	@Override
	public int cartcheck(CartVO cart) throws Exception {
		return ct.cartcheck(cart);
	}
	
	//장바구니 담기
	@Override
	public void cartin(CartVO cart) throws Exception {
		System.out.println("장바구니 담기 Service CartVO : "+cart);
		ct.cartin(cart);
	}

	//장바구니 수량변경
	@Override
	public void cartModify(int count, CartVO cart) throws Exception {
		System.out.println("장바구니 수정 Service Count : "+count);
		System.out.println("장바구니 수정 Service cart.getUid() : "+cart.getUid());
		System.out.println("장바구니 수정 Service cart.getCp() : "+cart.getCp());
		System.out.println("장바구니 수정 Service cart.getCpprice() : "+cart.getCpprice());
		ct.cartModify(count, cart);
		
	}

	//장바구니 상품삭제
	@Override
	public void cartDelete(int cp, CartVO cart) throws Exception {
		System.out.println("장바구니 수정 Service cp : "+cp);
		System.out.println("장바구니 수정 Service cart.getUid() : "+cart.getUid());
		ct.cartDelete(cp, cart);
		
	}


}
