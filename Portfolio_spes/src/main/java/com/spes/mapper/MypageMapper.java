package com.spes.mapper;

import java.util.List;

import com.spes.model.CartVO;

public interface MypageMapper {
	
	//��ٱ��� ��ȸ
	public List<CartVO> cartList(String uid) throws Exception;
	
	//��ٱ��� �ߺ���ȸ
	public int cartcheck(CartVO cart) throws Exception;
	
	//��ٱ��� ���
	public void cartin(CartVO cart) throws Exception;
	
	//��ٱ��� ��������
	public void cartModify(int count, CartVO cart) throws Exception;
	
	//��ٱ��� ��ǰ����
	public void cartDelete(int cp, CartVO cart) throws Exception;

}
