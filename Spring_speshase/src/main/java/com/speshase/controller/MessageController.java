package com.speshase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.speshase.model.MessageVO;
import com.speshase.service.MessageService;

@RestController
@RequestMapping(value="messages")
public class MessageController {
	@Autowired
	private MessageService service;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
		ResponseEntity<String> entity = null;
		
		try {
			service.addMessage(vo);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
