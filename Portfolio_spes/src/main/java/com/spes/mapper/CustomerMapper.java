package com.spes.mapper;

import java.util.List;

import com.spes.model.Category2VO;
import com.spes.model.Category3VO;
import com.spes.model.CategoryVO;
import com.spes.model.CommentsVO;
import com.spes.model.Criteria;

public interface CustomerMapper {
		
	//자주묻는 질문
	//자주묻는 질문 + 조회(5개씩 페이징)
	public List<CategoryVO> questionsListPaging(String qcategory, Criteria cri) throws Exception;
		
	//questionsList 테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	public int questionsCount(String qcategory) throws Exception;
	
	// 자주묻는 질문 + 글쓰기
	public void questionsWrite(CategoryVO qca) throws Exception;
	
	// 자주묻는 질문 + 글수정 보기
	public CategoryVO questionsModify(int qno) throws Exception;
	
	// 자주묻는 질문 + 글수정 완료
	public void questionsModifyEnd(CategoryVO qca) throws Exception;
	
	// 자주묻는 질문 + 글삭제
	public void questionsDelete(CategoryVO qca) throws Exception;

	
	//트라비스 소식
	//트라비스 소식 + 조회(5개씩 페이징)
	public List<CategoryVO> travisNewsListPaging(String ncategory, Criteria cri) throws Exception;
			
	//travisNewsList 테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	public int travisNewsCount(String ncategory) throws Exception;
		
	// 트라비스 소식 + 글쓰기
	public void travisNewsWrite(Category2VO nca) throws Exception;
		
	// 트라비스 소식 + 글수정 보기
	public Category2VO travisNewsModify(int nno) throws Exception;
		
	// 트라비스 소식 + 글수정 완료
	public void travisNewsModifyEnd(Category2VO nca) throws Exception;
		
	// 트라비스 소식 + 글삭제
	public void travisNewsDelete(Category2VO nca) throws Exception;
	
	
	//고객의 소리
	//고객의 소리 + 조회(5개씩 페이징)
	public List<Category3VO> customerListPaging(Category3VO ca, Criteria cri) throws Exception;
		
	//customerService 테이블의 전체게시물 개수 : 페이징의 realEnd를 알기 위해서
	public int customerCount(String cuid) throws Exception;
	
	//게시판 제목을 클릭했을 때
	public Category3VO customerServiceDetail(int cno) throws Exception;
	
	//고객의 소리 + 글쓰기
	public void customerServiceWriteEnd(Category3VO ca) throws Exception;
	
	//고객의 소리 + 글수정 보기
	public void customerServiceModify(Category3VO ca) throws Exception;
	
	//고객의 소리 + 글삭제
	public void customerServiceDelete(int cno) throws Exception;
	
	
	//고객의 소리 + 댓글관련
	//댓글조회(5개씩 페이징)
	public List<CommentsVO> customerServiceCommentsList(CommentsVO comm, Criteria cri) throws Exception;
	
	//댓글등록
	public void commentsWrite(CommentsVO co) throws Exception;
	
	//댓글수정
	public void commentsModify(CommentsVO co) throws Exception;
	
	//댓글삭제
	public void commentsDelete(CommentsVO co) throws Exception;
}
