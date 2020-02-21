package com.spes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spes.mapper.CustomerMapper;
import com.spes.model.Category2VO;
import com.spes.model.Category3VO;
import com.spes.model.CategoryVO;
import com.spes.model.CommentsVO;
import com.spes.model.Criteria;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerMapper cm;

	//���ֹ��� ����
	//���ֹ��� ���� + ��ȸ(5���� ����¡)
	@Override
	public List<CategoryVO> questionsListPaging(String qcategory, Criteria cri) throws Exception {
		System.out.println("service impl qcategory = "+qcategory);
		System.out.println("service impl pageNum = "+cri.getPageNum());
		System.out.println("service impl amount = "+cri.getAmount());
		return cm.questionsListPaging(qcategory, cri);
	}

	//questionsList ���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	@Override
	public int questionsCount(String qcategory) throws Exception {
		return cm.questionsCount(qcategory);
	}

	// ���ֹ��� ���� + �۾���
	@Override
	public void questionsWrite(CategoryVO qca) throws Exception {
		cm.questionsWrite(qca);
	}
	
	// ���ֹ��� ���� + �ۼ��� ����
	@Override
	public CategoryVO questionsModify(int qno) throws Exception {
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

	
	//Ʈ��� �ҽ�
	//Ʈ��� �ҽ� + ��ȸ(5���� ����¡)
	@Override
	public List<CategoryVO> travisNewsListPaging(String ncategory, Criteria cri) throws Exception {
		System.out.println("service impl ncategory = "+ncategory);
		System.out.println("service impl pageNum = "+cri.getPageNum());
		System.out.println("service impl amount = "+cri.getAmount());
		return cm.travisNewsListPaging(ncategory, cri);
	}

	//travisNewsList ���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	@Override
	public int travisNewsCount(String ncategory) throws Exception {
		return cm.travisNewsCount(ncategory);
	}

	// Ʈ��� �ҽ� + �۾���
	@Override
	public void travisNewsWrite(Category2VO nca) throws Exception {
		cm.travisNewsWrite(nca);
		
	}

	// Ʈ��� �ҽ� + �ۼ��� ����
	@Override
	public Category2VO travisNewsModify(int nno) throws Exception {
		System.out.println("Service Impl travisNewsModify = "+nno);
		return cm.travisNewsModify(nno);
	}

	// Ʈ��� �ҽ� + �ۼ��� �Ϸ�
	@Override
	public void travisNewsModifyEnd(Category2VO nca) throws Exception {
		System.out.println("ServiceImpl Category2VO : "+ nca);
		cm.travisNewsModifyEnd(nca);
	}

	// Ʈ��� �ҽ� + �ۻ���
	@Override
	public void travisNewsDelete(Category2VO nca) throws Exception {
		cm.travisNewsDelete(nca);
	}
	
	//���� �Ҹ�
	//���� �Ҹ� + ��ȸ(5���� ����¡)
	@Override
	public List<Category3VO> customerListPaging(Category3VO ca, Criteria cri) throws Exception {
		System.out.println("service cri="+cri);
		return cm.customerListPaging(ca, cri);
	}

	// customerService ���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	@Override
	public int customerCount(String cuid) throws Exception {
		return cm.customerCount(cuid);
	}

	// �Խ��� ������ Ŭ������ ��
	@Override
	public Category3VO customerServiceDetail(int cno) throws Exception {
		return cm.customerServiceDetail(cno);
	}

	//���� �Ҹ� + �۾���
	@Override
	public void customerServiceWriteEnd(Category3VO ca) throws Exception {
		cm.customerServiceWriteEnd(ca);
	}	
	
	//���� �Ҹ� + �ۼ��� �Ϸ�
	@Override
	public void customerServiceModify(Category3VO ca) throws Exception {
		cm.customerServiceModify(ca);
	}

	//���� �Ҹ� + �ۻ���
	@Override
	public void customerServiceDelete(int cno) throws Exception {
		System.out.println("Service Impl customerServiceDelete : " + cno);
		cm.customerServiceDelete(cno);
		
	}
	
	//���� �Ҹ� + ��۰���
	//�����ȸ(5���� ����¡)
	@Override
	public List<CommentsVO> customerServiceCommentsList(CommentsVO comm, Criteria cri) throws Exception {
		System.out.println("CommentsVO comm : "+ comm);
		return cm.customerServiceCommentsList(comm, cri);
	}

	//��۵��
	@Override
	public void commentsWrite(CommentsVO co) throws Exception {
		System.out.println("Service Impl commentWrite : " + co);
		cm.commentsWrite(co);
		
	}

	//��ۼ���
	@Override
	public void commentsModify(CommentsVO co) throws Exception {
		System.out.println("Service Impl commentsModify : " + co);
		cm.commentsModify(co);
		
	}

	//��ۻ���
	@Override
	public void commentsDelete(CommentsVO co) throws Exception {
		System.out.println("Service Impl commentsDelete : " + co);
		cm.commentsDelete(co);	
	}
}
