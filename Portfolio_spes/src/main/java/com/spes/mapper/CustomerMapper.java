package com.spes.mapper;

import java.util.List;

import com.spes.model.CategoryVO;

public interface CustomerMapper {
	
	// 자주묻는 질문 + 조회
	public List<CategoryVO> qcategoryList() throws Exception;
	
	// 자주묻는 질문 + 글쓰기
	public void qestionsWrite(CategoryVO qca) throws Exception;

}
