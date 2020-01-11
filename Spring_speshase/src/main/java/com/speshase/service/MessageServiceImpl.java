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
	
	//PointMapperó�� �ܺο��� ������� �ٸ� ����� ����ϱ� ���� �߰���(AOP���)

	@Transactional
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		mm.create(vo);
		pm.updatePoint(vo.getSender(), 10);
		//����ڰ� �ٸ� ����ڿ��� �޼����� ���� ���ִ�.
		//�޼����� ���� ����ڴ� 10����Ʈ�� �߰��ȴ�.
		//������ �޼����� ������ 5����Ʈ�� �߰��ȴ�.
	}

	@Override
	public MessageVO readMessage(String uid, int mid) throws Exception {
		mm.updateState(mid);
		pm.updatePoint(uid, 5);
		return mm.readMessage(mid);
	}

}
