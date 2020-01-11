package com.speshase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speshase.mapper.UserMapper;
import com.speshase.model.LoginVO;
import com.speshase.model.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper um;
	
	@Override
	public UserVO login(LoginVO log) throws Exception {

	return um.login(log);
	
	}
}
