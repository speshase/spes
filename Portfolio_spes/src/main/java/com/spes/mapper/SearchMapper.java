package com.spes.mapper;

import java.util.List;

import com.spes.model.Criteria;
import com.spes.model.NewVO;

public interface SearchMapper {
	
	//��ü �˻����
	public List<NewVO> searchList(String keyword) throws Exception;


}
