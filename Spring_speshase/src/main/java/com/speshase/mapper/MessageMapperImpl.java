package com.speshase.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.speshase.model.MessageVO;

@Repository
public class MessageMapperImpl implements MessageMapper {

	@Autowired
	private SqlSession session;
	
	private static final String namespace = "com.speshase.mapper.MessageMapper";
	
	@Override
	public void create(MessageVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public MessageVO readMessage(Integer mid) throws Exception {
		return session.selectOne(namespace+".readMessage", mid);
	}

	@Override
	public void updateState(Integer mid) throws Exception {
		session.update(namespace+"upldateState", mid);
	}
}
