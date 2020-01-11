package com.speshase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.speshase.model.BoardVO;
import com.speshase.model.Criteria;
import com.speshase.model.PageVO;
import com.speshase.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	/* 게시글 목록 리스트
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGet(Model model) throws Exception {
		model.addAttribute("list",bservice.boardList()); //list에 저장 해서 실어 보내리..
														 //request.setAttribute와 같은 역할
		logger.info("list 결과="+bservice.boardList());
	} */
	
	/* 게시글목록 리스트(페이징 처리 된거) */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGet(Criteria cri, Model model) throws Exception {
		
		int total = bservice.boardCount(cri); //(PageVO.class의 total과 같아야함)
		PageVO pv = new PageVO(cri, total);
		logger.info("bservice.boardListPaging(cri)="+bservice.boardListPaging(cri));
		logger.info("pv="+pv);
		logger.info("total="+total);
		logger.info("keyword="+cri.getKeyword());
		model.addAttribute("list",bservice.boardListPaging(cri));
		model.addAttribute("page",pv);
	}

	/* 글쓰기를 위한 controller */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registGet() throws Exception {
		logger.info("regist get......");
		return "board/write";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	//파일업로드가 아닌 것(board), 파일업로드인 것 둘 다 처리(file)
	public String registPOST(BoardVO board) throws Exception {
		logger.info("regist post......");
		
		//파일이름을 String으로 저장.
		String filename=board.getFilename().getOriginalFilename();
		logger.info("regist post......"+board.getSubject());
		logger.info("regist post......"+filename);
		
		bservice.boardWrite(board, filename); //글쓰기 한 후
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	//public void detailGet(BoardVO board, Model model) throws Exception {
	public void detailGet(BoardVO board, Model model) throws Exception {	
		logger.info("detail get......"+board.getNo());
		model.addAttribute("detail",bservice.boardDetail(board.getNo()));
	}
	/* 다른방식 같은 결과
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public void detailGet(@RequestParam int no, Model model) throws Exception {
		logger.info("detail get......"+no);
		model.addAttribute("detail",bservice.boardDetail(no));
	}*/
	
	@RequestMapping(value="/return", method=RequestMethod.GET)
	public String returnGet() throws Exception {
		logger.info("return get......");
		return "redirect:list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGet(BoardVO board, Model model) throws Exception {
		logger.info("modify get......");
		model.addAttribute("modify",bservice.boardDetail(board.getNo()));
		//return "redirect:detail?no="+board.getNo();
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("modify post......"+board.getNo());
		bservice.boardModify(board);
		//rttr.addFlashAttribute("no", board.getNo());
		return "redirect:detail?no="+board.getNo();
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteGet(BoardVO board, Model model) throws Exception {
		logger.info("no="+board.getNo());
		bservice.boardDel(board);
		//model.addAttribute("delete",bservice.boardDel(board.getNo()));
		//rttr.addFlashAttribute("no", board.getNo());
		return "redirect:list";
	}
	
	@RequestMapping(value="/replyBoard", method=RequestMethod.GET)
	public void replyGET() throws Exception {
		logger.info("aaa");
	}
}
