package com.spes.service;

import java.util.List;

import com.spes.model.Criteria;
import com.spes.model.NewVO;

public interface SearchService {
	
	//��ü �˻����
	public List<NewVO> searchList(String keyword) throws Exception;

}
