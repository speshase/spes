package com.spes.service;

import java.util.List;

import com.spes.model.CategoryVO;

public interface CustomerService {

	// 자주묻는 질문 + 조회
	public List<CategoryVO> questionsList() throws Exception;
		
	// 자주묻는 질문 + 글쓰기
	public void questionsWrite(CategoryVO qca) throws Exception;
		
	// 자주묻는 질문 + 글수정 보기
	public CategoryVO questionsModify(int qno) throws Exception;
		
	// 자주묻는 질문 + 글수정 완료
	public void questionsModifyEnd(CategoryVO qca) throws Exception;
		
	// 자주묻는 질문 + 글삭제
	public void questionsDelete(CategoryVO qca) throws Exception;
}
