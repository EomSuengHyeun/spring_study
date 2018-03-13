package com.board.dao;

import java.util.List;

import com.board.dto.BoardVO;

public interface BoardDAO {
	
	public void insertBoard(BoardVO board)throws Exception;
	public BoardVO selectBoardByBNO(int bno)throws Exception;
	public void updateBorad(BoardVO board)throws Exception;
	public void deleteBoard(int bno)throws Exception;
	public List<BoardVO> selectBoardAll()throws Exception;
	
}








