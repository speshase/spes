package com.spes.mapper;

import com.spes.model.UserVO;

import java.sql.Date;
import com.spes.model.LoginVO;

public interface UserMapper {
	
	//회원가입
	public void joinUser(UserVO user) throws Exception;
	
	//아이디 중복체크
	public int idolcheck(String uid) throws Exception;
	
	//로그인 체크
	public UserVO login(LoginVO log) throws Exception;
	
	//자동로그인에 체크한 경우, 사용자 테이블에 세션과 유효시간을 저장하기 위한 메서드
	public void sessionLogin(String uid, String sessionId, Date next);
		
	//이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크.
	public UserVO checkSessionLogin(String sessionId);
	
	//회원정보 수정 보기
	public UserVO userModify(String userId) throws Exception;
	
	//회원정보 수정 완료
	public void userModifyEnd(UserVO user) throws Exception;
	
	//아이디 찾기
	public String findid(UserVO user) throws Exception;
	
	//비밀번호 찾기
	public String findpw(UserVO user) throws Exception;
	
	//비밀번호 수정 완료
	public void pwModify(UserVO user) throws Exception;
	
	//회원탈퇴
	public void userleave(UserVO user) throws Exception;
	
}
