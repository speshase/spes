package com.spes.service;

import java.util.List;

import com.spes.model.CategoryVO;

public interface CustomerService {

	// ���ֹ��� ���� + ��ȸ
	public List<CategoryVO> qcategoryList() throws Exception;
	
	// ���ֹ��� ���� + �۾���
	public void qestionsWrite(CategoryVO qca) throws Exception;

}
