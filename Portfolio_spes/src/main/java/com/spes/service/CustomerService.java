package com.spes.service;

import java.util.List;

import com.spes.model.CategoryVO;

public interface CustomerService {

	//카테고리 전체조회
	public List<CategoryVO> qcategoryList() throws Exception;

}
