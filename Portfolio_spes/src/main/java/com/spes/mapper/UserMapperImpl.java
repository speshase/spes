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

	//ȸ������
	@Override
	public void joinUser(UserVO user) throws Exception {
		System.out.println(user.toString());
		sql.insert(namespace+".joinUser", user);
	}

	//���̵� �ߺ�üũ
	@Override
	public int idolcheck(String uid) throws Exception {
		System.out.println(uid);
		int cnt = sql.selectOne(namespace+".idolcheck", uid);
		System.out.println(cnt);
		return cnt;
		
	}
	
	//�α��� üũ
	@Override
	public UserVO login(LoginVO log) throws Exception {
		UserVO user = sql.selectOne(namespace+".login",log);
		return user;
	}
	
	//�ڵ��α��ο� üũ�� ���, ����� ���̺� ���ǰ� ��ȿ�ð��� �����ϱ� ���� �޼���
	@Override
	public void sessionLogin(String uid, String sessionId, Date next) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userId", uid);
		map.put("sessionId", sessionId);
		map.put("next", next);
	}
	
	/* Mapper.xml�� �����͸� ������ �� �� ��ü�ۿ� ���� �������� map���� ��� ������
	 * ��... ������ ���� Mapper.xml �ȿ��� #{} �� �ȿ� ������ �̸��̶� ���ƾ���.
	 * �ڵ����� ���ε� �� �ֵ��� �Ʒ��� ����Ǹ鼭, ����� ���̺� ����id�� ��ȿ�ð��� �����.
	 * sqlSession.update("org.zerock.mapper.UserMapper.keepLogin",map); */
	
	
	//������ �α����� ���� �ִ���, �� ��ȿ�ð��� ���� ���� ������ ������ �ִ��� üũ.
	@Override
	public UserVO checkSessionLogin(String sessionId) {
		// ��ȿ�ð��� �����ְ�(>now()) ���޹��� ���� id�� ��ġ�ϴ� ����� ������ ������.
		return sql.selectOne("org.zerock.mapper.UserMapper.checkUserWithSessionKey", sessionId);
	}
	
	//ȸ������ ���� ����
	public UserVO userModify(String userId) throws Exception{
		UserVO user = sql.selectOne(namespace+".userModify", userId);
		return user;
	}

	//ȸ������ ���� �Ϸ�
	@Override
	public void userModifyEnd(UserVO user) throws Exception {
		sql.update(namespace+".userModifyEnd", user);
	}

	//���̵�ã��
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
	
	//��й�ȣ ã��
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

	//��й�ȣ ���� �Ϸ�
	@Override
	public void pwModify(UserVO user) throws Exception {
		System.out.println("��й�ȣ �ٲٱ� Mapper : " + user);
		sql.update(namespace+".pwModify", user);
	}

	//ȸ��Ż��
	@Override
	public void userleave(UserVO user) throws Exception {
		sql.delete(namespace+".userleave", user);
		
	}

}