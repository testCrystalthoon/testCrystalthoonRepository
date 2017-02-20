package com.scmaster.web5.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scmaster.web5.dao.BoardDAO;
import com.scmaster.web5.util.PageNavigator;
import com.scmaster.web5.vo.Board;

@Controller
public class BoardController {
	
	final int countPerPage = 10; //페이지 당 글 수
	final int pagePerGroup = 5; //페이지 이동 그룹 당 표시할 페이지 수
	
	
	@Autowired
	private BoardDAO bDao;

	@RequestMapping(value="boardlist", method=RequestMethod.GET)
	public String boardList(Model model, @RequestParam(value="page", defaultValue="1") int page) {
		//전체 글의갯수
		int totalResult = bDao.totalCount();
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, totalResult);

		
		ArrayList<HashMap<String, Object>> boardlist = new ArrayList<>();
		boardlist = bDao.boardList(navi.getStartPageGroup(), navi.getCountPerPage()); // (첫번째 글번호, 페이지 당 글수)
		model.addAttribute("boardlist", boardlist);
		System.out.println(boardlist);
		return "board/boardList";
	}
	
	@RequestMapping(value="boardWriteForm", method=RequestMethod.GET)
	public String boardWriteForm() {
		
		
		return "board/writeForm";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String boardWrite(Board board, HttpSession session) {
		String id = (String)session.getAttribute("id"); //session은 Object타입
		board.setId(id);
		int result = bDao.insertBoard(board);
		if(result != 1) {
			return "board/writeForm";
		} else {
			return "redirect:boardlist";
		}
	}
	
	@RequestMapping(value="read", method=RequestMethod.GET)
	public String read(int boardnum) {
		Board board = bDao.read(boardnum);
		return "";
	}
}
