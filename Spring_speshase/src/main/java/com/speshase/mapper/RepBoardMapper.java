package com.speshase.mapper;

import java.util.List;

import com.speshase.model.RepBoardVO;
import com.speshase.model.Criteria;

public interface RepBoardMapper {
	//전체목록 리스트 //BoardVO를 ArrayList에 차례대로 저장(배열)
	public List<RepBoardVO> RepboardList() throws Exception;
		
	//전체목록 리스트(페이징 처리)
	public List<RepBoardVO> RepboardListPaging(Criteria cri) throws Exception;
			
	//board테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	public int RepboardCount(Criteria cri) throws Exception;
			
	//제목을 클릭했을 때 상세 페이지
	public RepBoardVO RepboardDetail(int no) throws Exception;
			
	//게시판 글수정
	public void RepboardModify(RepBoardVO board) throws Exception;
			
	//게시판 글삭제
	public void RepboardDel(RepBoardVO board) throws Exception;
	
	//게시판 글쓰기
	public void RepboardWrite(RepBoardVO board) throws Exception;
}