package com.spes.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spes.model.CategoryVO;

@Repository
public class CustomerMapperImpl implements CustomerMapper{
	
	@Autowired
	private SqlSession sql;
	private static final String namespace = "com.spes.mapper.CustomerMapper";

	// ���ֹ��� ���� + ��ȸ
	@Override
	public List<CategoryVO> questionsList() throws Exception {
		List qcalist = sql.selectList(namespace+".questionsList");
		return qcalist;
	}

	// ���ֹ��� ���� + �۾���
	@Override
	public void questionsWrite(CategoryVO qca) throws Exception {
		System.out.println("qca"+qca);
		sql.insert(namespace+".questionsWrite", qca);		
	}

	//���ֹ��� ���� + �ۼ��� ����	
	@Override
	public CategoryVO questionsModify(int qno) throws Exception {
		CategoryVO qca = sql.selectOne(namespace+".questionsModify", qno);
		System.out.println("mapper impl qno="+qca.getQno());
		return qca;	
	}
	
	//���ֹ��� ���� + �ۼ��� �Ϸ�
	@Override
	public void questionsModifyEnd(CategoryVO qca) throws Exception {
		sql.update(namespace+".questionsModifyEnd", qca);	
		System.out.println("mapper impl qno update = "+qca);
	}
		
	// ���ֹ��� ���� + �ۻ���		
	@Override
	public void questionsDelete(CategoryVO qca) throws Exception {
		sql.delete(namespace+".questionsDelete", qca);	
		
	}

}
