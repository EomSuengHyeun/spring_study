package com.board.service;

import java.util.List;

import com.board.dto.BoardVO;

public interface BoardService {
	
	public void create(BoardVO board)throws Exception;
	public BoardVO read(int bno)throws Exception;
	public void modify(BoardVO board)throws Exception;
	public void remove(int bno)throws Exception;
	public List<BoardVO> listAll()throws Exception;
}
