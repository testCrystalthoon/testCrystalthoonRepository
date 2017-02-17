package com.scmaster.web5.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.web5.dao.BoardDAO;
import com.scmaster.web5.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO bDao;

	@RequestMapping(value="boardlist", method=RequestMethod.GET)
	public String boardList(Model model) {
		ArrayList<HashMap<String, Object>> boardlist = new ArrayList<>();
		boardlist = bDao.boardList();
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
