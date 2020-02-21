package com.spes.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spes.model.Category2VO;
import com.spes.model.Category3VO;
import com.spes.model.CategoryVO;
import com.spes.model.CommentsVO;
import com.spes.model.Criteria;

@Repository
public class CustomerMapperImpl implements CustomerMapper{
	
	@Autowired
	private SqlSession sql;
	private static final String namespace = "com.spes.mapper.CustomerMapper";
	
	//���ֹ��� ����
	//���ֹ��� ���� + ��ȸ(5���� ����¡)
	public List<CategoryVO> questionsListPaging(String qcategory, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("qcategory", qcategory);
		paramMap.put("pageNum", cri.getPageNum());
		paramMap.put("amount", cri.getAmount());
		System.out.println("customerMapper selectList="+paramMap);
		List list = sql.selectList(namespace+".questionsListPaging", paramMap);
		return list;
	}
		
	//questionsList ���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	public int questionsCount(String qcategory) throws Exception {
		int cnt=sql.selectOne(namespace+".questionsCount",qcategory);
		return cnt;
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
		System.out.println("customerMapperImpl="+qca);
		
	}

	
	//Ʈ��� �ҽ�
	//Ʈ��� �ҽ� + ��ȸ(5���� ����¡)
	@Override
	public List<CategoryVO> travisNewsListPaging(String ncategory, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ncategory", ncategory);
		paramMap.put("pageNum", cri.getPageNum());
		paramMap.put("amount", cri.getAmount());
		System.out.println("customerMapper selectList="+paramMap);
		List nlist = sql.selectList(namespace+".travisNewsListPaging", paramMap);
		return nlist;
	}

	//travisNewsList ���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	@Override
	public int travisNewsCount(String ncategory) throws Exception {
		int cnt=sql.selectOne(namespace+".travisNewsCount", ncategory);
		return cnt;
	}

	//Ʈ��� �ҽ� + �۾���
	@Override
	public void travisNewsWrite(Category2VO nca) throws Exception {
		System.out.println("Mapper Impl Category2VO = "+nca);
		sql.insert(namespace+".travisNewsWrite", nca);
	}

	//Ʈ��� �ҽ� + �ۼ��� ����	
	@Override
	public Category2VO travisNewsModify(int nno) throws Exception {
		Category2VO nca = sql.selectOne(namespace+".travisNewsModify", nno);
		System.out.println("mapper impl nno="+nca.getNno());
		return nca;
	}

	//Ʈ��� �ҽ� + �ۼ��� �Ϸ�
	@Override
	public void travisNewsModifyEnd(Category2VO nca) throws Exception {
		sql.update(namespace+".travisNewsModifyEnd", nca);	
		System.out.println("mapper impl nca update = "+nca);		
	}

	//Ʈ��� �ҽ� + �ۻ���	
	@Override
	public void travisNewsDelete(Category2VO nca) throws Exception {
		sql.delete(namespace+".travisNewsDelete", nca);
		System.out.println("mapper impl nca delete = "+nca);
	}

	
	//���� �Ҹ�
	//���� �Ҹ� + ��ȸ(5���� ����¡)
	@Override
	public List<Category3VO> customerListPaging(Category3VO ca, Criteria cri) throws Exception {
		System.out.println("Mapper cri="+cri);
		Map<String, Object> paramMap = new HashMap<String,Object>();
		System.out.println("Mapper ca.getCuid()="+ca.getCuid());
		paramMap.put("cuid", ca.getCuid());
		paramMap.put("cri", cri);
		List list = sql.selectList(namespace+".customerServiceListPaging", paramMap);
		return list;
	}

	//customerService ���̺��� ��ü�Խù� ���� : ����¡�� realEnd�� �˱� ���ؼ�
	@Override
	public int customerCount(String cuid) throws Exception {
		int cnt=sql.selectOne(namespace+".customerCount", cuid);
		return cnt;
	}

	//�Խ��� ������ Ŭ������ ��
	@Override
	public Category3VO customerServiceDetail(int cno) throws Exception {
		Category3VO ca = sql.selectOne(namespace+".customerServiceDetail", cno);
		return ca;
	}

	//���� �Ҹ� + �۾���
	@Override
	public void customerServiceWriteEnd(Category3VO ca) throws Exception {
		sql.insert(namespace+".customerServiceWriteEnd", ca);
	}
	
	//Ʈ��� �ҽ� + �ۼ��� �Ϸ�
	@Override
	public void customerServiceModify(Category3VO ca) throws Exception {
		sql.update(namespace+".customerServiceModifyEnd", ca);
	}

	//���� �Ҹ� + �ۻ���
	@Override
	public void customerServiceDelete(int cno) throws Exception {
		System.out.println("�ۻ��� Mapper delete ca : " + cno);
		sql.delete(namespace+".customerServiceDelete", cno);
		
	}

	
	//���� �Ҹ� + ��۰���
	//�����ȸ(5���� ����¡)
	@Override
	public List<CommentsVO> customerServiceCommentsList(CommentsVO comm, Criteria cri) throws Exception {
		System.out.println("Mapper cri="+cri);
		Map<String, Object> paramMap = new HashMap<String,Object>();
		System.out.println("Mapper comm.getCno() : "+comm.getCno());
		paramMap.put("cno", comm.getCno());
		paramMap.put("cri", cri);
		List list = sql.selectList(namespace+".customerServiceCommentsList", paramMap);
		return list;
	}

	//��۵��
	@Override
	public void commentsWrite(CommentsVO co) throws Exception {
		sql.delete(namespace+".commentsWrite", co);	
		System.out.println("commentsWrite MapperImpl="+co);
	}

	//��ۼ���
	@Override
	public void commentsModify(CommentsVO co) throws Exception {
		sql.update(namespace+".commentsModify", co);
		System.out.println("commentsModify MapperImpl="+co);
	}

	//��ۻ���
	@Override
	public void commentsDelete(CommentsVO co) throws Exception {
		sql.delete(namespace+".commentsDelete", co);
		System.out.println("commentsDelete MapperImpl="+co);
	}


}
