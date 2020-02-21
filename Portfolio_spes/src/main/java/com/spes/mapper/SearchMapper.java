package com.spes.mapper;

import java.util.List;

import com.spes.model.Criteria;
import com.spes.model.NewVO;

public interface SearchMapper {
	
	//전체 검색기능
	public List<NewVO> searchList(String keyword) throws Exception;


}
