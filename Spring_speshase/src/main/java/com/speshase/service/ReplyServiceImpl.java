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
	
	//댓글 조회
	@Override
	public List<ReplyVO> Replylist(int bno) throws Exception {
		return rm.list(bno);
	}
	//댓글 쓰기
	@Override
	public void RepWrite(ReplyVO vo) throws Exception {
		rm.RepWrite(vo);
	}
	//댓글 수정
	@Override
	public void RepModify(ReplyVO vo) throws Exception {
		rm.RepModify(vo);
	}
	//댓글 삭제
	@Override
	public void RepDel(int rno) throws Exception {
		rm.RepDel(rno);
	}
	//댓글 조회(페이징처리)
	@Override
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
		return rm.listPage(bno, cri);
	}
	//각 게시물의 댓글 전체 개수
	@Override
	public int count(int bno) throws Exception {
		return rm.count(bno);
	}
}