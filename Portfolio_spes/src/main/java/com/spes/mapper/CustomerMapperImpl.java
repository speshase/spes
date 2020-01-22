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

	// ���ֹ��� ���� + ��ȸ
	@Override
	public List<CategoryVO> qcategoryList() throws Exception {
		List qcalist = sql.selectList(namespace+".qcategoryList");
		return qcalist;
	}

	// ���ֹ��� ���� + �۾���
	@Override
	public void qestionsWrite(CategoryVO qca) throws Exception {
		System.out.println("qca"+qca);
		sql.insert(namespace+".qestionisWrite", qca);
		
	}

}
