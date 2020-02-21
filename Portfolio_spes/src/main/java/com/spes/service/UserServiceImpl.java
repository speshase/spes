package com.spes.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spes.mapper.UserMapper;
import com.spes.model.LoginVO;
import com.spes.model.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper um;
	
	//회원가입
	@Override
	public void joinUser(UserVO user) throws Exception {
		um.joinUser(user);

	}
	
	//아이디 중복 체크
	@Override
	public int idolcheck(String uid) throws Exception {
		return um.idolcheck(uid);
		}
	
	//로그인 체크
	@Override
	public UserVO login(LoginVO log) throws Exception {
		return um.login(log);
	}

	//자동로그인에 체크한 경우, 사용자 테이블에 세션과 유효시간을 저장하기 위한 메서드
	@Override
	public void sessionLogin(String uid, String sessionId, Date next) {
		um.sessionLogin(uid, sessionId, next);
	}

	//이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크.
	@Override
	public UserVO checkSessionLogin(String sessionId) {
		return um.checkSessionLogin(sessionId);
	}
	
	//회원정보 수정 보기
	public UserVO userModify(String userId) throws Exception {
		return um.userModify(userId);
	}
	
	//회원정보 수정 완료
	public void userModifyEnd(UserVO user) throws Exception {
		um.userModifyEnd(user);
	}
	
	//아이디찾기
	public String findid(UserVO user) throws Exception {
		return um.findid(user);
	}
	
	//비밀번호 찾기
	public String findpw(UserVO user) throws Exception {
		return um.findpw(user);
	}

	//비밀번호 수정 완료
	@Override
	public void pwModify(UserVO user) throws Exception {
		System.out.println("비밀번호 바꾸기 Service : " + user);
		um.pwModify(user);
	}

	//회원탈퇴
	@Override
	public void userleave(UserVO user) throws Exception {
		um.userleave(user);
		
	}
	
}
