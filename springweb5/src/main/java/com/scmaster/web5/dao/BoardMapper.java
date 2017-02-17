package com.scmaster.web5.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.scmaster.web5.vo.Board;

public interface BoardMapper {
	
	public int insertBoard(Board board);
	public ArrayList<HashMap<String, Object>> boardList();
	public Board read(int boardnum);

}
