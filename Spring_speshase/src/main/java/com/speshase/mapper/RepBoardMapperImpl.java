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
	//@Inject�� @Autowired�� ���� ����(�� �� �ᵵ �������)
	//root-context�� �ִ� sqlSession�� �Ӽ��� ������
	private SqlSession sqlSession;
	private static final String namespace="com.speshase.mapper.RepBoardMapper";

	@Override //��ü��� ����Ʈ
	public List<RepBoardVO> RepboardList() throws Exception {
		//selectList : select�� ����� �������� �� ����ϴ� �޼���.
		List list = sqlSession.selectList(namespace+".RepboardList");
		return list;
	}
	
	@Override //��ü��� ����Ʈ(����¡ó��)
	public List<RepBoardVO> RepboardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".RepboardListPaging", cri);
		return list;
	}

	@Override //board���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	public int RepboardCount(Criteria cri) throws Exception {
		int cnt=sqlSession.selectOne(namespace+".RepboardCount",cri);
		return cnt;
	}
	
	@Override //�ۺ���(���� Ŭ������ �� ��������)
	public RepBoardVO RepboardDetail(int no) throws Exception {
		RepBoardVO boardvo = sqlSession.selectOne(namespace+".RepboardDetail", no);
		//selectOne : select�� ����� 1���� �� ����ϴ� �޼���.
		return boardvo;
	}

	@Override //�۾���
	public void RepboardWrite(RepBoardVO board) throws Exception {
		sqlSession.insert(namespace+".RepboardWrite", board);
	}

	@Override //�ۼ���
	public void RepboardModify(RepBoardVO board) throws Exception {
		sqlSession.insert(namespace+".RepboardModify", board);
	}

	@Override //�ۻ���
	public void RepboardDel(RepBoardVO board) throws Exception {
		sqlSession.insert(namespace+".RepboardDel", board);
	}

}
