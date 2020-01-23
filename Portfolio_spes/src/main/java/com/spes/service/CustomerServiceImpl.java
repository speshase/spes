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

	// 자주묻는 질문 + 조회
	@Override
	public List<CategoryVO> questionsList() throws Exception {		
		return cm.questionsList();
	}

	// 자주묻는 질문 + 글쓰기
	@Override
	public void questionsWrite(CategoryVO qca) throws Exception {
		cm.questionsWrite(qca);
	}
	
	// 자주묻는 질문 + 글수정 보기
	@Override
	public CategoryVO questionsModify(int qno) throws Exception {
		//System.out.println("service impl qno="+cm.questionsModify(qno).getQno());
		return cm.questionsModify(qno);	
	}
	
	// 자주묻는 질문 + 글수정 완료
	@Override
	public void questionsModifyEnd(CategoryVO qca) throws Exception {
		System.out.println("ServiceImpl CategoryVO : "+ qca);
		cm.questionsModifyEnd(qca);
	}
	
	// 자주묻는 질문 + 글삭제
	@Override
	public void questionsDelete(CategoryVO qca) throws Exception {
		cm.questionsDelete(qca);
	}

}
