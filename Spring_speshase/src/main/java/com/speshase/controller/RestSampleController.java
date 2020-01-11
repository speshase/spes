package com.speshase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.speshase.model.SampleVO;

//@Annotation(������̼�) : �ڹٰ� �ؼ��� �� �̰� � �������� �˷��ִ� ����.
@RestController
@RequestMapping("/sample")
public class RestSampleController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	/* �ܼ� ���ڿ� ��ȯ�ϴ� ���*/
	@RequestMapping(value="/hello", produces="text/plain;charset=UTF-8")
	public String sayHello() {
		logger.info("MIME TYPE : "+MediaType.TEXT_PLAIN_VALUE);
		return "Hello world!!";
	}
	
	/* ��ü ��ȯ */
	@RequestMapping(value="/sendVO", produces = "application/json")
	public SampleVO sendVO() {
		SampleVO vo = new SampleVO();
		vo.setFirstName("����");
		vo.setLastName("��");
		vo.setMno(3);
		return vo;
	}
	
	/* �÷��� Ÿ���� ��ü ��ȯ - ArrayList*/
	@RequestMapping("/sendList")
	public List<SampleVO> sendList() {
		
		List<SampleVO> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("����");
			vo.setLastName("��");
			vo.setMno(3);
			list.add(vo);
		}
		return list;
	}
	
	/* �÷��� Ÿ���� ��ü ��ȯ - HashMap */
	@RequestMapping("/sendMap")
	     //Map<Ű, ���� Ÿ��>
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer, SampleVO> map = new HashMap<>();
		for(int i=0; i<5; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("����");
			vo.setLastName("��");
			vo.setMno(3);
			map.put(i, vo);
		}
		return map;
	}
	
	/* @PathVariable : URL����� �Ϻθ� �Ķ����(��)�� ����� �� �̿� */
	@RequestMapping("/member/{last}/{first}")
	public String[] getMember(@PathVariable("last")String last, @PathVariable("first")String first) {
		String[] member = new String[] {"lastname : "+last, "fristname : "+first};
		return member;
	}
	
	 /* @RequestBody : JSON �����͸� ���ϴ� Ÿ���� ��ü�� ��ȯ�ؾ� �ϴ� ��쿡 �ַ� ��� */
	 @RequestMapping(value="/memberRequestBody", method = RequestMethod.POST)
	 //@PostMapping("/memberRequestBody")
	 public SampleVO convert(@RequestBody SampleVO sv) {
	  logger.info("member RequestBody.....="+sv);
	  return sv;
	 }
	
	
}
