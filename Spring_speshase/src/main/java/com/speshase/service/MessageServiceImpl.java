package com.speshase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.speshase.mapper.MessageMapper;
import com.speshase.mapper.PointMapper;
import com.speshase.model.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageMapper mm;
	@Autowired
	private PointMapper pm;
	
	//PointMapper처럼 외부에서 만들어진 다른 기능을 사용하기 위해 추가함(AOP기법)

	@Transactional
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		mm.create(vo);
		pm.updatePoint(vo.getSender(), 10);
		//사용자가 다른 사용자에게 메세지를 남길 수있다.
		//메세지를 남긴 사용자는 10포인트가 추가된다.
		//남겨진 메세지를 읽으면 5포인트가 추가된다.
	}

	@Override
	public MessageVO readMessage(String uid, int mid) throws Exception {
		mm.updateState(mid);
		pm.updatePoint(uid, 5);
		return mm.readMessage(mid);
	}

}
