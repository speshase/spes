package com.speshase.service;

import java.util.List;

import com.speshase.model.Criteria;
import com.speshase.model.ReplyVO;

public interface ReplyService {
	//댓글 조회
	public List<ReplyVO> Replylist(int bno) throws Exception;
	//댓글 쓰기
	public void RepWrite(ReplyVO vo) throws Exception;
	//댓글 수정
	public void RepModify(ReplyVO vo) throws Exception;
	//댓글 삭제
	public void RepDel(int rno) throws Exception;
	//댓글 조회(페이징처리)
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception;
	//각 게시물의 댓글 전체 개수
	public int count(int bno) throws Exception;

}
