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

//@Annotation(어노테이션) : 자바가 해석할 때 이게 어떤 문법인지 알려주는 역할.
@RestController
@RequestMapping("/sample")
public class RestSampleController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	/* 단순 문자열 반환하는 경우*/
	@RequestMapping(value="/hello", produces="text/plain;charset=UTF-8")
	public String sayHello() {
		logger.info("MIME TYPE : "+MediaType.TEXT_PLAIN_VALUE);
		return "Hello world!!";
	}
	
	/* 객체 반환 */
	@RequestMapping(value="/sendVO", produces = "application/json")
	public SampleVO sendVO() {
		SampleVO vo = new SampleVO();
		vo.setFirstName("은진");
		vo.setLastName("김");
		vo.setMno(3);
		return vo;
	}
	
	/* 컬렉션 타입의 객체 반환 - ArrayList*/
	@RequestMapping("/sendList")
	public List<SampleVO> sendList() {
		
		List<SampleVO> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("은진");
			vo.setLastName("김");
			vo.setMno(3);
			list.add(vo);
		}
		return list;
	}
	
	/* 컬렉션 타입의 객체 반환 - HashMap */
	@RequestMapping("/sendMap")
	     //Map<키, 값의 타입>
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer, SampleVO> map = new HashMap<>();
		for(int i=0; i<5; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("은진");
			vo.setLastName("김");
			vo.setMno(3);
			map.put(i, vo);
		}
		return map;
	}
	
	/* @PathVariable : URL경로의 일부를 파라미터(값)로 사용할 때 이용 */
	@RequestMapping("/member/{last}/{first}")
	public String[] getMember(@PathVariable("last")String last, @PathVariable("first")String first) {
		String[] member = new String[] {"lastname : "+last, "fristname : "+first};
		return member;
	}
	
	 /* @RequestBody : JSON 데이터를 원하는 타입의 객체로 변환해야 하는 경우에 주로 사용 */
	 @RequestMapping(value="/memberRequestBody", method = RequestMethod.POST)
	 //@PostMapping("/memberRequestBody")
	 public SampleVO convert(@RequestBody SampleVO sv) {
	  logger.info("member RequestBody.....="+sv);
	  return sv;
	 }
	
	
}
