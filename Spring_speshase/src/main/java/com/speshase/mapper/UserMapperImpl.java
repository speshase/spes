package com.speshase.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.speshase.model.LoginVO;
import com.speshase.model.UserVO;

@Repository
public class UserMapperImpl implements UserMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.speshase.mapper.UserMapper";
	

	@Override
	public UserVO login(LoginVO log) throws Exception {
		UserVO user = sqlSession.selectOne(namespace+".login",log);
		return user;
	}

}
