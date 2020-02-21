package com.spes.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spes.model.CartVO;

@Repository
public class MypageMapperImpl implements MypageMapper{
	
	@Autowired
	private SqlSession sql;
	private static final String namespace = "com.spes.mapper.MypageMapper";

	//장바구니 조회
	@Override
	public List<CartVO> cartList(String uid) throws Exception {
		System.out.println("장바구니 조회 Cart Mapper uid : "+uid);
		List list = sql.selectList(namespace+".cartList", uid);
		return list;
	}
	
	//장바구니 중복조회
	@Override
	public int cartcheck(CartVO cart) throws Exception {
		System.out.println("장바구니 중복조회 : "+cart);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("np", cart.getNp());
		map.put("uid", cart.getUid());
		int cnt = sql.selectOne(namespace+".cartcheck", map);
		return cnt;
	}
	
	//장바구니 담기
	@Override
	public void cartin(CartVO cart) throws Exception {
		System.out.println("장바구니 담기 Cart Mapper CartVO : "+cart);
		sql.insert(namespace+".cartin", cart);
	}
	
	//장바구니 수량변경
	@Override
	public void cartModify(int count, CartVO cart) throws Exception {
		System.out.println("장바구니 수정 Cart Mapper Count : "+count);
		System.out.println("장바구니 수정 Cart Mapper cart.getUid() : "+cart.getUid());
		System.out.println("장바구니 수정 Cart Mapper cart.getCp() : "+cart.getCp());
		System.out.println("장바구니 수정 Cart Mapper cart.getCpprice() : "+cart.getCpprice());
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("count", count);
		paramMap.put("uid", cart.getUid());
		paramMap.put("cp", cart.getCp());
		paramMap.put("cpprice", cart.getCpprice());
		sql.update(namespace+".cartModify", paramMap);
	}

	//장바구니 상품삭제
	@Override
	public void cartDelete(int cp, CartVO cart) throws Exception {
		System.out.println("장바구니 수정 Cart Mapper cp : "+cp);
		System.out.println("장바구니 수정 Cart Mapper cart.getUid() : "+cart.getUid());
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("cp", cp);
		paramMap.put("uid", cart.getUid());
		sql.update(namespace+".cartDelete", paramMap);
		
	}

}
