package com.speshase.mapper;

import com.speshase.model.MessageVO;

public interface MessageMapper {
	public void create(MessageVO vo) throws Exception; //�޼��� ����
	public MessageVO readMessage(Integer mid) throws Exception; //�޼��� ��ȸ
	public void updateState(Integer mid) throws Exception;; //�޼��� ��Ȳ����

}
