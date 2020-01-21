package com.spes.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spes.model.CategoryVO;
import com.spes.model.Criteria;

@Repository
public class CustomerMapperImpl implements CustomerMapper{
	
	@Autowired
	private SqlSession sql;
	private static final String namespace = "com.spes.mapper.CustomerMapper";

	//카테고리 전체조회
	@Override
	public List<CategoryVO> qcategoryList() throws Exception {
		List qcalist = sql.selectList(namespace+".qcategoryList");
		return qcalist;
	}

}
