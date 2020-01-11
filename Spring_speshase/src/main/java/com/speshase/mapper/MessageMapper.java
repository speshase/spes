package com.speshase.mapper;

import com.speshase.model.MessageVO;

public interface MessageMapper {
	public void create(MessageVO vo) throws Exception; //메세지 생성
	public MessageVO readMessage(Integer mid) throws Exception; //메세지 조회
	public void updateState(Integer mid) throws Exception;; //메세지 상황수정

}
