package com.speshase.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.speshase.model.Criteria;
import com.speshase.model.ReplyVO;

@Repository
public class ReplyMapperImpl implements ReplyMapper {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.speshase.mapper.ReplyMapper";

	//댓글 조회
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		List list = sqlSession.selectList(namespace+".reboardList", bno);
		return list;
	}

	//댓글 쓰기
	@Override
	public void RepWrite(ReplyVO vo) throws Exception {
		sqlSession.insert(namespace+".reboardWrite", vo);
	}

	//댓글 수정
	@Override
	public void RepModify(ReplyVO vo) throws Exception {	
		sqlSession.insert(namespace+".reboardModify", vo);
	}

	//댓글 삭제
	@Override
	public void RepDel(int rno) throws Exception {	
		sqlSession.insert(namespace+".reboardDel", rno);
	}
	
	//댓글 조회(페이징처리)
	@Override
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		
		List list = sqlSession.selectList(namespace+".reboardListPage", paramMap);
		return list;
	}

	//각 게시물의 댓글 전체 개수
	@Override
	public int count(int bno) throws Exception {
		return sqlSession.selectOne(namespace+".count",bno);
	}
}