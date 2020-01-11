package com.speshase.mapper;

import java.util.List;

import com.speshase.model.RepBoardVO;
import com.speshase.model.Criteria;

public interface RepBoardMapper {
	//��ü��� ����Ʈ //BoardVO�� ArrayList�� ���ʴ�� ����(�迭)
	public List<RepBoardVO> RepboardList() throws Exception;
		
	//��ü��� ����Ʈ(����¡ ó��)
	public List<RepBoardVO> RepboardListPaging(Criteria cri) throws Exception;
			
	//board���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	public int RepboardCount(Criteria cri) throws Exception;
			
	//������ Ŭ������ �� �� ������
	public RepBoardVO RepboardDetail(int no) throws Exception;
			
	//�Խ��� �ۼ���
	public void RepboardModify(RepBoardVO board) throws Exception;
			
	//�Խ��� �ۻ���
	public void RepboardDel(RepBoardVO board) throws Exception;
	
	//�Խ��� �۾���
	public void RepboardWrite(RepBoardVO board) throws Exception;
}