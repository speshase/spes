package com.spes.mapper;

import java.sql.Date;
import java.util.HashMap;
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

}