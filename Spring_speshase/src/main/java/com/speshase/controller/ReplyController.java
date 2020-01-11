package com.speshase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.speshase.model.Criteria;
import com.speshase.model.PageVO;
import com.speshase.model.ReplyVO;
import com.speshase.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Inject
	private ReplyService rservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="", method=RequestMethod.POST) //POST -> �ű��ڷ� ��� insert�� �� ���.
	public ResponseEntity<String> register(@RequestBody ReplyVO vo){
		logger.info("ReplyVO : "+vo);
		ResponseEntity<String> entity = null;
		try {
			rservice.RepWrite(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	/* ��� ����Ʈ ����(����¡ó��X) */
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") int bno) {
		logger.info("ReplyVO : "+bno);
		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<List<ReplyVO>>(rservice.Replylist(bno), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/* ��� ����Ʈ ����(����¡ó��O) */
	@RequestMapping(value="/{bno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("bno") int bno,
												  @PathVariable("page") int page) {
		logger.info("ReplyVO : "+bno);
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			Criteria cri = new Criteria();
			cri.setPageNum(page);
			int cnt=rservice.count(bno);
			PageVO pv = new PageVO(cri, cnt);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<ReplyVO> list=rservice.listPage(bno, cri);
			
			map.put("list", list); //�Խ��� ����Ʈ
			map.put("page", page); //����¡ ����
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			System.out.println("entity = "+entity);
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//��ۼ���
	@RequestMapping(value="/{rno}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> register(@PathVariable("rno") int rno,
										   @RequestBody ReplyVO vo){
		logger.info("ReplyVO : "+rno);
		ResponseEntity<String> entity = null;
		try {
			vo.setRno(rno);
			rservice.RepModify(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//��ۻ���
	@RequestMapping(value="/{rno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno") int rno) {
		logger.info("ReplyVO : "+rno);
		ResponseEntity<String> entity = null;
		try {
		rservice.RepDel(rno);
		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
		e.printStackTrace();
		entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
