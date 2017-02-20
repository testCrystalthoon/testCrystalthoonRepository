package com.scmaster.web5.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.web5.vo.Board;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlsession;
	
	public int insertBoard(Board board) {
		int result = 0;
		BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
		result = mapper.insertBoard(board);
		return result;
	}
	
	public ArrayList<HashMap<String, Object>> boardList(int startRecord, int countPerPage) {
		ArrayList<HashMap<String, Object>> boardlist = new ArrayList<>();
		BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
		RowBounds rb = new RowBounds(startRecord, countPerPage);  // offset-시작위치, limit-몇 개
		
		boardlist = mapper.boardList(rb);
		return boardlist;
	}
	
	public Board read(int boardnum) {
		Board board = null;
		BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
		board = mapper.read(boardnum);
		return board;
	}
	
	public int totalCount() {
		int result = 0;
		BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);
		result = mapper.totalCount();
		return result;
	}
}
