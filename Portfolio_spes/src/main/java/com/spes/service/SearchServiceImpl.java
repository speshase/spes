package com.spes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spes.mapper.SearchMapper;
import com.spes.model.Criteria;
import com.spes.model.NewVO;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	SearchMapper sm;

	//전체 검색기능
	@Override
	public List<NewVO> searchList(String keyword) throws Exception {
		System.out.println("하헤히호후 service"+keyword);
		return sm.searchList(keyword);
	}

}
