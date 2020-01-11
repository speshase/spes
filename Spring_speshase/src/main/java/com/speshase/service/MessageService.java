package com.speshase.service;

import com.speshase.model.MessageVO;

public interface MessageService {
	public void addMessage(MessageVO vo) throws Exception;
	public MessageVO readMessage(String uid, int mid) throws Exception;
}
