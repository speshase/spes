package com.spes.service;

import java.sql.Date;

import com.spes.model.LoginVO;
import com.spes.model.UserVO;

public interface UserService {
	
	//ȸ������
	public void joinUser(UserVO user) throws Exception;
	
	//���̵� �ߺ�üũ
	public int idolcheck(String uid) throws Exception;
	
	//�α��� üũ
	public UserVO login(LoginVO log) throws Exception;
	
	//�ڵ��α��ο� üũ�� ���, ����� ���̺� ���ǰ� ��ȿ�ð��� �����ϱ� ���� �޼���
	public void sessionLogin(String uid, String sessionId, Date next);
			
	//������ �α����� ���� �ִ���, �� ��ȿ�ð��� ���� ���� ������ ������ �ִ��� üũ.
	public UserVO checkSessionLogin(String sessionId);
}