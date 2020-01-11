package com.speshase.mapper;

import java.util.List;

import com.speshase.model.BoardVO;
import com.speshase.model.Criteria;

public interface BoardMapper {
	//��ü ��� ����Ʈ
	public List<BoardVO> boardList() throws Exception;
	//BoardVO�� ArrayList�� ���ʴ�� ����(�迭)
	
	//��ü ��� ����Ʈ(����¡ ó��)
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception;
	
	//board���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	public int boardCount(Criteria cri) throws Exception;
	
	//������ Ŭ������ �� �� ������
	public BoardVO boardDetail(int no) throws Exception;
	
	//�Խ��� �۾���
	public void boardWrite(BoardVO board, String filename) throws Exception;
	
	//�Խ��� �ۼ���
	public void boardModify(BoardVO board) throws Exception;
	
	//�Խ��� �ۻ���
	public void boardDel(BoardVO board) throws Exception;
	
	//�Խ��� �۾����� �� ���� ���ε�
	public void addAttatch(String filename) throws Exception; 
}