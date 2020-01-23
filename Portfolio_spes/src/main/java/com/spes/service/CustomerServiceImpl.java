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

	// ���ֹ��� ���� + ��ȸ
	@Override
	public List<CategoryVO> questionsList() throws Exception {		
		return cm.questionsList();
	}

	// ���ֹ��� ���� + �۾���
	@Override
	public void questionsWrite(CategoryVO qca) throws Exception {
		cm.questionsWrite(qca);
	}
	
	// ���ֹ��� ���� + �ۼ��� ����
	@Override
	public CategoryVO questionsModify(int qno) throws Exception {
		//System.out.println("service impl qno="+cm.questionsModify(qno).getQno());
		return cm.questionsModify(qno);	
	}
	
	// ���ֹ��� ���� + �ۼ��� �Ϸ�
	@Override
	public void questionsModifyEnd(CategoryVO qca) throws Exception {
		System.out.println("ServiceImpl CategoryVO : "+ qca);
		cm.questionsModifyEnd(qca);
	}
	
	// ���ֹ��� ���� + �ۻ���
	@Override
	public void questionsDelete(CategoryVO qca) throws Exception {
		cm.questionsDelete(qca);
	}

}
