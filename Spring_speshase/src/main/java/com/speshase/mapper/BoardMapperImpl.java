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

//�������̽� ������
public class BoardMapperImpl implements BoardMapper{
	
	@Autowired
	//@Inject�� @Autowired�� ���� ����(�� �� �ᵵ �������)
	//root-context�� �ִ� sqlSession�� �Ӽ��� ������
	private SqlSession sqlSession;
	private static final String namespace="com.speshase.mapper.BoardMapper";

	@Override //��ü��� ����Ʈ
	public List<BoardVO> boardList() throws Exception {
		//selectList : select�� ����� �������� �� ����ϴ� �޼���.
		List list = sqlSession.selectList(namespace+".boardList");
		return list;
	}
	
	@Override //��ü��� ����Ʈ(����¡ó��)
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".boardListPaging", cri);
		return list;
	}

	@Override //board���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	public int boardCount(Criteria cri) throws Exception {
		int cnt=sqlSession.selectOne(namespace+".boardCount",cri);
		return cnt;
	}
	
	@Override //�ۺ���(���� Ŭ������ �� ��������)
	public BoardVO boardDetail(int no) throws Exception {
		BoardVO boardvo = sqlSession.selectOne(namespace+".boardDetail", no);
		//selectOne : select�� ����� 1���� �� ����ϴ� �޼���.
		return boardvo;
	}

	@Override //�۾���
	public void boardWrite(BoardVO board, String filename) throws Exception {
		System.out.println("filename="+filename+"board="+board);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("filename", filename); //Map�迭�� ù��°�� filename.
		paramMap.put("board", board); //Map�迭�� �ι�°�� board.
		sqlSession.insert(namespace+".boardWrite", paramMap);
	}

	@Override //�ۼ���
	public void boardModify(BoardVO board) throws Exception {
		sqlSession.update(namespace+".boardModify", board);
	}

	@Override //�ۻ���
	public void boardDel(BoardVO board) throws Exception {
		sqlSession.delete(namespace+".boardDel", board);
	}

	@Override //�Խ��� �۾����� �� ���� ���ε�
	public void addAttatch(String filename) throws Exception {
		sqlSession.insert(namespace+".addAttatch", filename);
	}
}
