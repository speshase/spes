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
	public List<CategoryVO> qcategoryList() throws Exception {
		List qcalist = sql.selectList(namespace+".qcategoryList");
		return qcalist;
	}

	// 자주묻는 질문 + 글쓰기
	@Override
	public void qestionsWrite(CategoryVO qca) throws Exception {
		System.out.println("qca"+qca);
		sql.insert(namespace+".qestionisWrite", qca);
		
	}

}
