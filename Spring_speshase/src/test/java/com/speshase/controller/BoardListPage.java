package com.speshase.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.speshase.model.BoardVO;
import com.speshase.model.Criteria;
import com.speshase.service.BoardService;

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
	public class BoardListPage {
		@Autowired
		private BoardService boardservice;
		
		@Test
		public void testPaing() throws Exception {
			Criteria cri = new Criteria();
			
			cri.setPageNum(1);
			cri.setAmount(10);
			
			List<BoardVO> list=boardservice.boardListPaging(cri);
			
			list.forEach(board->Logger.getLogger(""+board));
			
		}
}