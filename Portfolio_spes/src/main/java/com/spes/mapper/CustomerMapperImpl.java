package com.spes.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spes.model.CategoryVO;

@Repository
public class CustomerMapperImpl implements CustomerMapper{
	
	@Autowired
	private SqlSession sql;
	private static final String namespace = "com.spes.mapper.CustomerMapper";

	// 자주묻는 질문 + 조회
	@Override
	public List<CategoryVO> questionsList() throws Exception {
		List qcalist = sql.selectList(namespace+".questionsList");
		return qcalist;
	}

	// 자주묻는 질문 + 글쓰기
	@Override
	public void questionsWrite(CategoryVO qca) throws Exception {
		System.out.println("qca"+qca);
		sql.insert(namespace+".questionsWrite", qca);		
	}

	//자주묻는 질문 + 글수정 보기	
	@Override
	public CategoryVO questionsModify(int qno) throws Exception {
		CategoryVO qca = sql.selectOne(namespace+".questionsModify", qno);
		System.out.println("mapper impl qno="+qca.getQno());
		return qca;	
	}
	
	//자주묻는 질문 + 글수정 완료
	@Override
	public void questionsModifyEnd(CategoryVO qca) throws Exception {
		sql.update(namespace+".questionsModifyEnd", qca);	
		System.out.println("mapper impl qno update = "+qca);
	}
		
	// 자주묻는 질문 + 글삭제		
	@Override
	public void questionsDelete(CategoryVO qca) throws Exception {
		sql.delete(namespace+".questionsDelete", qca);	
		
	}

}
