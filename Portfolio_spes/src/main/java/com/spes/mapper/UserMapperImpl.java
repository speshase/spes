package com.spes.mapper;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spes.model.UserVO;
import com.spes.model.LoginVO;

@Repository
public class UserMapperImpl implements UserMapper{
	
	@Autowired
	private SqlSession sql;
	private static final String namespace = "com.spes.mapper.UserMapper";

	//회원가입
	@Override
	public void joinUser(UserVO user) throws Exception {
		System.out.println(user.toString());
		sql.insert(namespace+".joinUser", user);
	}

	//아이디 중복체크
	@Override
	public int idolcheck(String uid) throws Exception {
		System.out.println(uid);
		int cnt = sql.selectOne(namespace+".idolcheck", uid);
		System.out.println(cnt);
		return cnt;
		
	}
	
	//로그인 체크
	@Override
	public UserVO login(LoginVO log) throws Exception {
		UserVO user = sql.selectOne(namespace+".login",log);
		return user;
	}
	
	//자동로그인에 체크한 경우, 사용자 테이블에 세션과 유효시간을 저장하기 위한 메서드
	@Override
	public void sessionLogin(String uid, String sessionId, Date next) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userId", uid);
		map.put("sessionId", sessionId);
		map.put("next", next);
	}
	
	/* Mapper.xml로 데이터를 전달할 때 한 객체밖에 전달 못함으로 map으로 묶어서 보내줌
	 * 단... 주의할 점은 Mapper.xml 안에서 #{} 이 안에 지정한 이름이랑 같아야함.
	 * 자동으로 매핑될 수 있도록 아래가 수행되면서, 사용자 테이블에 세션id와 유효시간이 저장됨.
	 * sqlSession.update("org.zerock.mapper.UserMapper.keepLogin",map); */
	
	
	//이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크.
	@Override
	public UserVO checkSessionLogin(String sessionId) {
		// 유효시간이 남아있고(>now()) 전달받은 세션 id와 일치하는 사용자 정보를 꺼낸다.
		return sql.selectOne("org.zerock.mapper.UserMapper.checkUserWithSessionKey", sessionId);
	}
	
	//회원정보 수정 보기
	public UserVO userModify(String userId) throws Exception{
		UserVO user = sql.selectOne(namespace+".userModify", userId);
		return user;
	}

	//회원정보 수정 완료
	@Override
	public void userModifyEnd(UserVO user) throws Exception {
		sql.update(namespace+".userModifyEnd", user);
	}

	//아이디찾기
	@Override
	public String findid(UserVO user) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uname", user.getUname());
		paramMap.put("uemail", user.getUemail());
		System.out.println(paramMap);
		String findid = sql.selectOne(namespace+".findid", paramMap);
		System.out.println(findid);
		return findid;
	}
	
	//비밀번호 찾기
	@Override
	public String findpw(UserVO user) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uid", user.getUid());
		paramMap.put("uemail", user.getUemail());
		System.out.println(paramMap);
		String findpw = sql.selectOne(namespace+".findpw", paramMap);
		System.out.println(findpw);
		return findpw;
	}

	//비밀번호 수정 완료
	@Override
	public void pwModify(UserVO user) throws Exception {
		System.out.println("비밀번호 바꾸기 Mapper : " + user);
		sql.update(namespace+".pwModify", user);
	}

	//회원탈퇴
	@Override
	public void userleave(UserVO user) throws Exception {
		sql.delete(namespace+".userleave", user);
		
	}

}