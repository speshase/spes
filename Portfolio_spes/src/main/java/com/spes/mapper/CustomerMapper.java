package com.spes.mapper;

import java.util.List;

import com.spes.model.Category2VO;
import com.spes.model.Category3VO;
import com.spes.model.CategoryVO;
import com.spes.model.CommentsVO;
import com.spes.model.Criteria;

public interface CustomerMapper {
		
	//���ֹ��� ����
	//���ֹ��� ���� + ��ȸ(5���� ����¡)
	public List<CategoryVO> questionsListPaging(String qcategory, Criteria cri) throws Exception;
		
	//questionsList ���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	public int questionsCount(String qcategory) throws Exception;
	
	// ���ֹ��� ���� + �۾���
	public void questionsWrite(CategoryVO qca) throws Exception;
	
	// ���ֹ��� ���� + �ۼ��� ����
	public CategoryVO questionsModify(int qno) throws Exception;
	
	// ���ֹ��� ���� + �ۼ��� �Ϸ�
	public void questionsModifyEnd(CategoryVO qca) throws Exception;
	
	// ���ֹ��� ���� + �ۻ���
	public void questionsDelete(CategoryVO qca) throws Exception;

	
	//Ʈ��� �ҽ�
	//Ʈ��� �ҽ� + ��ȸ(5���� ����¡)
	public List<CategoryVO> travisNewsListPaging(String ncategory, Criteria cri) throws Exception;
			
	//travisNewsList ���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	public int travisNewsCount(String ncategory) throws Exception;
		
	// Ʈ��� �ҽ� + �۾���
	public void travisNewsWrite(Category2VO nca) throws Exception;
		
	// Ʈ��� �ҽ� + �ۼ��� ����
	public Category2VO travisNewsModify(int nno) throws Exception;
		
	// Ʈ��� �ҽ� + �ۼ��� �Ϸ�
	public void travisNewsModifyEnd(Category2VO nca) throws Exception;
		
	// Ʈ��� �ҽ� + �ۻ���
	public void travisNewsDelete(Category2VO nca) throws Exception;
	
	
	//���� �Ҹ�
	//���� �Ҹ� + ��ȸ(5���� ����¡)
	public List<Category3VO> customerListPaging(Category3VO ca, Criteria cri) throws Exception;
		
	//customerService ���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	public int customerCount(String cuid) throws Exception;
	
	//�Խ��� ������ Ŭ������ ��
	public Category3VO customerServiceDetail(int cno) throws Exception;
	
	//���� �Ҹ� + �۾���
	public void customerServiceWriteEnd(Category3VO ca) throws Exception;
	
	//���� �Ҹ� + �ۼ��� ����
	public void customerServiceModify(Category3VO ca) throws Exception;
	
	//���� �Ҹ� + �ۻ���
	public void customerServiceDelete(int cno) throws Exception;
	
	
	//���� �Ҹ� + ��۰���
	//�����ȸ(5���� ����¡)
	public List<CommentsVO> customerServiceCommentsList(CommentsVO comm, Criteria cri) throws Exception;
	
	//��۵��
	public void commentsWrite(CommentsVO co) throws Exception;
	
	//��ۼ���
	public void commentsModify(CommentsVO co) throws Exception;
	
	//��ۻ���
	public void commentsDelete(CommentsVO co) throws Exception;
}
