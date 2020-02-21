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
	
	//ȸ������
	@Override
	public void joinUser(UserVO user) throws Exception {
		um.joinUser(user);

	}
	
	//���̵� �ߺ� üũ
	@Override
	public int idolcheck(String uid) throws Exception {
		return um.idolcheck(uid);
		}
	
	//�α��� üũ
	@Override
	public UserVO login(LoginVO log) throws Exception {
		return um.login(log);
	}

	//�ڵ��α��ο� üũ�� ���, ����� ���̺� ���ǰ� ��ȿ�ð��� �����ϱ� ���� �޼���
	@Override
	public void sessionLogin(String uid, String sessionId, Date next) {
		um.sessionLogin(uid, sessionId, next);
	}

	//������ �α����� ���� �ִ���, �� ��ȿ�ð��� ���� ���� ������ ������ �ִ��� üũ.
	@Override
	public UserVO checkSessionLogin(String sessionId) {
		return um.checkSessionLogin(sessionId);
	}
	
	//ȸ������ ���� ����
	public UserVO userModify(String userId) throws Exception {
		return um.userModify(userId);
	}
	
	//ȸ������ ���� �Ϸ�
	public void userModifyEnd(UserVO user) throws Exception {
		um.userModifyEnd(user);
	}
	
	//���̵�ã��
	public String findid(UserVO user) throws Exception {
		return um.findid(user);
	}
	
	//��й�ȣ ã��
	public String findpw(UserVO user) throws Exception {
		return um.findpw(user);
	}

	//��й�ȣ ���� �Ϸ�
	@Override
	public void pwModify(UserVO user) throws Exception {
		System.out.println("��й�ȣ �ٲٱ� Service : " + user);
		um.pwModify(user);
	}

	//ȸ��Ż��
	@Override
	public void userleave(UserVO user) throws Exception {
		um.userleave(user);
		
	}
	
}
