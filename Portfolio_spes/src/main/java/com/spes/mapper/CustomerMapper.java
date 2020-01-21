package com.spes.mapper;

import java.util.List;

import com.spes.model.CategoryVO;

public interface CustomerMapper {
	
	//카테고리 전체조회
	public List<CategoryVO> qcategoryList() throws Exception;


}
