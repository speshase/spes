package com.spes.mapper;

import com.spes.model.UserVO;

import java.sql.Date;
import com.spes.model.LoginVO;

public interface UserMapper {
	
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
	
	//ȸ������ ���� ����
	public UserVO userModify(String userId) throws Exception;
	
	//ȸ������ ���� �Ϸ�
	public void userModifyEnd(UserVO user) throws Exception;
	
	//���̵� ã��
	public String findid(UserVO user) throws Exception;
	
	//��й�ȣ ã��
	public String findpw(UserVO user) throws Exception;
	
	//��й�ȣ ���� �Ϸ�
	public void pwModify(UserVO user) throws Exception;
	
	//ȸ��Ż��
	public void userleave(UserVO user) throws Exception;
	
}
