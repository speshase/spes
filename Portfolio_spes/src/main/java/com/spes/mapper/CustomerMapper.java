package com.spes.mapper;

import java.util.List;

import com.spes.model.CategoryVO;

public interface CustomerMapper {
	
	// ���ֹ��� ���� + ��ȸ
	public List<CategoryVO> qcategoryList() throws Exception;
	
	// ���ֹ��� ���� + �۾���
	public void qestionsWrite(CategoryVO qca) throws Exception;

}
