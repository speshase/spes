package com.speshase.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.speshase.model.BoardVO;
import com.speshase.model.Criteria;

@Repository

//인터페이스 구현부
public class BoardMapperImpl implements BoardMapper{
	
	@Autowired
	//@Inject와 @Autowired는 같은 역할(둘 다 써도 상관없음)
	//root-context에 있는 sqlSession의 속성을 가져옴
	private SqlSession sqlSession;
	private static final String namespace="com.speshase.mapper.BoardMapper";

	@Override //전체목록 리스트
	public List<BoardVO> boardList() throws Exception {
		//selectList : select된 결과가 여러건일 때 사용하는 메서드.
		List list = sqlSession.selectList(namespace+".boardList");
		return list;
	}
	
	@Override //전체목록 리스트(페이징처리)
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".boardListPaging", cri);
		return list;
	}

	@Override //board테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	public int boardCount(Criteria cri) throws Exception {
		int cnt=sqlSession.selectOne(namespace+".boardCount",cri);
		return cnt;
	}
	
	@Override //글보기(제목 클릭했을 때 상세페이지)
	public BoardVO boardDetail(int no) throws Exception {
		BoardVO boardvo = sqlSession.selectOne(namespace+".boardDetail", no);
		//selectOne : select된 결과가 1건일 때 사용하는 메서드.
		return boardvo;
	}

	@Override //글쓰기
	public void boardWrite(BoardVO board, String filename) throws Exception {
		System.out.println("filename="+filename+"board="+board);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("filename", filename); //Map배열의 첫번째에 filename.
		paramMap.put("board", board); //Map배열의 두번째에 board.
		sqlSession.insert(namespace+".boardWrite", paramMap);
	}

	@Override //글수정
	public void boardModify(BoardVO board) throws Exception {
		sqlSession.update(namespace+".boardModify", board);
	}

	@Override //글삭제
	public void boardDel(BoardVO board) throws Exception {
		sqlSession.delete(namespace+".boardDel", board);
	}

	@Override //게시판 글쓰기할 때 파일 업로드
	public void addAttatch(String filename) throws Exception {
		sqlSession.insert(namespace+".addAttatch", filename);
	}
}
