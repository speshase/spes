package com.speshase.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speshase.mapper.ReplyMapper;
import com.speshase.model.Criteria;
import com.speshase.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper rm;
	
	//��� ��ȸ
	@Override
	public List<ReplyVO> Replylist(int bno) throws Exception {
		return rm.list(bno);
	}
	//��� ����
	@Override
	public void RepWrite(ReplyVO vo) throws Exception {
		rm.RepWrite(vo);
	}
	//��� ����
	@Override
	public void RepModify(ReplyVO vo) throws Exception {
		rm.RepModify(vo);
	}
	//��� ����
	@Override
	public void RepDel(int rno) throws Exception {
		rm.RepDel(rno);
	}
	//��� ��ȸ(����¡ó��)
	@Override
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
		return rm.listPage(bno, cri);
	}
	//�� �Խù��� ��� ��ü ����
	@Override
	public int count(int bno) throws Exception {
		return rm.count(bno);
	}
}