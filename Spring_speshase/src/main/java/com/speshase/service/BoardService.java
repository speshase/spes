package com.speshase.service;

import java.util.List;
import com.speshase.model.BoardVO;
import com.speshase.model.Criteria;

public interface BoardService {
	//전체목록 리스트
	public List<BoardVO> boardList() throws Exception;
	
	//전체목록 리스트(페이징 처리)
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception;
	
	//게시판 제목을 클릭했을 때
	public BoardVO boardDetail(int no) throws Exception;
	
	//board테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	public int boardCount(Criteria cri) throws Exception;
	
	//게시판 글수정
	public void boardModify(BoardVO board) throws Exception;
	
	//게시판 글삭제
	public void boardDel(BoardVO board) throws Exception;
	
	//게시판 글쓰기
	public void boardWrite(BoardVO board, String filename) throws Exception;

}
