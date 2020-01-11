package com.speshase.service;

import org.springframework.stereotype.Service;

import com.speshase.model.LoginVO;
import com.speshase.model.UserVO;

@Service
public interface UserService {
	public UserVO login(LoginVO log) throws Exception;
}
