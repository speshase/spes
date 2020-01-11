package com.speshase.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointMapperImpl implements PointMapper {
	
	@Autowired
	private SqlSession session;
	
	private static final String namespace = "com.speshase.mapper.PointMapper";

	@Override
	public void updatePoint(String uid, int point) throws Exception {
		//uid와 point 두개를 HashMap 하나로 묶기.
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", uid);
		paramMap.put("point", point);

		session.update(namespace + ".updatePoint", paramMap);
	}
}
