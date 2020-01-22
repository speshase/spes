package com.spes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spes.mapper.CustomerMapper;
import com.spes.model.CategoryVO;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerMapper cm;

	// 자주묻는 질문 + 조회
	@Override
	public List<CategoryVO> qcategoryList() throws Exception {		
		return cm.qcategoryList();
	}

	// 자주묻는 질문 + 글쓰기
	@Override
	public void qestionsWrite(CategoryVO qca) throws Exception {
		cm.qestionsWrite(qca);
		
	}

}
