package com.spes.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spes.model.Criteria;
import com.spes.model.NewVO;

@Repository
public class SearchMapperImpl implements SearchMapper{
	
	@Autowired
	private SqlSession sql;
	private static final String namespace="com.spes.mapper.SearchMapper";

	//전체 검색기능
	@Override
	public List<NewVO> searchList(String keyword) throws Exception {
		System.out.println("후후후후후후 mapper "+keyword);
		List list = sql.selectList(namespace+".searchList", keyword);
		System.out.println("호우우우우우"+list);
		return list;
	}

}
