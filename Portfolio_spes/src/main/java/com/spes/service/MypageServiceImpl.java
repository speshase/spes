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
	
	//��ٱ��� ��ȸ
	@Override
	public List<CartVO> cartList(String uid) throws Exception {
		System.out.println("��ٱ��� ��ȸ Service uid : "+uid);
		return ct.cartList(uid);
	}
	
	//��ٱ��� �ߺ���ȸ
	@Override
	public int cartcheck(CartVO cart) throws Exception {
		return ct.cartcheck(cart);
	}
	
	//��ٱ��� ���
	@Override
	public void cartin(CartVO cart) throws Exception {
		System.out.println("��ٱ��� ��� Service CartVO : "+cart);
		ct.cartin(cart);
	}

	//��ٱ��� ��������
	@Override
	public void cartModify(int count, CartVO cart) throws Exception {
		System.out.println("��ٱ��� ���� Service Count : "+count);
		System.out.println("��ٱ��� ���� Service cart.getUid() : "+cart.getUid());
		System.out.println("��ٱ��� ���� Service cart.getCp() : "+cart.getCp());
		System.out.println("��ٱ��� ���� Service cart.getCpprice() : "+cart.getCpprice());
		ct.cartModify(count, cart);
		
	}

	//��ٱ��� ��ǰ����
	@Override
	public void cartDelete(int cp, CartVO cart) throws Exception {
		System.out.println("��ٱ��� ���� Service cp : "+cp);
		System.out.println("��ٱ��� ���� Service cart.getUid() : "+cart.getUid());
		ct.cartDelete(cp, cart);
		
	}


}
