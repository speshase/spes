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
	
	@RequestMapping(value="/questionsList", method = RequestMethod.GET) //���ֹ��� ���� + ����ȸ(����¡)
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
	
	@RequestMapping(value="/questionsWrite", method = RequestMethod.GET) //���ֹ��� ���� + �۾���
	public String questionsWrite() throws Exception {
		logger.info("customer/questionsWrite.jsp");
		return "customer/questionsWrite";
	}
	
	@RequestMapping(value="/questionsWriteEnd", method = RequestMethod.GET) //���ֹ��� ���� + �۾���(���)
	public String WriteEnd() throws Exception {
		logger.info("customer/WriteEnd.jsp");
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsWriteEnd", method = RequestMethod.POST) //���ֹ��� ���� + �۾���(���)
	public String WriteEndPOST(CategoryVO qca, Model model) throws Exception {
		System.out.println("--- ���ֹ��� ���� + �۾��� ---");
		logger.info("customer/WriteEndPost.jsp");
		cservice.questionsWrite(qca);
		return "redirect:questionsList";
	}
	
	@RequestMapping(value="/questionsModify", method = RequestMethod.GET) //���ֹ��� ���� + �ۼ��� ����
	public void questionsModify(CategoryVO qca, Model model) throws Exception {
		logger.info("customer/questionsModify.jsp");
		model.addAttribute("modify",cservice.questionsModify(qca.getQno()));
		//return "customer/questionsModify";
	}
	
	@RequestMapping(value="/questionsModifyEnd", method = RequestMethod.POST) //���ֹ��� ���� + �ۼ��� �Ϸ�
	public String questionsModifyEndPOST(CategoryVO qca, RedirectAttributes rttr) throws Exception {
		System.out.println("--- ���ֹ��� ���� + �ۼ��� ---");
		logger.info("customer/questionsModifyPost.jsp");
		logger.info("qca.getQno() = "+qca.getQno()+qca.getQsubject()+qca.getQcontent());
		cservice.questionsModifyEnd(qca);
		return "redirect:questionsList";
	}
	
	@ResponseBody
	@RequestMapping(value="/questionsDelete", method = RequestMethod.GET) //���ֹ��� ���� + �ۻ���
	public void questionsDelete(CategoryVO qca, Model model) throws Exception {
		System.out.println("--- ���ֹ��� ���� + �ۻ��� ---");
		System.out.println(qca.getQno());
		logger.info("customer/questionsDelete.jsp");
		cservice.questionsDelete(qca); 
	}
	
	/* Ʈ��� �ҽ� */
	
	@RequestMapping(value="/travisNewsList", method = RequestMethod.GET) //Ʈ��� �ҽ� + ����ȸ(����¡)
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
	
	@RequestMapping(value="/travisNewsWrite", method = RequestMethod.GET) //Ʈ��� �ҽ� + �۾���
	public String travisNewsWrite() throws Exception {
		logger.info("customer/travisNewsWrite.jsp");
		return "customer/travisNewsWrite";
	}
	
	@RequestMapping(value="/travisNewsWriteEnd", method = RequestMethod.GET) //Ʈ��� �ҽ� + �۾���(���)
	public String travisNewsEnd() throws Exception {
		logger.info("customer/travisNewsWriteEnd.jsp");
		return "redirect:travisNewsList";
	}
	
	@RequestMapping(value="/travisNewsWriteEnd", method = RequestMethod.POST) //Ʈ��� �ҽ� + �۾���(���)
	public String travisNewsEndPOST(Category2VO nca, Model model) throws Exception {
		System.out.println("--- Ʈ��� �ҽ� + �۾��� ---");
		logger.info("customer/travisNewsWriteEndPost.jsp");
		cservice.travisNewsWrite(nca);
		return "redirect:travisNewsList";
	}
	
	@RequestMapping(value="/travisNewsModify", method = RequestMethod.GET) //Ʈ��� �ҽ� + �ۼ��� ����
	public void travisNewsModify(Category2VO nca, Model model) throws Exception {
		logger.info("customer/travisNewsModify.jsp");
		model.addAttribute("modify",cservice.travisNewsModify(nca.getNno()));
	}
	
	@RequestMapping(value="/travisNewsModifyEnd", method = RequestMethod.POST) //Ʈ��� �ҽ� + �ۼ��� �Ϸ�
	public String travisNewsModifyEndPOST(Category2VO nca, RedirectAttributes rttr) throws Exception {
		System.out.println("--- Ʈ��� �ҽ� + �ۼ��� ---");
		logger.info("customer/travisNewsModifyPost.jsp");
		logger.info("nca.getNno() = "+nca.getNno()+nca.getNsubject()+nca.getNcontent());
		cservice.travisNewsModifyEnd(nca);
		return "redirect:travisNewsList";
	}
	
	@ResponseBody
	@RequestMapping(value="/travisNewsDelete", method = RequestMethod.GET) //Ʈ��� �ҽ� + �ۻ���
	public void travisNewsDelete(Category2VO nca, Model model) throws Exception {
		System.out.println("--- Ʈ��� �ҽ� + �ۻ��� ---");
		System.out.println(nca.getNno());
		logger.info("customer/travisNewsDelete.jsp");
		cservice.travisNewsDelete(nca);
	}
	
	
	/* ���� �Ҹ� */
	@RequestMapping(value="/customerService", method = RequestMethod.GET) //���� �Ҹ� + ����ȸ(����¡)
	public void customerListPaging(Category3VO ca, String cuid, Criteria cri, Model model, HttpSession session) throws Exception {
		logger.info("customer/customerListPaging.jsp");
		System.out.println("session�� �ִ� id="+session.getAttribute("uid"));
		String uid=(String)session.getAttribute("uid");
		ca.setCuid(uid);
		
		int total = cservice.customerCount(ca.getCuid()); //(PageVO.class�� total�� ���ƾ���)
		PageVO pv = new PageVO(cri, total);
		logger.info("bservice.boardListPaging(cri)="+cservice.customerListPaging(ca, cri));
		logger.info("pv="+pv);
		logger.info("total="+total);
		model.addAttribute("customerService",cservice.customerListPaging(ca, cri));
		model.addAttribute("page",pv);
	}
	
	//���� �Ҹ� + Detail Page
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
	
	//���� �Ҹ� + �۾��� ����
	@RequestMapping(value="/customerServiceWrite", method=RequestMethod.GET)
	public String customerServiceWrite() throws Exception {
		logger.info("customer/customerServiceWrite.jsp");
		return "customer/customerServiceWrite";
	}
	
	//���� �Ҹ� + �۾��� �Ϸ�
	@RequestMapping(value="/customerServiceWriteEnd", method=RequestMethod.POST)
	public String customerServiceWrite(Category3VO ca, Model model) throws Exception {	
		logger.info("customerServiceWrite POST......"+ca);
		cservice.customerServiceWriteEnd(ca);
		return "redirect:customerService";
		}
	
	//���� �Ҹ� + �ۼ��� ����
	@RequestMapping(value="/customerServiceModify", method = RequestMethod.GET) //���� �Ҹ� + �ۼ��� ����
	public void customerServiceModify(Category3VO ca, Model model) throws Exception {
		logger.info("customer/customerServiceModify.jsp"+ca.getCno());
		model.addAttribute("modify", cservice.customerServiceDetail(ca.getCno()));
	}
	
	//���� �Ҹ� + �ۼ��� ����
	@RequestMapping(value="/customerServiceModifyEnd", method = RequestMethod.POST) //���� �Ҹ� + �ۼ��� �Ϸ�
	public String customerServiceModifyEnd(Category3VO ca, Model model) throws Exception {
		logger.info("customer/customerServiceModifyEnd.jsp : "+ca.getCno());
		cservice.customerServiceModify(ca);
		return "redirect:customerService";
	}
	
	//���� �Ҹ� + �ۻ���
	@RequestMapping(value="/customerServiceDelete", method = RequestMethod.GET) //Ʈ��� �ҽ� + �ۻ���
	public String customerServiceDelete(int cno, Model model) throws Exception {
		System.out.println("--- ���� �Ҹ� + �ۻ��� ---");
		logger.info("customer/customerServiceDelete.jsp : " + cno);
		cservice.customerServiceDelete(cno);
		return "redirect:customerService";
	}
	
	/* ���� �Ҹ� ��۴ޱ� */
	
	//���� �Ҹ� + ��� ��ȸ�� customserServiceDetail���� ���� �ε�.
	
	//���� �Ҹ� + ��� ���
	@ResponseBody
	@RequestMapping(value="/commentsWrite", method = RequestMethod.POST)
	public void commentsWrite(@RequestBody CommentsVO comments, Model model) throws Exception {
		System.out.println("--- ���� �Ҹ� + ��� ��� ---");
		System.out.println(comments);
		cservice.commentsWrite(comments);
	}
	
	//���� �Ҹ� + ��� ����
	@ResponseBody
	@RequestMapping(value="/commentsModify", method = RequestMethod.POST)
	public void commentsModify(@RequestBody CommentsVO comments, Model model) throws Exception {
		System.out.println("--- ���� �Ҹ� + ��� ���� ---");
		System.out.println("commensVO : "+comments);
		cservice.commentsModify(comments);
	}

	//���� �Ҹ� + ��� ����
	@ResponseBody
	@RequestMapping(value="/commentsDelete", method = RequestMethod.POST)
	public void commentsDelete(@RequestBody CommentsVO comments, Model model) throws Exception {
		System.out.println("--- ���� �Ҹ� + ��� ���� ---");
		System.out.println("commensVO : "+comments);
		cservice.commentsDelete(comments);
	}
}
	
	
	

