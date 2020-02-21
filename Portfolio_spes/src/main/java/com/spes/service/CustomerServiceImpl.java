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

	//자주묻는 질문
	//자주묻는 질문 + 조회(5개씩 페이징)
	@Override
	public List<CategoryVO> questionsListPaging(String qcategory, Criteria cri) throws Exception {
		System.out.println("service impl qcategory = "+qcategory);
		System.out.println("service impl pageNum = "+cri.getPageNum());
		System.out.println("service impl amount = "+cri.getAmount());
		return cm.questionsListPaging(qcategory, cri);
	}

	//questionsList 테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	@Override
	public int questionsCount(String qcategory) throws Exception {
		return cm.questionsCount(qcategory);
	}

	// 자주묻는 질문 + 글쓰기
	@Override
	public void questionsWrite(CategoryVO qca) throws Exception {
		cm.questionsWrite(qca);
	}
	
	// 자주묻는 질문 + 글수정 보기
	@Override
	public CategoryVO questionsModify(int qno) throws Exception {
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

	
	//트라비스 소식
	//트라비스 소식 + 조회(5개씩 페이징)
	@Override
	public List<CategoryVO> travisNewsListPaging(String ncategory, Criteria cri) throws Exception {
		System.out.println("service impl ncategory = "+ncategory);
		System.out.println("service impl pageNum = "+cri.getPageNum());
		System.out.println("service impl amount = "+cri.getAmount());
		return cm.travisNewsListPaging(ncategory, cri);
	}

	//travisNewsList 테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	@Override
	public int travisNewsCount(String ncategory) throws Exception {
		return cm.travisNewsCount(ncategory);
	}

	// 트라비스 소식 + 글쓰기
	@Override
	public void travisNewsWrite(Category2VO nca) throws Exception {
		cm.travisNewsWrite(nca);
		
	}

	// 트라비스 소식 + 글수정 보기
	@Override
	public Category2VO travisNewsModify(int nno) throws Exception {
		System.out.println("Service Impl travisNewsModify = "+nno);
		return cm.travisNewsModify(nno);
	}

	// 트라비스 소식 + 글수정 완료
	@Override
	public void travisNewsModifyEnd(Category2VO nca) throws Exception {
		System.out.println("ServiceImpl Category2VO : "+ nca);
		cm.travisNewsModifyEnd(nca);
	}

	// 트라비스 소식 + 글삭제
	@Override
	public void travisNewsDelete(Category2VO nca) throws Exception {
		cm.travisNewsDelete(nca);
	}
	
	//고객의 소리
	//고객의 소리 + 조회(5개씩 페이징)
	@Override
	public List<Category3VO> customerListPaging(Category3VO ca, Criteria cri) throws Exception {
		System.out.println("service cri="+cri);
		return cm.customerListPaging(ca, cri);
	}

	// customerService 테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	@Override
	public int customerCount(String cuid) throws Exception {
		return cm.customerCount(cuid);
	}

	// 게시판 제목을 클릭했을 때
	@Override
	public Category3VO customerServiceDetail(int cno) throws Exception {
		return cm.customerServiceDetail(cno);
	}

	//고객의 소리 + 글쓰기
	@Override
	public void customerServiceWriteEnd(Category3VO ca) throws Exception {
		cm.customerServiceWriteEnd(ca);
	}	
	
	//고객의 소리 + 글수정 완료
	@Override
	public void customerServiceModify(Category3VO ca) throws Exception {
		cm.customerServiceModify(ca);
	}

	//고객의 소리 + 글삭제
	@Override
	public void customerServiceDelete(int cno) throws Exception {
		System.out.println("Service Impl customerServiceDelete : " + cno);
		cm.customerServiceDelete(cno);
		
	}
	
	//고객의 소리 + 댓글관련
	//댓글조회(5개씩 페이징)
	@Override
	public List<CommentsVO> customerServiceCommentsList(CommentsVO comm, Criteria cri) throws Exception {
		System.out.println("CommentsVO comm : "+ comm);
		return cm.customerServiceCommentsList(comm, cri);
	}

	//댓글등록
	@Override
	public void commentsWrite(CommentsVO co) throws Exception {
		System.out.println("Service Impl commentWrite : " + co);
		cm.commentsWrite(co);
		
	}

	//댓글수정
	@Override
	public void commentsModify(CommentsVO co) throws Exception {
		System.out.println("Service Impl commentsModify : " + co);
		cm.commentsModify(co);
		
	}

	//댓글삭제
	@Override
	public void commentsDelete(CommentsVO co) throws Exception {
		System.out.println("Service Impl commentsDelete : " + co);
		cm.commentsDelete(co);	
	}
}
