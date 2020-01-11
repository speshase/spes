package com.speshase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speshase.mapper.RepBoardMapper;
import com.speshase.model.Criteria;
import com.speshase.model.RepBoardVO;

@Service
public class RepBoardServiceImpl implements RepBoardService{
	@Autowired
	RepBoardMapper rbm;
	
	//�Խ��� ����Ʈ
	@Override
	public List<RepBoardVO> RepboardList() throws Exception {
		return rbm.RepboardList();
	}
	
	//�Խ��� ����Ʈ(����¡ó��)
	@Override
	public List<RepBoardVO> RepboardListPaging(Criteria cri) throws Exception {
		return rbm.RepboardListPaging(cri);
	}

	@Override
	public RepBoardVO RepboardDetail(int no) throws Exception {
		return rbm.RepboardDetail(no);
	}

	@Override
	public int RepboardCount(Criteria cri) throws Exception {
		return rbm.RepboardCount(cri);
	}

	@Override
	public void RepboardModify(RepBoardVO board) throws Exception {
		rbm.RepboardModify(board);
	}

	@Override
	public void RepboardDel(RepBoardVO board) throws Exception {
		rbm.RepboardDel(board);
	}

	@Override
	public void RepboardWrite(RepBoardVO board) throws Exception {
		rbm.RepboardWrite(board);
	}


}
