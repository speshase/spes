package com.spes.service;

import java.util.List;

import com.spes.model.CategoryVO;

public interface CustomerService {

	// ���ֹ��� ���� + ��ȸ
	public List<CategoryVO> questionsList() throws Exception;
		
	// ���ֹ��� ���� + �۾���
	public void questionsWrite(CategoryVO qca) throws Exception;
		
	// ���ֹ��� ���� + �ۼ��� ����
	public CategoryVO questionsModify(int qno) throws Exception;
		
	// ���ֹ��� ���� + �ۼ��� �Ϸ�
	public void questionsModifyEnd(CategoryVO qca) throws Exception;
		
	// ���ֹ��� ���� + �ۻ���
	public void questionsDelete(CategoryVO qca) throws Exception;
}
