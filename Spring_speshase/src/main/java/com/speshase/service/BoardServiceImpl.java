package com.speshase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.speshase.mapper.BoardMapper;
import com.speshase.model.BoardVO;
import com.speshase.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper bm;

	// ��ü��� ����Ʈ
	@Override
	public List<BoardVO> boardList() throws Exception {
		return bm.boardList();
	}

	// �Խ��� ����Ʈ(����¡ ó��)
	@Override
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		return bm.boardListPaging(cri);
	}

	// board���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	@Override
	public int boardCount(Criteria cri) throws Exception {
		return bm.boardCount(cri);
	}

	// �Խ��� ������ Ŭ������ ��
	@Override
	public BoardVO boardDetail(int no) throws Exception {
		return bm.boardDetail(no);
	}

	// �Խ��� �ۼ���
	@Override
	public void boardModify(BoardVO board) throws Exception {
		bm.boardModify(board);
	}

	// �Խ��� �ۻ���
	@Override
	public void boardDel(BoardVO board) throws Exception {
		bm.boardDel(board);
	}

	// �Խ��� �۾���
	@Transactional
	@Override
	public void boardWrite(BoardVO board, String filename) throws Exception {
		bm.boardWrite(board, filename);
		/*
		 * String[] files = board.getFiles();
		 * 
		 * if(files==null) {return;}
		 * 
		 * for(String filename : files) { BM.addAttatch(filename);
		 */
	}
}
