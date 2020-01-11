package com.speshase.mapper;

import com.speshase.model.LoginVO;
import com.speshase.model.UserVO;

public interface UserMapper {
	public UserVO login(LoginVO log) throws Exception; //인터페이스에는 추상메서드만 만들 수 있음.

}
