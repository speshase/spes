package com.spes.mapper;

import java.util.List;

import com.spes.model.CartVO;

public interface MypageMapper {
	
	//장바구니 조회
	public List<CartVO> cartList(String uid) throws Exception;
	
	//장바구니 중복조회
	public int cartcheck(CartVO cart) throws Exception;
	
	//장바구니 담기
	public void cartin(CartVO cart) throws Exception;
	
	//장바구니 수량변경
	public void cartModify(int count, CartVO cart) throws Exception;
	
	//장바구니 상품삭제
	public void cartDelete(int cp, CartVO cart) throws Exception;

}
