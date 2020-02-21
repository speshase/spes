package com.spes.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spes.model.Category2VO;
import com.spes.model.Category3VO;
import com.spes.model.CategoryVO;
import com.spes.model.CommentsVO;
import com.spes.service.CustomerService;
import com.spes.model.PageVO;
import com.spes.model.UserVO;
import com.spes.model.Criteria;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/questionsList", method = RequestMethod.GET) //자주묻는 질문 + 글조회(페이징)
	public void questionsListPaging(String qcategory, Criteria cri, Model model) throws Exception {
		logger.info("customer/questionsListPaging.jsp");
		
		int total = cservice.questionsCount(qcategory);
		System.out.println("total = "+ total);
		PageVO pv = new PageVO(cri, total);
		logger.info("pv="+pv);
		logger.info("total="+total);
		model.addAttribute("qcatogoryList", cservice.questionsListPaging(qcategory, cri));
		model.addAttribute("page",pv);
	}
	
	@RequestMapping(value="/questionsWrite", method = RequestMethod.GET) //자주묻는 질문 + 글쓰기
	public String questionsWrite() throws Exception {
		logger.info("customer/questionsWrite.jsp");
		return "customer/questionsWrite";
	}
	
	@RequestMapping(value="/questionsWriteEnd", method = RequestMethod.GET) //자주묻는 질문 + 글쓰기(등록)
	public String WriteEnd() throws Exception {
		logger.info("customer/WriteEnd.jsp");
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsWriteEnd", method = RequestMethod.POST) //자주묻는 질문 + 글쓰기(등록)
	public String WriteEndPOST(CategoryVO qca, Model model) throws Exception {
		System.out.println("--- 자주묻는 질문 + 글쓰기 ---");
		logger.info("customer/WriteEndPost.jsp");
		cservice.questionsWrite(qca);
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsModify", method = RequestMethod.GET) //자주묻는 질문 + 글수정 보기
	public void questionsModify(CategoryVO qca, Model model) throws Exception {
		logger.info("customer/questionsModify.jsp");
		model.addAttribute("modify",cservice.questionsModify(qca.getQno()));
		//return "customer/questionsModify";
	}
	
	@RequestMapping(value="/questionsModifyEnd", method = RequestMethod.POST) //자주묻는 질문 + 글수정 완료
	public String questionsModifyEndPOST(CategoryVO qca, RedirectAttributes rttr) throws Exception {
		System.out.println("--- 자주묻는 질문 + 글수정 ---");
		logger.info("customer/questionsModifyPost.jsp");
		logger.info("qca.getQno() = "+qca.getQno()+qca.getQsubject()+qca.getQcontent());
		cservice.questionsModifyEnd(qca);
		return "redirect:questionsList";
	}
	
	@ResponseBody
	@RequestMapping(value="/questionsDelete", method = RequestMethod.GET) //자주묻는 질문 + 글삭제
	public void questionsDelete(CategoryVO qca, Model model) throws Exception {
		System.out.println("--- 자주묻는 질문 + 글삭제 ---");
		System.out.println(qca.getQno());
		logger.info("customer/questionsDelete.jsp");
		cservice.questionsDelete(qca); 
	}
	
	/* 트라비스 소식 */
	
	@RequestMapping(value="/travisNewsList", method = RequestMethod.GET) //트라비스 소식 + 글조회(페이징)
	public void travisNewsListPaging(String ncategory, Criteria cri, Model model) throws Exception {
		logger.info("customer/travisNewsListPaging.jsp");
		logger.info("ncategory = "+ncategory);
		int total = cservice.travisNewsCount(ncategory);
		System.out.println("total = "+ total);
		PageVO pv = new PageVO(cri, total);
		logger.info("pv="+pv);
		logger.info("total="+total);
		model.addAttribute("travisNewsList", cservice.travisNewsListPaging(ncategory, cri));
		model.addAttribute("page",pv);
	}
	
	@RequestMapping(value="/travisNewsWrite", method = RequestMethod.GET) //트라비스 소식 + 글쓰기
	public String travisNewsWrite() throws Exception {
		logger.info("customer/travisNewsWrite.jsp");
		return "customer/travisNewsWrite";
	}
	
	@RequestMapping(value="/travisNewsWriteEnd", method = RequestMethod.GET) //트라비스 소식 + 글쓰기(등록)
	public String travisNewsEnd() throws Exception {
		logger.info("customer/travisNewsWriteEnd.jsp");
		return "redirect:travisNewsList";
	}
	
	@RequestMapping(value="/travisNewsWriteEnd", method = RequestMethod.POST) //트라비스 소식 + 글쓰기(등록)
	public String travisNewsEndPOST(Category2VO nca, Model model) throws Exception {
		System.out.println("--- 트라비스 소식 + 글쓰기 ---");
		logger.info("customer/travisNewsWriteEndPost.jsp");
		cservice.travisNewsWrite(nca);
		return "redirect:travisNewsList";
	}
	
	@RequestMapping(value="/travisNewsModify", method = RequestMethod.GET) //트라비스 소식 + 글수정 보기
	public void travisNewsModify(Category2VO nca, Model model) throws Exception {
		logger.info("customer/travisNewsModify.jsp");
		model.addAttribute("modify",cservice.travisNewsModify(nca.getNno()));
	}
	
	@RequestMapping(value="/travisNewsModifyEnd", method = RequestMethod.POST) //트라비스 소식 + 글수정 완료
	public String travisNewsModifyEndPOST(Category2VO nca, RedirectAttributes rttr) throws Exception {
		System.out.println("--- 트라비스 소식 + 글수정 ---");
		logger.info("customer/travisNewsModifyPost.jsp");
		logger.info("nca.getNno() = "+nca.getNno()+nca.getNsubject()+nca.getNcontent());
		cservice.travisNewsModifyEnd(nca);
		return "redirect:travisNewsList";
	}
	
	@ResponseBody
	@RequestMapping(value="/travisNewsDelete", method = RequestMethod.GET) //트라비스 소식 + 글삭제
	public void travisNewsDelete(Category2VO nca, Model model) throws Exception {
		System.out.println("--- 트라비스 소식 + 글삭제 ---");
		System.out.println(nca.getNno());
		logger.info("customer/travisNewsDelete.jsp");
		cservice.travisNewsDelete(nca);
	}
	
	
	/* 고객의 소리 */
	@RequestMapping(value="/customerService", method = RequestMethod.GET) //고객의 소리 + 글조회(페이징)
	public void customerListPaging(Category3VO ca, String cuid, Criteria cri, Model model, HttpSession session) throws Exception {
		logger.info("customer/customerListPaging.jsp");
		System.out.println("session에 있는 id="+session.getAttribute("uid"));
		String uid=(String)session.getAttribute("uid");
		ca.setCuid(uid);
		
		int total = cservice.customerCount(ca.getCuid()); //(PageVO.class의 total과 같아야함)
		PageVO pv = new PageVO(cri, total);
		logger.info("bservice.boardListPaging(cri)="+cservice.customerListPaging(ca, cri));
		logger.info("pv="+pv);
		logger.info("total="+total);
		model.addAttribute("customerService",cservice.customerListPaging(ca, cri));
		model.addAttribute("page",pv);
	}
	
	//고객의 소리 + Detail Page
	@RequestMapping(value="/customerServiceDetail", method=RequestMethod.GET)
	public void customerServiceDetail(Category3VO ca, CommentsVO comm, Criteria cri, Model model, HttpSession session) throws Exception {
		logger.info("customerServiceDetail get......"+ca.getCno());
		logger.info("customerServiceDetail get......"+comm.getCno());
		logger.info("customerServiceDetail get......"+comm);
		
		String cmuid = (String)session.getAttribute("uid");
		comm.setCmuid(cmuid);
		logger.info("customerServiceDetail get......"+cmuid);
		comm.setCmuid(cmuid);
		logger.info("customerServiceDetail get......"+comm.getCmuid());

		model.addAttribute("detail",cservice.customerServiceDetail(ca.getCno()));
		model.addAttribute("comments",cservice.customerServiceCommentsList(comm, cri));
		}
	
	//고객의 소리 + 글쓰기 보기
	@RequestMapping(value="/customerServiceWrite", method=RequestMethod.GET)
	public String customerServiceWrite() throws Exception {
		logger.info("customer/customerServiceWrite.jsp");
		return "customer/customerServiceWrite";
	}
	
	//고객의 소리 + 글쓰기 완료
	@RequestMapping(value="/customerServiceWriteEnd", method=RequestMethod.POST)
	public String customerServiceWrite(Category3VO ca, Model model) throws Exception {	
		logger.info("customerServiceWrite POST......"+ca);
		cservice.customerServiceWriteEnd(ca);
		return "redirect:customerService";
		}
	
	//고객의 소리 + 글수정 보기
	@RequestMapping(value="/customerServiceModify", method = RequestMethod.GET) //고객의 소리 + 글수정 보기
	public void customerServiceModify(Category3VO ca, Model model) throws Exception {
		logger.info("customer/customerServiceModify.jsp"+ca.getCno());
		model.addAttribute("modify", cservice.customerServiceDetail(ca.getCno()));
	}
	
	//고객의 소리 + 글수정 보기
	@RequestMapping(value="/customerServiceModifyEnd", method = RequestMethod.POST) //고객의 소리 + 글수정 완료
	public String customerServiceModifyEnd(Category3VO ca, Model model) throws Exception {
		logger.info("customer/customerServiceModifyEnd.jsp : "+ca.getCno());
		cservice.customerServiceModify(ca);
		return "redirect:customerService";
	}
	
	//고객의 소리 + 글삭제
	@RequestMapping(value="/customerServiceDelete", method = RequestMethod.GET) //트라비스 소식 + 글삭제
	public String customerServiceDelete(int cno, Model model) throws Exception {
		System.out.println("--- 고객의 소리 + 글삭제 ---");
		logger.info("customer/customerServiceDelete.jsp : " + cno);
		cservice.customerServiceDelete(cno);
		return "redirect:customerService";
	}
	
	/* 고객의 소리 댓글달기 */
	
	//고객의 소리 + 댓글 조회는 customserServiceDetail에서 같이 로드.
	
	//고객의 소리 + 댓글 등록
	@ResponseBody
	@RequestMapping(value="/commentsWrite", method = RequestMethod.POST)
	public void commentsWrite(@RequestBody CommentsVO comments, Model model) throws Exception {
		System.out.println("--- 고객의 소리 + 댓글 등록 ---");
		System.out.println(comments);
		cservice.commentsWrite(comments);
	}
	
	//고객의 소리 + 댓글 수정
	@ResponseBody
	@RequestMapping(value="/commentsModify", method = RequestMethod.POST)
	public void commentsModify(@RequestBody CommentsVO comments, Model model) throws Exception {
		System.out.println("--- 고객의 소리 + 댓글 수정 ---");
		System.out.println("commensVO : "+comments);
		cservice.commentsModify(comments);
	}

	//고객의 소리 + 댓글 삭제
	@ResponseBody
	@RequestMapping(value="/commentsDelete", method = RequestMethod.POST)
	public void commentsDelete(@RequestBody CommentsVO comments, Model model) throws Exception {
		System.out.println("--- 고객의 소리 + 댓글 삭제 ---");
		System.out.println("commensVO : "+comments);
		cservice.commentsDelete(comments);
	}
}
	
	
	

