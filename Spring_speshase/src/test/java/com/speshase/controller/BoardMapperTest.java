package com.speshase.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.speshase.mapper.BoardMapper;
import com.speshase.model.BoardVO;
	
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
	
	public class BoardMapperTest {
		@Autowired
		private BoardMapper boardMapper;
		
		@Test
		public void testGetBoardList() throws Exception {
			//System.out.println(timeMapper.getTime());
			Logger.getLogger(""+boardMapper.boardList());
		}
		
		@Test
		public void testGetBoardDetail() throws Exception {
			BoardVO board = boardMapper.boardDetail(10);
			Logger.getLogger(""+board);
		}
		
		@Test
		public void testGetBoardWrite() throws Exception {
			BoardVO board = new BoardVO();
			String filename=board.getFilename().getOriginalFilename();
			board.setSubject("제목입니다.");
			board.setContent("내용입니까.");
			board.setWriter("작성자일걸요");
			board.setCnt(1);
			
			boardMapper.boardWrite(board, filename);
		}
		
		@Test
		public void testGetBoardModify() throws Exception {
			BoardVO board = new BoardVO();
			board.setSubject("제목입니다.000");
			board.setContent("내용입니까.000");
			board.setNo(15);
			
			boardMapper.boardModify(board);
		}
		
		@Test
		public void testGetBoardDel() throws Exception {
			BoardVO board = new BoardVO();
			board.setNo(21);
			
			boardMapper.boardDel(board);
		}
}