package com.speshase.mapper;

import java.util.List;

import com.speshase.model.Criteria;
import com.speshase.model.ReplyVO;

public interface ReplyMapper {
	//��� ��ȸ
	public List<ReplyVO> list(int bno) throws Exception;
	//��� ����
	public void RepWrite(ReplyVO vo) throws Exception;
	//��� ����
	public void RepModify(ReplyVO vo) throws Exception;
	//��� ����
	public void RepDel(int rno) throws Exception;
	//��� ��ȸ(����¡ó��)
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception;
	//�� �Խù��� ��� ��ü ����
	public int count(int bno) throws Exception;
}