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

	// ���ֹ��� ���� + ��ȸ
	@Override
	public List<CategoryVO> qcategoryList() throws Exception {		
		return cm.qcategoryList();
	}

	// ���ֹ��� ���� + �۾���
	@Override
	public void qestionsWrite(CategoryVO qca) throws Exception {
		cm.qestionsWrite(qca);
		
	}

}
