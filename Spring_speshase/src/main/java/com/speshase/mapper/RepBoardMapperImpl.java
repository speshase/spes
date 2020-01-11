package com.speshase.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.speshase.model.RepBoardVO;
import com.speshase.model.Criteria;

@Repository
public class RepBoardMapperImpl implements RepBoardMapper {
	
	@Autowired
	//@Inject와 @Autowired는 같은 역할(둘 다 써도 상관없음)
	//root-context에 있는 sqlSession의 속성을 가져옴
	private SqlSession sqlSession;
	private static final String namespace="com.speshase.mapper.RepBoardMapper";

	@Override //전체목록 리스트
	public List<RepBoardVO> RepboardList() throws Exception {
		//selectList : select된 결과가 여러건일 때 사용하는 메서드.
		List list = sqlSession.selectList(namespace+".RepboardList");
		return list;
	}
	
	@Override //전체목록 리스트(페이징처리)
	public List<RepBoardVO> RepboardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".RepboardListPaging", cri);
		return list;
	}

	@Override //board테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	public int RepboardCount(Criteria cri) throws Exception {
		int cnt=sqlSession.selectOne(namespace+".RepboardCount",cri);
		return cnt;
	}
	
	@Override //글보기(제목 클릭했을 때 상세페이지)
	public RepBoardVO RepboardDetail(int no) throws Exception {
		RepBoardVO boardvo = sqlSession.selectOne(namespace+".RepboardDetail", no);
		//selectOne : select된 결과가 1건일 때 사용하는 메서드.
		return boardvo;
	}

	@Override //글쓰기
	public void RepboardWrite(RepBoardVO board) throws Exception {
		sqlSession.insert(namespace+".RepboardWrite", board);
	}

	@Override //글수정
	public void RepboardModify(RepBoardVO board) throws Exception {
		sqlSession.insert(namespace+".RepboardModify", board);
	}

	@Override //글삭제
	public void RepboardDel(RepBoardVO board) throws Exception {
		sqlSession.insert(namespace+".RepboardDel", board);
	}

}
